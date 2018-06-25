package com.yoyiyi.gradle.config;

import com.yoyiyi.gradle.job.WeatherDataSyncJob;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类名：QuartzConfiguration
 * 描述：调度配置 定时任务
 * 时间：2018/6/23 18:29
 *
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
@Configuration
public class QuartzConfiguration {
    private static final int TIME = 1800; // 更新频率

    //JobDetail
    @Bean
    public JobDetail weatherDataSyncJobDetail() {
        return JobBuilder.newJob(WeatherDataSyncJob.class)
                .withIdentity("weatherDataSyncJob")
                .storeDurably().build();
    }

    //Trigger 触发
    @Bean
    public Trigger weatherDataSyncTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(TIME)
                .repeatForever();
        return TriggerBuilder.newTrigger()
                .forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

}
