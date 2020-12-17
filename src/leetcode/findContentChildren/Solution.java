package leetcode.findContentChildren;

import java.util.Arrays;

/**
 * @author itrover
 * 455. 分发饼干 https://leetcode-cn.com/problems/assign-cookies/
 * 排序 + 贪心算法
 */
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // 排序
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int res = 0;
        // 如果当前的小饼干可以满足当前胃口的小朋友，则给他
        // 否则，挑选下一个饼干，直到满足当前最小胃口的小朋友
        while(i < g.length && j < s.length){
            if(s[j] >= g[i]){
                res++;
                i++;
            }
            j++;
        }
        return res;
    }
}
