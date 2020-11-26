package everyday.maximumGap;

import java.util.Arrays;

/**
 * @author MaYunHao
 * 164. 最大间距 https://leetcode-cn.com/problems/maximum-gap/
 * 桶排序
 * todo：理解算法,桶排序
 */
class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        // 找到最大值
        int minVal = Arrays.stream(nums).min().getAsInt();
        // 找到最小值
        int maxVal = Arrays.stream(nums).max().getAsInt();
        // 最大间隔，
        int d = Math.max(1, (maxVal - minVal) / (n - 1));
        int bucketSize = (maxVal - minVal) / d + 1;

        int[][] bucket = new int[bucketSize][2];
        for (int i = 0; i < bucketSize; ++i) {
            // 存储 (桶内最小值，桶内最大值) 对， (-1, -1) 表示该桶是空的
            Arrays.fill(bucket[i], -1);
        }
        for (int i = 0; i < n; i++) {
            int idx = (nums[i] - minVal) / d;
            if (bucket[idx][0] == -1) {
                bucket[idx][0] = bucket[idx][1] = nums[i];
            } else {
                bucket[idx][0] = Math.min(bucket[idx][0], nums[i]);
                bucket[idx][1] = Math.max(bucket[idx][1], nums[i]);
            }
        }
        int ret = 0;
        int prev = -1;
        for (int i = 0; i < bucketSize; i++) {
            if (bucket[i][0] == -1) {
                continue;
            }
            if (prev != -1) {
                ret = Math.max(ret, bucket[i][0] - bucket[prev][1]);
            }
            prev = i;
        }
        return ret;
    }
}


