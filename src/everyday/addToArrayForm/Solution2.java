package everyday.addToArrayForm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author itrover
 * 989. 数组形式的整数加法 https://leetcode-cn.com/problems/add-to-array-form-of-integer/
 * 使用数组优化
 * 时间复杂度o(n)
 */
class Solution2 {
    static final int MAT_LENGTH = 10001;

    public List<Integer> addToArrayForm(int[] A, int K) {
        int[] tmp = new int[MAT_LENGTH];
        int last = 0;
        int i = A.length - 1;
        int l = 10000;
        // k通常比A位数小很多
        // 因此将i >= 0放在前面，减少判断
        // last > 0 单独成立的机会只有一次，放在最后
        while (i >= 0 || K > 0 || last > 0) {
            if (K > 0) {
                last += K % 10;
                K /= 10;
            }
            if (i >= 0) {
                last += A[i];
                i--;
            }
            tmp[l] = last % 10;
            last = last / 10;
            l--;
        }
        // TODO: 2021/1/22 还可以使用链表优化
        ArrayList<Integer> res = new ArrayList<>();
        for (int j = l + 1; j < MAT_LENGTH; j++) {
            res.add(tmp[j]);
        }
        return res;
    }
}
