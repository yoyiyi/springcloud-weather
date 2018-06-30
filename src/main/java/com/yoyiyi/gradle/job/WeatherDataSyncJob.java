package com.yoyiyi.gradle.job;

import com.yoyiyi.gradle.domain.City;
import com.yoyiyi.gradle.service.ICityDataService;
import com.yoyiyi.gradle.service.IWeatherDataService;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * 类名：WeatherDataSyncJob
 * 描述：数据同步
 * 时间：2018/6/23 18:28
 *
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
public class WeatherDataSyncJob extends QuartzJobBean {
    @Autowired
    private ICityDataService mCityDataService;
    @Autowired
    private IWeatherDataService mWeatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        //遍历城市id列表
        List<City> cityList = null;
        try {
            cityList = mCityDataService.listCity();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //遍历城市id获取天气
        for (City city : cityList) {
            String cityId = city.getCityId();
            mWeatherDataService.syncDataByCityId(cityId);
        }
    }
}
