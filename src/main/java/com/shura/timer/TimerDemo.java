package com.shura.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: Garvey
 * @Created: 2021/12/16
 * @Description: jdk 自带定时器演示
 */
public class TimerDemo {

    public static void main(String[] args) {
        Timer timer = new Timer(); // 任务启动
        for (int i = 0; i < 2; i++) {
            TimerTask task = new FooTimerTask("foo" + i);
            timer.scheduleAtFixedRate(task, new Date(), 2000);  // 任务添加   10s 5次
            // 预设的执行时间nextExecuteTime 12:00:00   12:00:02  12:00:04
            // schedule 真正的执行时间 取决上一个任务的结束时间  ExecuteTime  03  05  08  丢任务（少执行了次数）
            // scheduleAtFixedRate  严格按照预设时间 12:00:00  12:00:02  12:00:04（执行时间会乱）
            // 单线程  任务阻塞  任务超时
        }
    }
}