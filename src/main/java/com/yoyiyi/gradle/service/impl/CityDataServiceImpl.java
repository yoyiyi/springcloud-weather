package com.yoyiyi.gradle.service.impl;

import com.yoyiyi.gradle.domain.City;
import com.yoyiyi.gradle.domain.CityList;
import com.yoyiyi.gradle.service.ICityDataService;
import com.yoyiyi.gradle.utils.XmlBuilder;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * 类名：CityDataServiceImpl
 * 描述：TODO
 * 时间：2018/6/30 10:12
 *
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
@Service
public class CityDataServiceImpl implements ICityDataService {
    @Override
    public List<City> listCity() throws Exception {
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer sb = new StringBuffer();
        String line = "";
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        CityList cityList = (CityList) XmlBuilder.xmlStr2Object(CityList.class, sb.toString());
        return cityList.getCityList();
    }
}
