package leetcode.findmedian;//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法

/**
 * 找到中位数就可以停止了
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 写一个merge 算法，把两个数组合在一起，时间复杂度为o(m+n)
        int[] num = new int[nums1.length + nums2.length];
        return merge(nums1,nums2,num);

    }
    // 代码可以优化，删去重复代码
    double merge(int[] nums1, int[] nums2,int[] num){
        //在哪里停止
        //当新数组的长度刚好大于长度中值时停止
        int len1 = 0;
        int len2 = 0;
        int i = 0;
        int total = nums1.length + nums2.length;
        int medium = (nums1.length + nums2.length) / 2;
        while(len1 < nums1.length && len2 < nums2.length){
            if (nums1[len1] < nums2[len2]){
                num[i] = nums1[len1];
                len1++;
            }else{
                num[i] = nums2[len2];
                len2++;
            }
            if (i == medium){
                //中位数已找到
                if (total % 2 != 0){
                    //奇数
                    return num[i];
                }else{
                    return (num[i -1] + num[i])/2.0;
                }
            }
            i ++;
        }
        while(len1 < nums1.length){
            num[i] = nums1[len1];
            len1++;
            if (i == medium){
                //中位数已找到
                if (total % 2 != 0){
                    return num[i];
                }else{
                    return (num[i -1] + num[i])/2.0;
                }
            }
            i++;
        }
        while(len2 < nums2.length){
            num[i] = nums2[len2];
            len2++;
            if (i == medium){
                //中位数已找到
                if (total % 2 != 0){
                    return num[i];
                }else{
                    return (num[i -1] + num[i])/2.0;
                }
            }
            i++;
        }
        return 0.0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
