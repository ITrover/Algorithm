package swordToOffer.openLock;

import java.util.*;

/**
 * @author itrover
 * 剑指 Offer II 109. 开密码锁 https://leetcode-cn.com/problems/zlDJc7/
 * bfs
 */
class Solution {

    public int openLock(String[] deadends, String target) {
        // 存放死锁
        Set<String> set = new HashSet(Arrays.asList(deadends));
        if (set.contains(target)) {
            return -1;
        }
        String start = "0000";
        if (target.equals(start)) {
            return 0;
        }
        LinkedList<String> queue = new LinkedList<>();
        // 存放到某个状态走的步数
        HashMap<String, Integer> map = new HashMap<>();
        queue.addLast(start);
        map.put(start, 0);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                // 判断是否满足结果
                if (poll.equals(target)) {
                    return map.get(poll);
                }
                char[] arr = poll.toCharArray();
                // 旋转
                for (int j = 0; j < arr.length; j++) {
                    // 转动这个状态
                    char base = arr[j];
                    // 往前转动
                    arr[j] = (char) ((arr[j] - '0' + 1) % 10 + '0');
                    add(set, queue, map, step, arr);
                    // 往后转动
                    arr[j] = (char) ((arr[j] - '0' + 8) % 10 + '0');
                    add(set, queue, map, step, arr);
                    arr[j] = base;
                }
            }
        }
        return -1;
    }

    private void add(Set<String> set, LinkedList<String> queue, HashMap<String, Integer> map, int step, char[] arr) {
        String next = new String(arr);
        if (!map.containsKey(next)) {
            if (!set.contains(next)) {
                map.put(next, step);
                queue.offer(next);
            } else {
                // 不可达
                map.put(next, -1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }
}
