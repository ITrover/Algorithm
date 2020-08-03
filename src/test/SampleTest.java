package test;

import org.junit.Test;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/8/1 21:04
 */

public class SampleTest {

    @Test
    public void intTest() {
        // Integer 缓存数字 -128 - 127
        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1 == 127);
    }

}
