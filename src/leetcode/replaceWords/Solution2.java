package leetcode.replaceWords;

import java.util.Arrays;
import java.util.List;

/**
 * @author itrover
 * 648. 单词替换 https://leetcode-cn.com/problems/replace-words/
 * 构建字典树（前缀树）o(n)
 */
class Solution2 {

    static class TrieNode {
        TrieNode[] children;
        String word;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    public String replaceWords(List<String> roots, String sentence) {
        TrieNode trie = new TrieNode();
        for (String root : roots) {
            TrieNode cur = trie;
            for (char letter : root.toCharArray()) {
                if (cur.children[letter - 'a'] == null) {
                    cur.children[letter - 'a'] = new TrieNode();
                }
                cur = cur.children[letter - 'a'];
            }
            cur.word = root;
        }

        StringBuilder ans = new StringBuilder();

        for (String word : sentence.split(" ")) {
            if (ans.length() > 0) {
                ans.append(" ");
            }

            TrieNode cur = trie;
            for (char letter : word.toCharArray()) {
                if (cur.children[letter - 'a'] == null || cur.word != null) {
                    break;
                }
                cur = cur.children[letter - 'a'];
            }
            ans.append(cur.word != null ? cur.word : word);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String[] dictionary = {"cat", "bat", "rat"};
        String sentence = "the cattle was rattled by the battery";
        Solution2 s = new Solution2();
        s.replaceWords(Arrays.asList(dictionary),sentence);
    }

}
