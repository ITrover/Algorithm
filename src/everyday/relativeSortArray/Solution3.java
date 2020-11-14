package everyday.relativeSortArray;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author itrover
 * 1122. 数组的相对排序 https://leetcode-cn.com/problems/relative-sort-array/
 * 三次遍历，计数
 * 时间复杂度o(n)
 * 空间复杂度o(n)
 * 击败100%
 */
class Solution3 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] pos = new int[1001];
        // 记录arr1中数字的出现次数
        for (int num : arr1) {
            pos[num]++;
        }
        int[] res = new int[arr1.length];
        int i = 0;
        // 将出现在arr2中的arr1按照arr2中的顺序，添加到结果中
        for (int num : arr2) {
            while (pos[num]-- > 0) {
                res[i++] = num;
            }
        }
        // 最后没有在arr2中出现的部分
        for (int j = 0; j < pos.length; j++) {
            while (pos[j]-- > 0){
                res[i++] = j;
            }
        }
        return res;
    }
}
