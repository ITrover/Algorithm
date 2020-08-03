### 解题思路

#### 1. 暴力解法

从1开始循环，直到找到第n个丑数


##### 代码
```java
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
```


#### 2. 动态规划


##### 代码
```java
    public int nthUglyNumber(int n) {
        // 记录因子相乘的位置
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            // 下一位可能的数字
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            // 找到最小的
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) {
                a++;
            }
            if(dp[i] == n3) {
                b++;
            }
            if(dp[i] == n5) {
                c++;
            }
        }
        return dp[n - 1];
    }
```
