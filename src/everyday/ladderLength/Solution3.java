package everyday.ladderLength;

import java.util.*;

/**
 * @author itrover
 * 127. 单词接龙 https://leetcode-cn.com/problems/word-ladder/
 * BFS
 * 时间复杂度o(n*wordlength)
 * 1298ms 击败12%
 */
class Solution3 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        ArrayDeque<String> start = new ArrayDeque<>();
        start.addLast(beginWord);
        int step = 1;
        // BFS
        while (!start.isEmpty()) {
            int size = start.size();
            for (int i = 0; i < size; i++) {
                String s = start.pollFirst();
                for (String word : wordList) {
                    // 访问未访问过的结点
                    if (s.length() != word.length() || visited.contains(word)) {
                        continue;
                    }
                    int diff = 0;
                    // 判断是否是邻居
                    for (int j = 0; j < s.length(); j++) {
                        if (s.charAt(j) != word.charAt(j)) {
                            diff++;
                        }
                        if (diff > 1) {
                            break;
                        }
                    }
                    if (diff <= 1) {
                        if (word.equals(endWord)) {
                            return step + 1;
                        }
                        start.addLast(word);
                        visited.add(word);
                    }
                }
            }
            step++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
    }
}
