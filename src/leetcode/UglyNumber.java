package leetcode;

public class UglyNumber {

    public int nthUglyNumber(int n) {
        if (n == 1){
            return 1;
        }
        int num = 1;
        int i = 1;
        while (num < n){
            i ++;
            if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0){
                num ++ ;
            }
        }
        return  i;
    }

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        int number = uglyNumber.nthUglyNumber(10);
        System.out.println(number);
    }

}
