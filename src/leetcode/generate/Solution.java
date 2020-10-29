package leetcode.generate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author itrover
 * 118. 杨辉三角 https://leetcode-cn.com/problems/pascals-triangle/
 * 动态规划
 * 时间复杂度o(n!)
 * 空间复杂度o(n!)
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> res = new ArrayList<>(numRows);
        if (numRows < 1) {
            return res;
        }
        ArrayList<Integer> t = new ArrayList<>(1);
        t.add(1);
        res.add(t);
        for (int i = 2; i <= numRows; i++) {
            t = new ArrayList<>(i);
            t.add(1);
            List<Integer> last = res.get(i - 2);
            for (int j = 1; j < i - 1; j++) {
                t.add(last.get(j - 1) + last.get(j));
            }
            t.add(1);
            res.add(t);
        }
        return res;
    }
}
