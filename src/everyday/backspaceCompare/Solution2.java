package everyday.backspaceCompare;


/**
 * 844. 比较含退格的字符串(https://leetcode-cn.com/problems/backspace-string-compare/)
 * 使用双指针
 * 时间复杂度o(n+m)
 * 空间复杂度o(1)
 */
class Solution2 {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int bs = 0;
        int bt = 0;
        // 最后可能出现一个字符串为空，另外一个不为空
        // 不为空的字符串有两种可能， #多，最后消了也是空 ----> 相等
        //                       #少，最后是一个不为空的字符串 ----> 不相等
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                if (S.charAt(i) == '#') {
                    bs++;
                    i--;
                } else {
                    if (bs > 0){
                        bs--;
                        i--;
                    }else{
                        if (j >= 0) {
                            if (T.charAt(j) == '#') {
                                bt++;
                                j--;
                            } else {
                                if (bt > 0) {
                                    bt--;
                                    j--;
                                } else {
                                    if (S.charAt(i) == T.charAt(j)) {
                                        j--;
                                        i--;
                                    } else {
                                        return false;
                                    }
                                }
                            }
                        } else {
                            // T为空，只检验S
                            if (S.charAt(i) == '#') {
                                bs++;
                                i--;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            } else {
                // S为空，则只检验T
                if (T.charAt(j) == '#') {
                    bt++;
                } else {
                    if (bt > 0) {
                        bt--;
                    } else {
                        return false;
                    }
                }
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "";
        String s2 = "a";
        String s3 = "aa#";
        String s4 = "#aa";
        String s5 = "#a##a##a##a#a#a";
        String s6 = "isfcow#";
        String s7 = "isfcog#w#";

        Solution2 solution = new Solution2();
        System.out.println(solution.backspaceCompare(s5, s3));
    }
}
