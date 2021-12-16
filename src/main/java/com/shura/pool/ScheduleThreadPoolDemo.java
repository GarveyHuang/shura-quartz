package com.shura.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Garvey
 * @Created: 2021/12/16
 * @Description: 线程池定时任务 demo
 */
public class ScheduleThreadPoolDemo {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 2; i++) {
            scheduledThreadPool.scheduleAtFixedRate(new Task("task-" + i), 0, 2, TimeUnit.SECONDS);
        }
    }
}
