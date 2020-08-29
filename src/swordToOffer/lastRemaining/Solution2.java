package swordToOffer.lastRemaining;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/8/10 21:45
 */
class Solution2 {
    public int lastRemaining(int n, int m) {
        if (n < 1 || m < 1){
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
