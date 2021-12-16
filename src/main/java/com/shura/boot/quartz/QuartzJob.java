package com.shura.boot.quartz;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @Author: Garvey
 * @Created: 2021/12/16
 * @Description:
 */
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class QuartzJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        try {
            Thread.sleep(2000);
            System.out.println(context.getScheduler().getSchedulerInstanceId());

            System.out.println("taskName= " + context.getJobDetail().getKey().getName());
            System.out.println("executeTime= " + new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
