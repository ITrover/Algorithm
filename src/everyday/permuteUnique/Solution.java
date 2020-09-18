package everyday.permuteUnique;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author itrover
 */
class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        permuteUnique(nums,0);
        return res;
    }

    void permuteUnique(int[] nums, int index){
        if (index == nums.length){
            // 添加结果
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i])){
                // 减枝
                continue;
            }
            set.add(nums[i]);
            swap(nums,i,index);
            permuteUnique(nums,index + 1);
            swap(nums,i,index);
        }
    }

    void swap(int[] c, int a, int b){
        int tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.permuteUnique(new int[]{1,1,2});
    }
}