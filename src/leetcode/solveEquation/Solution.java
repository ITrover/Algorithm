package leetcode.solveEquation;

/**
 * @author itrover
 * 640. 求解  方程 https://leetcode-cn.com/problems/solve-the-equation/
 * 字符串
 */
class Solution {

    private static final String NO_SOLUTION = "No solution";
    private static final String INFINITE_SOLUTION = "Infinite solutions";

    public String solveEquation(String equation) {
        // 去除空格
        equation = removeSpace(equation);
        // 通过=号把x和数字放两边
        String[] splits = equation.split("=");
        // 一定有等号，所以能够拆成左右
        Node left = split(splits[0]);
        Node right = split(splits[1]);
        // 把x都放在做左边
        left.xs -= right.xs;
        // 把数字都放在右边
        right.ns -= left.ns;
        if (left.xs == 0) {
            return right.ns == 0 ? INFINITE_SOLUTION : NO_SOLUTION;
        }
        return "x=" + right.ns / left.xs;
    }

    String removeSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    private class Node {
        /**
         * 数字
         */
        public int ns;
        /**
         * x的个数
         */
        public int xs;

        public Node(int ns, int xs) {
            this.ns = ns;
            this.xs = xs;
        }
    }

    Node split(String s) {
        if (s == null || s.length() == 0) {
            return new Node(0, 0);
        }
        // 数字
        int ns = 0;
        // x的个数
        int xs = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); ) {
            int number = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                number *= 10;
                number += s.charAt(i) - '0';
                i++;
            }
            if (i < s.length() && s.charAt(i) == 'x') {
                // x单独出现
                if (number == 0 && (i == 0 || !Character.isDigit(s.charAt(i - 1)))) {
                    number = 1;
                }
                xs += sign * number;
                i++;
            } else {
                ns += sign * number;
            }
            // 下一个数字的符号
            if (i < s.length()) {
                sign = s.charAt(i) == '-' ? -1 : 1;
                i++;
            }
        }
        return new Node(ns, xs);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveEquation("2x+3x-6x=x+2"));
        System.out.println(solution.solveEquation("0x=0"));
    }
}
