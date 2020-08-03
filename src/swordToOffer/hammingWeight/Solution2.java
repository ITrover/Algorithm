package swordToOffer.hammingWeight;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/7/7 18:49
 */

public class Solution2 {
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

}
