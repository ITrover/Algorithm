package everyday.validUtf8;

/**
 * @author itrover
 * 393. UTF-8 编码验证 https://leetcode-cn.com/problems/utf-8-validation/
 * 位运算
 */
class Solution {

    static final int MASK8 = 1 << 7;

    public boolean validUtf8(int[] data) {
        int i = 0;
        int n = data.length;
        while (i < n) {
            int type = getType(data[i]);
            // 错误的情况
            if (type == -1) {
                return false;
            }
            // 检验后面几位
            for (int j = 1; j < type; j++) {
                if (i + j >= n || !test10(data[i + j])) {
                    return false;
                }
            }
            i += type;
        }
        return true;
    }


    boolean test10(int num) {
        // 判断10000000
        return (num & (MASK8)) == MASK8 && ((num >> 6) & 1) == 0;
    }

    int getType(int num) {
        if ((num & MASK8) == 0) {
            return 1;
        }
        // 检查开头有几个1
        int res = 0;
        int i = 7;
        while ((num & 1 << i) == (1 << i) && res <= 4) {
            i--;
            res++;
        }
        return res > 1 && res <= 4 ? res : -1;
    }
}
