package com.yoyiyi.gradle.service;

import com.yoyiyi.gradle.domain.City;

import java.util.List;

/**
 * 类名：CityDataService
 * 描述：TODO
 * 时间：2018/6/30 10:10
 *
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
public interface ICityDataService {
    List<City> listCity() throws Exception;
}
