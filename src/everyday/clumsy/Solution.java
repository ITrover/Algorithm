package everyday.clumsy;

/**
 * @author itrover
 * 1006. 笨阶乘 https://leetcode-cn.com/problems/clumsy-factorial/
 * 遍历，暴力
 */
class Solution {
    public int clumsy(int N) {
        if (N <= 3) {
            return solveLt3(N);
        }
        int res = f1(N--, N--, N--) + N--;
        while (N >= 3) {
            res -= f1(N--, N--, N--);
            res += N--;
        }
        res -= solveLt3(N);
        return res;
    }

    int f1(int a, int b, int c) {
        return a * b / c;
    }

    int solveLt3(int N) {
        if (N <= 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
            return N * (N - 1);
        }
        return N * (N - 1) / (N - 2);
    }

}
