package leetcode.snapshotArray;

import java.util.*;

/**
 * 1146. 快照数组 https://leetcode-cn.com/problems/snapshot-array/
 * 二分查找、懒更新、缓存
 */
class SnapshotArray {

    int _snap = 0;
    List[] button;
    Map[] maps;

    public SnapshotArray(int length) {
        button = new List[length];
        maps = new Map[length];
        for (int i = 0; i < length; i++) {
            button[i] = new ArrayList<int[]>();
            maps[i] = new HashMap<Integer, Integer>();
            button[i].add(new int[]{0, 0});
        }
    }

    public void set(int index, int val) {
        List<int[]> list = button[index];
        // 比较末尾的快照是否落后，如果落后则备份更新
        int[] old = list.get(list.size() - 1);
        if (old[0] < _snap) {
            list.add(new int[]{_snap, val});
        } else {
            // 直接更新
            old[1] = val;
        }
    }

    public int snap() {
        // 不动，真正修改的时候再备份
        return _snap++;
    }

    public int get(int index, int snap_id) {
        Map<Integer, Integer> map = maps[index];
        Integer cache = map.get(snap_id);
        if (cache != null) {
            return cache;
        }
        // 二分查找
        List<int[]> list = button[index];
        // 找到刚好小于等于snap_id
        int l = 0, r = list.size() - 1;
        int res = 0;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            int[] m = list.get(mid);
            if (m[0] > snap_id) {
                r = mid - 1;
            } else if (m[0] == snap_id) {
                return m[1];
            } else {
                l = mid + 1;
                res = m[1];
            }
        }
        map.put(snap_id, res);
        return res;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
