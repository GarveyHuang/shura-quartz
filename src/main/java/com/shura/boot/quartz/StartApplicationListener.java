package com.shura.boot.quartz;

import org.quartz.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: Garvey
 * @Created: 2021/12/16
 * @Description: 监听器
 */
@Component
public class StartApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    private Scheduler scheduler;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey("trigger1", "group1");
            Trigger trigger = scheduler.getTrigger(triggerKey);

            if (trigger == null) {
                trigger = TriggerBuilder.newTrigger()
                        .withIdentity(triggerKey)
                        .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                        .startNow()
                        .build();
                JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class)
                        .withIdentity("job1", "group1")
                        .build();
                scheduler.scheduleJob(jobDetail, trigger);
            }

            TriggerKey triggerKey2 = TriggerKey.triggerKey("trigger2", "group2");
            Trigger trigger2 = scheduler.getTrigger(triggerKey2);

            if (trigger2 == null) {
                trigger2 = TriggerBuilder.newTrigger()
                        .withIdentity(triggerKey)
                        .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                        .startNow()
                        .build();
                JobDetail jobDetail2 = JobBuilder.newJob(QuartzJob.class)
                        .withIdentity("job2", "group2")
                        .build();
                scheduler.scheduleJob(jobDetail2, trigger2);
            }

            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
