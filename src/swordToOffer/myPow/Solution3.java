package swordToOffer.myPow;

import java.util.HashMap;
import java.util.Map;

/**
 * 分治法
 * 递归
 * 时间复杂度 log(n)
 * 超时
 * 内存溢出
 */
class Solution3 {

    private Map<Integer, Double> map = new HashMap<>();

    public double myPow(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return pow(x, n);
    }

    public double pow(double x, int n) {
        if (x ==0 ){
            // 没有意义，直接退出
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        int n1 = n / 2;
        int n2 = n - n1;
        // 拆成两个
        // 折半乘
        // 记忆
        Double r1 = map.getOrDefault(n1, pow(x, n1));
        Double r2 = map.getOrDefault(n2, pow(x, n2));
        return r1*r2;
    }

    public static void main(String[] args) {
//        Solution3 solution2 = new Solution3();
//        System.out.println(solution2.myPow(-2, -4));
        double x = 0.0001;
        for (int i = 0; i < 100; i++) {
            x *=x;
        }
        System.out.println(x);
    }
}
