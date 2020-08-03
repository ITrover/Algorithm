package swordToOffer.majorityElement;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/7/22 20:05
 */

/**
 * 如果存在超过一半的数
 * 那么那个书一定出现再中间位置
 *
 * 利用快速排序的特点
 * 时间复杂度 o(n) < o < o(nlog(n))
 * 空间复杂度 o(1)
 */
public class Solution3 {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        int half = nums.length >> 1;
        while (index != half){
            if (index > half){
                end = index - 1;
                index = partition(nums, start, end);
            }else {
                start = index + 1;
                index = partition(nums, start, end);
            }
        }
        int result = nums[index];
        if (checkMoreThanHalf(nums,result)){
            return result;
        }
        return 0;
    }

    public int partition(int[] nums, int start, int end) {
        // 中轴
        int tmp = nums[start];
        while (start < end) {
            // 右边开始找，一直找到小于tmp的位置
            while (start < end && nums[end] > tmp) {
                end--;
            }
            // 赋给中轴位置更小的值
            nums[start] = nums[end];
            // 一直找直到找到左边大于tmp的位置
            while (start < end && nums[start] <= tmp) {
                start++;
            }
            // 左边出现了比tmp大的数
            nums[end] = nums[start];
        }
        nums[start] = tmp;
        // 返回的是中轴的位置
        return start;
    }


    public boolean checkMoreThanHalf(int[] nums, int k) {
        int times = 0;
        int half = nums.length / 2;
        for (int num : nums) {
            if (num == k) {
                times++;
                if (times > half) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        solution3.majorityElement(new int[]{-1,100,2,100,100,4,100});
    }
}
