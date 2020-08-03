package swordToOffer.add;

/**
 * 位运算
 * 和递归
 */
class Solution2 {
    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }

        // 转换成非进位和 + 进位
        return add(a ^ b, (a & b) << 1);
    }
}
