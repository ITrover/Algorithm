package leetcode.canPlaceFlowers;

/**
 * @author itrover
 * 605. 种花问题 https://leetcode-cn.com/problems/can-place-flowers/
 * 贪心，判断条件考虑周全
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 1){
            return n == 0 || flowerbed[0] == 0 && n == 1;
        }
        int res = 0;
        for(int i = 0; i < flowerbed.length; i++){
            if(canInsert(flowerbed,i)){
                res++;
                flowerbed[i] = 1;
            }
        }
        return res >= n;
    }
    boolean canInsert(int[] flowerbed, int i){
        // 首位置
        if(i ==  0) {
            return flowerbed[0] == 0 && flowerbed[1] == 0;
        }
        // 尾位置
        if(i == flowerbed.length - 1){
            return flowerbed[i] == 0 && flowerbed[i - 1] == 0;
        }
        // 中间位置
        return flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0;
    }
}
