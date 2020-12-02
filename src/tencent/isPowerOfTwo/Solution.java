package tencent.isPowerOfTwo;

/**
 * @author itrover
 * 231. 2的幂 https://leetcode-cn.com/problems/power-of-two/
 * 二进制
 * 2的幂，只能有一个位为1，其余全是0
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }
        // 2 的幂只只能有一个位为1，其余全是0
        int cnt = 0;
        while(n > 0){
            if((n & 1) == 1){
                cnt++;
            }
            n >>= 1;
        }
        return cnt == 1;
    }
}
