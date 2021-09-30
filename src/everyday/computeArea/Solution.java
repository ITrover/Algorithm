package everyday.computeArea;

/**
 * @author itrover
 * 223. 矩形面积 https://leetcode-cn.com/problems/rectangle-area/
 */
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
        // 重叠的长和宽
        // 矩形的角在x上的投影的重叠部分，重叠的长 = 右上角x的最小 - 左下角x的最大，如果为负说明没有重叠
        int overlapLong = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        // 矩形的角在y上的投影的重叠部分，重叠的宽 = 右上角y的最小 - 左下角y的最大，如果为负说明没有重叠
        int overlapWidth = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        return area - overlapLong * overlapWidth;
    }
}
