package everyday.nearestPalindromic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author itrover
 * 564. 寻找最近的回文数 https://leetcode-cn.com/problems/find-the-closest-palindrome/
 * 将低位用高位反转后的数代替，构造回文数
 * 构造的回文数比原数大，如99200，回文数为99299,此时99199与原数更接近
 * 构造的回文数比原数小，如11299，回文数为11211,此时11311与原数更接近
 * 位数不一样的情况
 * 99 101
 * 100 99
 * 所以最临近的回文为
 * 1. 前缀 + 前缀反转
 * 2. (前缀-1) + (前缀-1)反转
 * 3. (前缀+1) + (前缀+1)反转
 * 4. 形如10..01
 * 5. 形如9..9
 */
class Solution {
    public String nearestPalindromic(String n) {
        List<Long> candidates = getCandidates(n);
        long res = -1;
        long number = Long.parseLong(n);
        for (Long candidate : candidates) {
            if (candidate != res && candidate != number) {
                if (res == -1 || Math.abs(candidate - number) < Math.abs(res - number)
                        || Math.abs(candidate - number) == Math.abs(res - number) && candidate < res) {
                    res = candidate;
                }
            }
        }
        return String.valueOf(res);
    }

    List<Long> getCandidates(String n) {
        int len = n.length();
        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        ArrayList<Long> res = new ArrayList<>();
        // 99...99
        res.add((long) (Math.pow(10, len - 1) - 1));
        // 10..01
        res.add((long) (Math.pow(10, len) + 1));
        for (long i = prefix - 1; i <= prefix + 1; i++) {
            StringBuilder suffix = new StringBuilder();
            suffix.append(i);
            suffix.reverse();
            String sb = i +
                    suffix.substring(len & 1);
            res.add(Long.parseLong(sb));
        }
        return res;
    }
}
