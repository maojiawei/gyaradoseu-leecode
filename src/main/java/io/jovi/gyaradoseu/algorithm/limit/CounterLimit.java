package io.jovi.gyaradoseu.algorithm.limit;

import org.junit.Test;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class CounterLimit {
    /**
     * 初始时间的时间戳
     */
    public long timeStamp = getNowTime();
    /**
     * 统计调用次数
     */
    public int reqCount = 0;
    /**
     * 时间窗口内最大请求数
     */
    public final int limit = 10;
    /**
     * 时间窗口，单位：毫秒
     */
    public final long interval = 1000;

    public boolean grant() {
        long now = getNowTime();
        if (now < timeStamp + interval) {
            // 在时间窗口内
            reqCount++;
            System.out.println(reqCount);
            // 判断当前时间窗口内是否超过最大请求控制数
            return reqCount <= limit;
        } else {
            timeStamp = now;
            // 超时后重置
            reqCount = 1;
            return true;
        }
    }

    public long getNowTime() {
        return System.currentTimeMillis();
    }

    @Test
    public void test(){

    }

}
