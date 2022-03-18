package swordToOffer.minimumLengthEncoding;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author itrover
 * 剑指 Offer II 065. 最短的单词编码 https://leetcode-cn.com/problems/iSwD2y/
 * 前缀树
 */
class Solution {
    public int minimumLengthEncoding(String[] words) {
        // 使用前一个单词的后缀
        // 后缀树
        int n = words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int res = 0;
        Tire tire = new Tire();
        for (int i = n - 1; i >= 0; i--) {
            if (!tire.search(words[i])) {
                res += words[i].length() + 1;
            }
            tire.insert(words[i]);
        }
        return res;
    }

    /**
     * 后缀树
     */
    static class Tire {

        Tire[] children;
        public Tire() {
            children = new Tire[26];
        }

        public void insert(String word) {
            Tire root = this;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (root.children[c - 'a'] == null) {
                    root.children[c - 'a'] = new Tire();
                }
                root = root.children[c - 'a'];
            }
        }

        public boolean search(String word) {
            Tire root = this;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (root.children[c - 'a'] == null) {
                    return false;
                }
                root = root.children[c - 'a'];
            }
            return true;
        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.minimumLengthEncoding(new String[]{"me", "time", "ime", "bbbbb", "bbb"});
    }

}
