package everyday.addToArrayForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author itrover
 * 989. 数组形式的整数加法 https://leetcode-cn.com/problems/add-to-array-form-of-integer/
 * 使用栈（Java的Stack 效率低）
 */
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        Stack<Integer> stack = new Stack<>();
        int last = 0;
        int i = A.length - 1;
        while (i >= 0 || K > 0) {
            int base = last;
            if (K > 0) {
                base += K % 10;
                K /= 10;
            }
            if (i >= 0) {
                base = A[i] + base;
                i--;
            }
            stack.push(base % 10);
            last = base / 10;
        }
        // 进位
        if (last > 0) {
            stack.push(last);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
}
