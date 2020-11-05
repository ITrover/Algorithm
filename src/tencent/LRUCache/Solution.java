package tencent.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author MaYunHao
 * @version 1.0
 * @date 2020/10/10 15:28
 * @description
 * 使用Java自带的LinkedHashMap实现
 */
public class Solution extends LinkedHashMap<Integer, Integer>{
    private int capacity;

    public Solution(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    /**
     * LinkedHashMap的作用
     * 当访问后，有个afterNodeAccess()方法，改方法会把当前结点放在链表开头
     * @param key
     * @return
     */
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    /**
     * LinkedHashMap有head和tail指针构成链表
     * Entry继承Node，同时多了两个属性分别是before和after
     * afterNodeAccess(e)会将插入的结点， 放在链表尾部
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        super.put(key, value);
    }

    /**
     * put或putAll后执行的动作，判断是否删除结点
     * 删除的是链表头的结点，即最久未访问的结点
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
