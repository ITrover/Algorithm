package swordToOffer.minArray;

/**
 * 时间复杂度o(n)
 */
class Solution {
    public int minArray(int[] numbers) {
        if (numbers.length == 0){
            return 0;
        }
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if(numbers[i] < min){
                min = numbers[i];
                return min;
            }
        }
        return min;
    }
}
