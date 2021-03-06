package com.yoyiyi.gradle.service;

import com.yoyiyi.gradle.vo.WeatherResponse;

/**
 * 类名：WeathDataService
 * 描述：天气服务
 * 时间：2018/6/22 16:59
 *
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
public interface IWeatherDataService {
    /**
     * 根据城市ID查询天气数据
     *
     * @param cityId
     * @return WeatherResponse
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称查询天气数据
     *
     * @param cityName
     * @return WeatherResponse
     */
    WeatherResponse getDataByCityName(String cityName);

    /**
     * 根据城市id来同步天气
     *
     * @param cityId
     */
    void syncDataByCityId(String cityId);
}
