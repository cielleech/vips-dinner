package com.vips.mobile.dinner.common;

import java.io.Serializable;

/**
 * Created by cielleech on 2016/10/21.
 */
public class Statistic implements Serializable {
    private Long click = 0L;

    private Long expose = 0L;

    public synchronized void incrClick(String mid) {
        click++;
    }

    public synchronized void incrExpose(String mid) {
        expose++;
    }

    public Long getClick() {
        return click;
    }
}
