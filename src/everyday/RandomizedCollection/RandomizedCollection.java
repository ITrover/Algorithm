package everyday.RandomizedCollection;

import java.util.*;

/**
 * @author itrover
 * 381. O(1) 时间插入、删除和获取随机元素 - 允许重复 https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 * 使用Hash表记录元素索引列表
 * 删除元素时用最后的元素替换
 */
class RandomizedCollection {

    List<Integer> nums;
    Map<Integer, HashSet<Integer>> idx;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<>();
        idx = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        nums.add(val);
        HashSet<Integer> set = idx.getOrDefault(val, new HashSet<Integer>());
        set.add(nums.size() - 1);
        // 这里put是因为前面返回了一个默认值，那个值没有被put进去
        idx.put(val,set);
        return set.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        // 获取val对应的索引列表
        HashSet<Integer> set = idx.get(val);
        if (set == null || set.isEmpty()){
            return false;
        }
        // 获取一个索引
        Iterator<Integer> it = set.iterator();
        int index = it.next();
        // 删除该索引
        set.remove(index);
        // 将最后一个元素替换删除的值
        int last = nums.size() - 1;
        Integer lastElement = nums.get(last);
        // 一定要先替换，再删除，避免set报错
        nums.set(index,lastElement);
        set = idx.get(lastElement);
        // 先添加后删除，避免待删除的元素在末尾
        set.add(index);
        set.remove(last);
        nums.remove(last);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}
