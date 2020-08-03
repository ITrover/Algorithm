package swordToOffer.sumNums;

class Solution {
    int res = 0;
    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.sumNums(9));
    }
}
