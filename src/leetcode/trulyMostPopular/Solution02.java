package leetcode.trulyMostPopular;

import java.util.*;

/**
 * @author itrover
 * 面试题 17.07. 婴儿名字 https://leetcode-cn.com/problems/baby-names-lcci/
 * 并查集
 */
class Solution02 {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, Integer> map = new HashMap<>();
        // 并查集， key(子孙)->value(祖宗)
        Map<String, String> unionMap = new HashMap<>();
        // 统计频率
        for (String name : names) {
            int idx1 = name.indexOf('(');
            int idx2 = name.indexOf(')');
            int frequency = Integer.valueOf(name.substring(idx1 + 1, idx2));
            map.put(name.substring(0, idx1), frequency);
        }
        for (String pair : synonyms) {
            int idx = pair.indexOf(',');
            String name1 = pair.substring(1, idx);
            String name2 = pair.substring(idx + 1, pair.length() - 1);
            // 寻找祖宗
            while (unionMap.containsKey(name1)) {
                name1 = unionMap.get(name1);
            }
            while (unionMap.containsKey(name2)) {
                name2 = unionMap.get(name2);
            }
            if(!name1.equals(name2)){
                // 合并后的频次
                int frequency = map.getOrDefault(name1, 0) + map.getOrDefault(name2, 0);
                String trulyName = name1.compareTo(name2) < 0 ? name1 : name2;
                String nickName = name1.compareTo(name2) < 0 ? name2 : name1;
                unionMap.put(nickName, trulyName);
                // 这个name的数据已经被合并了
                map.remove(nickName);
                map.put(trulyName, frequency);
            }
        }
        String[] res = new String[map.size()];
        int index = 0;
        for (String name : map.keySet()) {
            StringBuilder sb = new StringBuilder(name);
            sb.append('(');
            sb.append(map.get(name));
            sb.append(')');
            res[index++] = sb.toString();
        }
        return res;
    }
}
