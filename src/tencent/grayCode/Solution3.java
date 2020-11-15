package tencent.grayCode;

import java.util.Arrays;
/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/10/28 20:49
 * @description 89. 格雷编码 https://leetcode-cn.com/problems/gray-code/
 * 递归
 */
public class Solution3 {
    public String[] getGray(int n) {
        if (n <= 0) {
            return new String[0];
        }
        // write code here
        String[] gradCode = new String[(1 << n)];
        // 第一个
        char[] code = new char[n];
        Arrays.fill(code, '0');
        gradCode[0] = new String(code);
        dfs(n, gradCode);
        return gradCode;
    }

    int dfs(int n, String[] gradCode) {
        // 递归终止条件
        if (n == 0) {
            return 1;
        }
        // 返回的是这次开始的位置
        int size = dfs(n - 1, gradCode);
        // 镜像添加
        // 偏移
        int k = size;
        for (int i = size - 1; i >= 0; i--) {
            char[] code = gradCode[i].toCharArray();
            code[code.length - n] = '1';
            gradCode[k] = new String(code);
            k++;
        }
        return k;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(Arrays.toString(s.getGray(3)));
    }
}
