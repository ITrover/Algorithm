package leetcode.canPlaceFlowers;

/**
 * @author itrover
 * 605. 种花问题 https://leetcode-cn.com/problems/can-place-flowers/
 * 贪心，判断条件考虑周全
 */
class Solution2 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 0 && ((i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0))){
                cnt++;
                flowerbed[i] = 1;
            }
            if (cnt >= n){
                return true;
            }
        }
        return false;
    }
}
