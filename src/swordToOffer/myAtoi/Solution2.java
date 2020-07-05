package swordToOffer.myAtoi;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/7/3 20:29
 */

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 使用正则表达式
 */
public class Solution2 {
    public int myAtoi(String str) {
        String pattern = "^\\s*([+-]?\\d+)";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(str);
        if (!matcher.find()){
            return 0;
        }
        BigInteger ans = new BigInteger(matcher.group(1));
        if(ans.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE)))<0){
            return Integer.MIN_VALUE;
        }
        if(ans.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE)))>0){
            return Integer.MAX_VALUE;
        }
        return ans.intValue();

    }

    public static void main(String[] args) {
        System.out.println(new Solution2().myAtoi("-1234541634564646"));
    }
}
