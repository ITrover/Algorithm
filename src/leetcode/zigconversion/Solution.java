package leetcode.zigconversion;//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
//
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
//
// 请你实现这个将字符串进行指定行数变换的函数：
//
// string convert(string s, int numRows);
//
// 示例 1:
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
//
//
// 示例 2:
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G
// Related Topics 字符串



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        // 定义numRows个字符串
        // 按照z字型向字符串填值
        if (numRows == 1){
            return s;
        }
        StringBuilder[] strs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            strs[i] = new StringBuilder();
        }
        int length = s.length();
        // 记录当前行
        boolean down = true;
        // 记录行号
        int row = 0;
        for (int i = 0; i < length; i++) {
            strs[row].append(s.charAt(i));
            if (row == numRows - 1){
                down = false;
            }
            if (row == 0){
                down = true;
            }
            if (down){
                row++;
            }else{
                row--;
            }
        }
        //字符串拼接
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(strs[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        Solution solution = new Solution();
        System.out.println(solution.convert(s, 3));
    }


}
//leetcode submit region end(Prohibit modification and deletion)
