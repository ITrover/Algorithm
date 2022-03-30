package leetcode.Twitter;

import java.util.*;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2022/3/30 16:55
 * 355. 设计推特 https://leetcode-cn.com/problems/design-twitter/
 * 哈希表 + 堆
 */
public class Twitter {
    /**
     * 保存关注的人
     */
    Map<Integer, Set<Integer>> f;

    /**
     * 每个用户发布的推文
     */
    Map<Integer, Set<Note>> tw;


    int t;


    public Twitter() {
        f = new HashMap<>();
        tw = new HashMap<>();
    }

    /**
     * 推文
     */
    private class Note {
        public int tweetId;
        /**
         * 时间
         */
        public int t;

        public Note(int tweetId, int t) {
            this.tweetId = tweetId;
            this.t = t;
        }

        @Override
        public int hashCode() {
            return tweetId;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Note) {
                return ((Note) obj).tweetId == this.t;
            }
            return false;
        }
    }

    public void postTweet(int userId, int tweetId) {
        Set<Note> tws = tw.get(userId);
        if (tws == null) {
            tws = new HashSet<>();
        }
        // 发布推文
        tws.add(new Note(tweetId, t++));
        tw.put(userId, tws);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Note> queue = new PriorityQueue<>(10, (a, b) -> b.t - a.t);
        getNewList(userId, queue);
        Set<Integer> followees = f.get(userId);
        if (followees != null) {
            for (Integer followee : followees) {
                getNewList(followee, queue);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < 10 && !queue.isEmpty(); i++) {
            res.add(queue.poll().tweetId);
        }
        return res;
    }

    private void getNewList(int userId, PriorityQueue<Note> queue) {
        Set<Note> notes = tw.get(userId);
        if (notes != null) {
            queue.addAll(notes);
        }
    }


    public void follow(int followerId, int followeeId) {
        // 关注人
        Set<Integer> follow = f.get(followerId);
        if (follow == null) {
            follow = new HashSet<>();
        }
        follow.add(followeeId);
        f.put(followerId, follow);
    }

    public void unfollow(int followerId, int followeeId) {
        // 删除关注
        if (f.get(followerId) != null) {
            f.get(followerId).remove(followeeId);
        }
    }

}
