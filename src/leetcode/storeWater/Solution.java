package leetcode.storeWater;

/**
 * @author itrov
 * LCP 33. 蓄水 https://leetcode-cn.com/problems/o8SXZn/
 * 贪心算法，补短板
 */
class Solution {
    public int storeWater(int[] bucket, int[] vat) {
        int res = Integer.MAX_VALUE;
        int n = bucket.length;
        int upgrade = 0;
        for (int i = 0; i < n; i++) {
            // 桶等于0的必须升级
            if (bucket[i] == 0) {
                bucket[i]++;
                // 如果这个桶对应的vat不为0，则升级+1
                if (vat[i] != 0) {
                    upgrade++;
                }
            }
        }
        // 处理bucket和vat都为0的情况
        while (upgrade + 1 < res) {
            int k = 0, index = 0;
            for (int i = 0; i < n; i++) {
                int t = vat[i] % bucket[i] == 0 ? vat[i] / bucket[i] : vat[i] / bucket[i] + 1;
                // 找到短板所在下标
                if (t > k) {
                    k = t;
                    index = i;
                }
            }
            // 更新答案
            res = Math.min(res, k + upgrade);
            bucket[index]++;
            upgrade++;
        }
        return res;
    }
}
