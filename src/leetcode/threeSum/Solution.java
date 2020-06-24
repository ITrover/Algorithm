package leetcode.threeSum;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 暴力解法 （3次循环，判断加起来是否为0）
        // 时间复杂度 o(n^3)
        // 超时了
        List<List<Integer>> list = new ArrayList<>();
        // 提前排序好
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> alist = Arrays.asList(nums[i], nums[j], nums[k]);
                        // 去重
                        boolean add = true;
                        for (int l = 0; l < list.size(); l++) {
                            List<Integer> integers = list.get(l);
                            int num = 0;
                            for (int m = 0; m < 3; m++) {
                                if (alist.get(m).equals(integers.get(m))){
                                    num ++;
                                }else{
                                    break;
                                }
                            }
                            if (num == 3){
                                add = false;
                                break;
                            }
                        }
                        if (add) {
                            list.add(alist);
                        }
                    }
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
