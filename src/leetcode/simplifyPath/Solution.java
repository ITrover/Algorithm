package leetcode.simplifyPath;


import java.util.LinkedList;

/**
 * @author itrover
 * 71. 简化路径 https://leetcode-cn.com/problems/simplify-path/
 * 队列
 */
class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        LinkedList<String> queue = new LinkedList<>();
        for (String s : paths) {
            if (s.length() == 0 || s.equalsIgnoreCase(".")) {
            } else if (s.equalsIgnoreCase("..")) {
                if (!queue.isEmpty()) {
                    queue.pollLast();
                }
            } else {
                queue.add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append("/");
            sb.append(queue.poll());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
