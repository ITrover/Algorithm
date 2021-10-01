package everyday.destCity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author itrover
 * 1436. 旅行终点站 https://leetcode-cn.com/problems/destination-city/
 */
class Solution {
    public String destCity(List<List<String>> paths) {
        if (paths.size() <= 0) {
            return "";
        }
        HashMap<String, String> map = new HashMap<>((int) (paths.size() / 0.75));
        for (List<String> path : paths) {
            // 起点->终点建立映射
            map.put(path.get(0), path.get(1));
        }
        String start = paths.get(0).get(1);
        String end = start;
        while (start != null) {
            // 以end为起点找终点，并作为新的起点
            // 直到走到终点
            end = start;
            start = map.get(start);
        }
        return end;
    }
}
