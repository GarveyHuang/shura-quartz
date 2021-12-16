package com.shura.timer;

import java.util.Date;
import java.util.TimerTask;

/**
 * @Author: Garvey
 * @Created: 2021/12/16
 * @Description: 定时器任务
 */
public class FooTimerTask extends TimerTask {

    private String name;

    public FooTimerTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("name= " + name + " , startTime= " + new Date());
            Thread.sleep(3000);
            System.out.println("name= " + name + " , endTime= " + new Date());

            // 线程池执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
