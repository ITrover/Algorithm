package everyday.partitionLabels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author itrover
 * 763. 划分字母区间 https://leetcode-cn.com/problems/partition-labels/
 * 改用数组保存最右边的位置
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution2 {
    public List<Integer> partitionLabels(String S) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        int start = 0,end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end){
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
