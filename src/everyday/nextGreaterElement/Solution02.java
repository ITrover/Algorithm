package everyday.nextGreaterElement;

import java.util.*;

/**
 * @author itrover
 * 496. 下一个更大元素 I https://leetcode-cn.com/problems/next-greater-element-i/
 * 哈希表 + 单调栈
 */
class Solution02 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 记录第一个大于nums2[i]的值
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            // 将栈中小于num的都弹出，只留下第一个大于当前num的元素
            while (!stack.isEmpty() && stack.peek() < num) {
                stack.pop();
            }
            // 如果栈为空，那么栈顶的值就是位于num右边第一个大于num的值
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
