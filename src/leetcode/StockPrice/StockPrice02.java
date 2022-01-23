package leetcode.StockPrice;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author itrover
 * 2034. 股票价格波动 https://leetcode-cn.com/problems/stock-price-fluctuation/
 * hashmap + 优先队列
 */
class StockPrice02 {
    int maxTimestamp;
    HashMap<Integer, Integer> timePriceMap;
    PriorityQueue<int[]> pqMax;
    PriorityQueue<int[]> pqMin;

    public StockPrice02() {
        maxTimestamp = 0;
        timePriceMap = new HashMap<>();
        // 大顶堆
        pqMax = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        // 小顶堆
        pqMin = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    }

    public void update(int timestamp, int price) {
        maxTimestamp = Math.max(maxTimestamp, timestamp);
        // 建立time:price
        timePriceMap.put(timestamp, price);
        pqMax.offer(new int[]{price, timestamp});
        pqMin.offer(new int[]{price, timestamp});
    }

    public int current() {
        return timePriceMap.get(maxTimestamp);
    }

    public int maximum() {
        while (true) {
            int[] priceTime = pqMax.peek();
            int price = priceTime[0], timestamp = priceTime[1];
            // 若timestamp == price，则price是更新后的数据，否则已经被更新需删除
            if (timePriceMap.get(timestamp) == price) {
                return price;
            }
            pqMax.poll();
        }
    }

    public int minimum() {
        while (true) {
            int[] priceTime = pqMin.peek();
            int price = priceTime[0], timestamp = priceTime[1];
            if (timePriceMap.get(timestamp) == price) {
                return price;
            }
            pqMin.poll();
        }
    }
}
