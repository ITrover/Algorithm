package everyday.fourSumCount;

import java.util.HashMap;
import java.util.Map;

/**
 * @author itrover
 * 454. 四数相加 II https://leetcode-cn.com/problems/4sum-ii/
 * 哈希表
 * 时间复杂度o(n^2)
 */
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        int len = A.length;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int a: A){
            for(int b: B){
                map.put(a+b,map.getOrDefault(a+b,0)+1);
            }
        }
        for(int c : C){
            for(int d : D){
                res += map.getOrDefault(-(c+d),0);
            }
        }
        return res;
    }
}
