package tencent.isPowerOfTwo;

/**
 * @author itrover
 * 231. 2的幂 https://leetcode-cn.com/problems/power-of-two/
 * 余
 */
class Solution2 {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }
        while(n > 0){
            if(n % 2 == 1 && n != 1){
                return false;
            }
            n /= 2;
        }
        return true;
    }
}
