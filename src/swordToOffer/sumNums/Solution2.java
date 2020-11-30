package swordToOffer.sumNums;

class Solution2 {

    public int sumNums(int n) {
        int res = 0;
        boolean x = n > 1 && (res = n + sumNums(n - 1)) == 0;
        return res;
    }
}
