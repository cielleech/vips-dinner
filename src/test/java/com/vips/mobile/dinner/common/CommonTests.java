package com.vips.mobile.dinner.common;
import org.junit.Test;

/**
 * Created by cielleech on 2016/10/21.
 */
public class CommonTests {
    @Test
    public void longTest() {
        Statistic statistic = new Statistic();
        statistic.incrClick("11234");
        statistic.incrClick("11234");
        System.out.println(statistic.getClick());
    }
}
