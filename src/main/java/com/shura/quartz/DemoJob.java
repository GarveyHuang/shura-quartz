package com.shura.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Author: Garvey
 * @Created: 2021/12/16
 * @Description:
 */

public class DemoJob {

    public static void main(String[] args) {
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("job1", "group1")
                .usingJobData("job", "jobDetail")
                .usingJobData("name", "jobDetail")
                .usingJobData("jobDataCount", 0)
                .build();

        int count = 0;
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "trigger1")
                .usingJobData("trigger", "trigger")
                .usingJobData("triggerCount", count)
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever())
                .build();

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
