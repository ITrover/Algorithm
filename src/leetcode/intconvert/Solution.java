package leetcode.intconvert;//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
// 示例 1:
//
// 输入: 123
//输出: 321
//
//
// 示例 2:
//
// 输入: -123
//输出: -321
//
//
// 示例 3:
//
// 输入: 120
//输出: 21
//
//
// 注意:
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
// Related Topics 数学

/**
 * 使用数学反转
 * 用long保存结果防止溢出
 * 判断大小，再返回
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        // 用一个数组来保存每个位，让后返回来将其组成数字
        boolean pos = true;
        // 去符号
        if (x < 0){
            x = -x;
            pos = false;
        }
        // 确认整数有多少位
        int i = 0;
        for (; i < 32; i++) {
            if ((x - pow(10,i) + 1) <= 0){
                break;
            }
        }
        int length = i;
        int[] is = new int[length];
        // 整数变成数组
        // 小的在前面
        for (int j = 0; j < length; j++) {
//            int mutiple = pow(10,j + 1);
            is[j] = x%(10);
            x=x/(10);
        }
        // 数组变成整数
        // 小的为最大的,最大为最小
        // 使用long防止溢出
        long result = 0L;
        // 考虑越界的问题
        for (int j = length - 1; j >= 0; j--) {
            long mutiple = pow(10L,length -1 - j);
            result += is[j]*(mutiple);
        }
        if (result < Integer.MAX_VALUE){
            if (!pos){
                result = -result;
            }
            return (int)result;
        }else {
            return 0;
        }
    }
    long pow(long x, int mutiple){
        if (mutiple == 0){
            return 1;
        }
        if (mutiple == 1){
            return x;
        }
        return x*pow(x,mutiple-1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
