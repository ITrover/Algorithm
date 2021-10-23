package everyday.constructRectangle;

/**
 * @author itrover
 * 492. 构造矩形 https://leetcode-cn.com/problems/construct-the-rectangle/
 * 数学 + 迭代
 */
class Solution {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            --w;
        }
        return new int[]{area / w, w};
    }
}
