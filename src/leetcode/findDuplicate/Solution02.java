package leetcode.findDuplicate;

/**
 * @author itrover
 * 287. 寻找重复数 https://leetcode-cn.com/problems/find-the-duplicate-number/
 * 若有重复数，那么就存在多对一的映射
 * 快慢指针，类似于循环链表
 */
class Solution02 {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // 找到环中的元素了
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        System.out.println(solution02.findDuplicate(new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1}));
    }
}
