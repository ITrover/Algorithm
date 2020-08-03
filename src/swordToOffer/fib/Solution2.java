package swordToOffer.fib;

/**
 * 线性算法
 * 用两个变量记录之前的值，一直累加到问题需要求解的数
 * 时间复杂度o(n)
 */
class Solution2 {
    public int fib(int n) {
        if (n <= 1){
            return 1;
        }
        int last = 1;
        int nextToLast = 1;
        int answer = 1;
        for (int i = 2; i <= n; i++) {
            answer = (last + nextToLast) % 1000000007;
            nextToLast = last;
            last = answer;
        }
        return answer;
    }


}
