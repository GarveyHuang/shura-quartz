package com.shura.quartz;

import org.quartz.*;

import java.util.Date;

/**
 * @Author: Garvey
 * @Created: 2021/12/16
 * @Description:
 */
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class MyJob implements Job {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
//        JobDataMap jobDetailMap = context.getJobDetail().getJobDataMap();
//        JobDataMap triggerMap = context.getTrigger().getJobDataMap();
//        JobDataMap mergeMap = context.getMergedJobDataMap();
//        System.out.println("jobDetailMap: " + jobDetailMap.getString("job"));
//        System.out.println("triggerMap: " + triggerMap.getString("trigger"));
//        System.out.println("mergeMap: " + mergeMap.getString("trigger"));
//
//        System.out.println("name: " + name);
//
//        System.out.println("jobDetail: " + System.identityHashCode(context.getJobDetail()));
//        System.out.println("job: " + System.identityHashCode(context.getJobInstance()));
//
//        System.out.println("execute: " + new Date());
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        JobDataMap triggerMap = context.getTrigger().getJobDataMap();
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        triggerMap.put("triggerCount", triggerMap.getInt("triggerCount") + 1);
        jobDataMap.put("jobDataCount", jobDataMap.getInt("jobDataCount") + 1);
        System.out.println("triggerMap count: " + triggerMap.getInt("triggerCount"));
        System.out.println("jobDataMap count: " + jobDataMap.getInt("jobDataCount"));
    }
}
