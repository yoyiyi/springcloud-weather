package com.yoyiyi.gradle.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 类名：WeatherDataSyncJob
 * 描述：数据同步
 * 时间：2018/6/23 18:28
 *
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
public class WeatherDataSyncJob extends QuartzJobBean {


    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

    }
}
