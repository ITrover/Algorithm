package everyday.prefixesDivBy5;

import java.util.ArrayList;
import java.util.List;

/**
 * 1018. 可被 5 整除的二进制前缀 https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/
 * 模拟，暴力求解
 * 计算出每个值，再通过余判断是否满足条件
 */
class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<Boolean>();
        int prefix = 0;
        int length = A.length;
        for (int j : A) {
            prefix = ((prefix << 1) + j) % 5;
            list.add(prefix == 0);
        }
        return list;
    }
}
