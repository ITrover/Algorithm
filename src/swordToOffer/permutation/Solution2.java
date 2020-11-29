package swordToOffer.permutation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author itrover
 * 剑指 Offer 38. 字符串的排列 https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * 回溯、dfs、剪枝
 * 和第一个算法就是一样的，只是数组一个放在参数上，一个放在了属性里
 */
class Solution2 {
    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        permutation(c, 0);
        return res.toArray(new String[res.size()]);
    }

    void permutation(char[] str, int index) {
        if (index == str.length) {
            res.add(String.valueOf(str));
        } else {
            // 核心部分
            // 固定第一个，然后同后面所有依次交换
            // 深度优先
            HashSet<Character> set = new HashSet<>();
            for (int i = index; i < str.length; i++) {
                if (set.contains(str[i])) {
                    // 剪枝
                    // 避免相同的字符交换
                    continue;
                }
                set.add(c[i]);
                swap(i, index);
                permutation(str, index + 1);
                swap(i, index);
            }
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String[] abcs = solution.permutation("aab");
        for (String abc : abcs) {
            System.out.println(abc);
        }
    }

}
