package com.shura.pool;

import java.util.Date;

/**
 * @Author: Garvey
 * @Created: 2021/12/16
 * @Description: 线程任务定义
 */
public class Task implements Runnable {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("name= " + name + " , startTime = " + new Date());
            Thread.sleep(3000);
            System.out.println("name= " + name + " , endTime= " + new Date());

            // 线程池执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
