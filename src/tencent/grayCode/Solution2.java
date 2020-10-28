package tencent.grayCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/10/28 20:49
 * @description
 * 89. 格雷编码 https://leetcode-cn.com/problems/gray-code/
 * 公式法
 * 时间复杂度o(2^n)
 * 空间复杂度o(1)
 * 二进制数b 对应的格雷码g
 * 保留高位 g(n-1) = b(n-1)
 * 其余各位 g(i) = b(i + 1) ^ b(i)
 */
public class Solution2 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0;i < 1 << n; i++){
            res.add(i ^ i >> 1);
        }
        return res;
    }
}
