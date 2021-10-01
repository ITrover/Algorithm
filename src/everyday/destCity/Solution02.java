package everyday.destCity;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author itrover
 */
class Solution02 {
    public String destCity(List<List<String>> paths) {
        Set<String> citiesA = new HashSet<String>();
        for (List<String> path : paths) {
            citiesA.add(path.get(0));
        }
        // 终点不作为起点
        for (List<String> path : paths) {
            if (!citiesA.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}

