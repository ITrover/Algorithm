package swordToOffer.myAtoi;

/**
 * 字符串操作
 * 首先找到合法的连续字符串
 * 然后转化为整数
 * 时间复杂度 o(n)
 */
class Solution {
    private final static String legalChar = " +-0123456789";

    public int myAtoi(String str) {
        StringBuilder number = new StringBuilder();
        String intChar = legalChar.substring(3);
        boolean isContinue = false;
        // 获取数字字符串
        for (int i = 0; i < str.length(); i++) {
            // 如果开头为非法，则直接退出
            // 判断是否开始
            if (!isContinue) {
                if (!legalChar.contains(str.charAt(i) + "")) {
                    return 0;
                } else if (str.charAt(i) != ' ') {
                    number.append(str.charAt(i));
                    isContinue = true;
                }
            } else if (intChar.contains(str.charAt(i) + "")) {
                number.append(str.charAt(i));
            } else {
                break;
            }
        }
        // 将数字字符串转化为整数
        int i = 0;
        boolean pos = true;
        System.out.println(number.length());
        if (number.length() > 0 && (number.charAt(0) == '+' || number.charAt(0) == '-')) {
            i = 1;
            pos = number.charAt(0) == '+';
        }
        long ans = 0;
        for (int j = i; j < number.length(); j++) {
            int add = number.charAt(j) - '0';
            ans = ans * 10 + add;
            if (ans > Integer.MAX_VALUE || -ans < Integer.MIN_VALUE) {
                return pos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return pos ? (int) ans : -(int) ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.myAtoi("");
        System.out.println(i);
    }
}
