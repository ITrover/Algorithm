package leetcode.replaceWords;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author itrover
 * 648. 单词替换 https://leetcode-cn.com/problems/replace-words/
 * 时间复杂度 o(n*m)
 */
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>((int)(dictionary.size() / 0.75f + 1));
        int maxLen = 0;
        int minLen = Integer.MAX_VALUE;
        for (String s : dictionary) {
            if (s.length() > maxLen){
                maxLen = s.length();
            }
            if (s.length() < minLen){
                minLen = s.length();
            }
            set.add(s);
        }
        // 分词
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            // 寻找词根
            boolean hasFind = false;
            // 优化，词根有个最大长度，和最小长度，只查询对应范围的单词
            // 此处优化后，从20% -> 70%
            for (int i = minLen; i < word.length() && i <= maxLen; i++) {
                String r = word.substring(0, i);
                if (set.contains(r)){
                    sb.append(r);
                    hasFind = true;
                    break;
                }
            }
            // 没找到，就放回原来的
            if (!hasFind){
                sb.append(word);
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] dictionary = {"cat","bat","rat"};
        String sentence = "the cattle was rattled by the battery";
        Solution solution = new Solution();
        solution.replaceWords(Arrays.asList(dictionary),sentence);
    }
}
