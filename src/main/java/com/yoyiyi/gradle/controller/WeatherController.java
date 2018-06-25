package com.yoyiyi.gradle.controller;

import com.yoyiyi.gradle.service.IWeatherDataService;
import com.yoyiyi.gradle.vo.WeatherResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名：WeatherController
 * 描述：TODO
 * 时间：2018/6/22 17:52
 *
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private IWeatherDataService mWeathDataService;

    @GetMapping("/cityId/{cityId}")
    private WeatherResponse getWeatherDataByCityId(@PathVariable("cityId") String cityId) {
        return mWeathDataService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    private WeatherResponse getWeatherDataByCityName(@PathVariable("cityName") String cityName) {
        return mWeathDataService.getDataByCityName(cityName);
    }
}
