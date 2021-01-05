package leetcode.oneEditAway;

/**
 * @author itrover
 * 面试题 01.05. 一次编辑 https://leetcode-cn.com/problems/one-away-lcci/
 * 分情况讨论
 * 代码简化版
 */
class Solution2 {
    int k = 0;
    public boolean oneEditAway(String first, String second) {
        if(Math.abs(first.length() - second.length()) > 1){
            return false;
        }
        // 插入 删除 替换
        // 当长度相等时，只能替换
        // 当不等时，只能删除长的那个的字符或增加长度
        int len1 = first.length();
        int len2 = second.length();
        // 记录递归的深度
        k++;
        for (int i = 0; i < Math.min(len1, len2); i++) {
            if (first.charAt(i) != second.charAt(i)){
                return len1 == len2 ? oneEditAway(first.substring(i + 1), second.substring(i + 1)) :
                        len1 > len2 ? first.substring(i + 1).equals(second.substring(i)) :
                                first.substring(i).equals(second.substring(i + 1));
            }
        }
        return k <= 2;
    }
}
