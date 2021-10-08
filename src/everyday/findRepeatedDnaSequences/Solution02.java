package everyday.findRepeatedDnaSequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author itrover
 * 哈希表
 */
class Solution02 {
    static final int L = 10;

    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - L; i++) {
            String sub = s.substring(i, i + L);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            if (map.get(sub) == 2) {
                res.add(sub);
            }
        }
        return res;
    }
}
