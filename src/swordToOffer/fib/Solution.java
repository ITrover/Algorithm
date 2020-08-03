package swordToOffer.fib;

/**
 * 递归法
 * 超时
 * 时间复杂度 0
 */


class Solution {


    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return (fib(n - 1) + fib(n - 2)) % 1000000007;
    }
}
