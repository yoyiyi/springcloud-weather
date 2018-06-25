package com.yoyiyi.gradle.vo;

import com.yoyiyi.gradle.domain.Weather;

import java.io.Serializable;

/**
 * 类名：WeatherResponse
 * 描述：TODO
 * 时间：2018/6/22 17:00
 *
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
public class WeatherResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Weather data;
    private Integer status;
    private String desc;

    public Weather getData() {
        return data;
    }

    public void setData(Weather data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
