package tencent.grayCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author itrover
 * 89. 格雷编码 https://leetcode-cn.com/problems/gray-code/
 * 数学推导
 * 下一阶(k)的格雷码等于上一位数的格雷码序列高位补0(对应十进制数不变) U 上一位数的格雷码序列倒序高位补1(对应十进制+2^k)
 */
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }
            head <<= 1;
        }
        return res;
    }
}
