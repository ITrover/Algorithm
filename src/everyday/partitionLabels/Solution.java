package everyday.partitionLabels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author itrover
 * 763. 划分字母区间 https://leetcode-cn.com/problems/partition-labels/
 * 使用hashmap
 * 时间复杂度o(n)
 * 空间复杂度o(1) hashmap 最多保存26个字母
 */
class Solution {
    public List<Integer> partitionLabels(String S) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> last = new HashMap<>();
        for (int i = S.length() - 1; i >= 0; i--) {
            // 记录每个字符最右边的位置
            if (!last.containsKey(S.charAt(i))){
                last.put(S.charAt(i),i);
            }
        }
        int start = 0;
        while (start < S.length()) {
            // 左边第一个字母，对应右边最远的位置
            int end = last.get(S.charAt(start));
            for (int i = start + 1; i < end; i++) {
                // 找区间内的字符，最远出现的位置
                end = Math.max(end,last.get(S.charAt(i)));

            }
            res.add(end - start + 1);
            start = end + 1;
        }
        return res;
    }
}
