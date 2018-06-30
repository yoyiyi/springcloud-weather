package com.yoyiyi.gradle.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yoyiyi.gradle.service.IWeatherDataService;
import com.yoyiyi.gradle.vo.WeatherResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 类名：WeathDataServiceImpl
 * 描述：TODO
 * 时间：2018/6/22 17:00
 *
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
@Service
public class WeatherDataServiceImpl implements IWeatherDataService {
    private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    @Value("${weather.uri}")
    private String mUri;

    @Autowired
    private RestTemplate mRestTemplate;

    @Autowired
    private StringRedisTemplate mStringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = mUri + "citykey=" + cityId;
        return this.doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = mUri + "city=" + cityName;
        return this.doGetWeather(uri);
    }

    @Override
    public void syncDataByCityId(String cityId) {
        String uri = mUri + "citykey=" + cityId;
        saveWeatherData(uri);
    }

    /**
     * redis保存数据
     *
     * @param uri
     */
    private void saveWeatherData(String uri) {
        String body = null;
        ValueOperations<String, String> operations = mStringRedisTemplate.opsForValue();
        ResponseEntity<String> responseEntity = mRestTemplate.getForEntity(uri, String.class);
        if (responseEntity.getStatusCodeValue() == 200) {
            body = responseEntity.getBody();
        }
        //数据写入缓存
        operations.set(uri, body, 1800, TimeUnit.SECONDS);
       // String s = operations.get(uri);
      //  logger.info(s);
    }

    private WeatherResponse doGetWeather(String uri) {
        String body = null;
        //1.先查缓存
        WeatherResponse weatherResponse = null;
        ObjectMapper objectMapper = new ObjectMapper();
        ValueOperations<String, String> operations = mStringRedisTemplate.opsForValue();
        if (mStringRedisTemplate.hasKey(uri)) {
            logger.info("Redis中有数据key为:" + uri);
            body = operations.get(uri);
        } else {
            logger.info("Redis中没有数据key");
            //2.缓存没有就调用api
            ResponseEntity<String> responseEntity = mRestTemplate.getForEntity(uri, String.class);
            if (responseEntity.getStatusCodeValue() == 200) {
                body = responseEntity.getBody();
            }
            //数据写入缓存
            operations.set(uri, body, 1800, TimeUnit.SECONDS);
        }
        try {
            weatherResponse = objectMapper.readValue(body, WeatherResponse.class);
        } catch (IOException e) {
            logger.error("Error:" + e.getMessage());
        }
        return weatherResponse;
    }
}
