package everyday.partition_palindrome;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author itrover
 * 131. 分割回文串 https://leetcode-cn.com/problems/palindrome-partitioning/
 * 回溯
 */
class Solution {
    public List<List<String>> partition(String s) {
        Deque<String> deque = new ArrayDeque<>();
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, deque, res);
        return res;
    }

    public void dfs(String s, int index, Deque<String> deque, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                deque.addLast(s.substring(index, i + 1));
                dfs(s, i + 1, deque, res);
                deque.pollLast();
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
