package swordToOffer.uglyNumber;

/**
 * 暴力解法
 * 循环
 * 一个数一个数判断是否为丑数
 *
 */
public class UglyNumber {

    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int num = 1;
        int i = 1;
        while (num < n) {
            i++;
            if (isUgly(i)) {
                num++;
            }
        }
        return i;
    }

    /**
     * 丑数的判断条件
     * 能被2 3 5 整除
     * @param n
     * @return
     */
    public boolean isUgly(int n) {
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        int number = uglyNumber.nthUglyNumber(10);
        System.out.println(number);
    }

}
