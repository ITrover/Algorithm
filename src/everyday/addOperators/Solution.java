package everyday.addOperators;

import java.util.ArrayList;
import java.util.List;

/**
 * @author itrover
 * 282. 给表达式添加运算符 https://leetcode-cn.com/problems/expression-add-operators/
 * 回溯
 */
class Solution {
    int n;
    String num;
    int target;
    List<String> ans;

    public List<String> addOperators(String num, int target) {
        this.n = num.length();
        this.num = num;
        this.target = target;
        this.ans = new ArrayList<String>();
        StringBuffer expr = new StringBuffer();
        backtrack(expr, 0, 0, 0);
        return ans;
    }

    /**
     * @param expr 表达式
     * @param i 字符串开始位置
     * @param res 目前的值
     * @param mul 上一个加的数，用于乘法时使用
     */
    public void backtrack(StringBuffer expr, int i, long res, long mul) {
        if (i == n) {
            if (res == target) {
                ans.add(expr.toString());
            }
            return;
        }
        int signIndex = expr.length();
        if (i > 0) {
            // 占位，下面填充符号
            expr.append(0);
        }
        long val = 0;
        // 枚举截取的数字长度（取多少位），注意数字可以是单个 0 但不能有前导零
        for (int j = i; j < n && (j == i || num.charAt(i) != '0'); ++j) {
            // 当前参与运算的数
            val = val * 10 + num.charAt(j) - '0';
            expr.append(num.charAt(j));
            // 表达式开头不能添加符号
            if (i == 0) {
                backtrack(expr, j + 1, val, val);
            } else { // 枚举符号
                expr.setCharAt(signIndex, '+');
                backtrack(expr, j + 1, res + val, val);
                expr.setCharAt(signIndex, '-');
                backtrack(expr, j + 1, res - val, -val);
                expr.setCharAt(signIndex, '*');
                // 由于乘法的优先级高
                // 这里先减去上一步增加的数，再与之相乘后相加
                backtrack(expr, j + 1, res - mul + mul * val, mul * val);
            }
        }
        expr.setLength(signIndex);
    }
}
