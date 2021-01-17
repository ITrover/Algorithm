package everyday.checkStraightLine;

/**
 * 1232. 缀点成线 https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/
 * 判断斜率是否相等
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 1) {
            return true;
        }
        double slop = getSlop(coordinates[0][0], coordinates[0][1], coordinates[1][0], coordinates[1][1]);
        for (int i = 2; i < coordinates.length; i++) {
            // 判断斜率是否相等
            if (getSlop(coordinates[i - 1][0], coordinates[i - 1][1], coordinates[i][0], coordinates[i][1]) != slop) {
                return false;
            }
        }
        return true;
    }

    double getSlop(double x1, double y1, double x2, double y2) {
        double h = y2 - y1;
        double l = x2 - x1;
        return l == 0 ? Integer.MAX_VALUE : h / l;
    }
}
