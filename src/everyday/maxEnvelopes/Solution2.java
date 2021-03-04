package everyday.maxEnvelopes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author itrover
 * 354. 俄罗斯套娃信封问题 https://leetcode-cn.com/problems/russian-doll-envelopes/
 * 动态规划 + 二分查找
 */
class Solution2 {
    public int maxEnvelopes(int[][] envelopes) {
        // 这里需要注意
        // 当前面个的宽 == 后面个的宽时，那么要把大的放在前面，都不符合条件
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = envelopes.length;
        List<Integer> f = new ArrayList<Integer>();
        f.add(envelopes[0][1]);
        for (int i = 1; i < n; ++i) {
            int num = envelopes[i][1];
            if (num > f.get(f.size() - 1)) {
                f.add(num);
            } else {
                // 将前面的值修改成小的，那么就有可能装下更多的信封
                int index = binarySearch(f, num);
                f.set(index, num);
            }
        }
        return f.size();
    }

    public int binarySearch(List<Integer> f, int target) {
        int low = 0, high = f.size() - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (f.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
