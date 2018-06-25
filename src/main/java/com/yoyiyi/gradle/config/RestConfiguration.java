package com.yoyiyi.gradle.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 类名：RestCinfiguration
 * 描述：Rest服务配置
 * 时间：2018/6/22 18:00
 *
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
@Configuration
public class RestConfiguration {

    @Autowired
    private RestTemplateBuilder mRestTemplateBuilder;

    @Bean
    public RestTemplate getRestTemplater() {
        return mRestTemplateBuilder.build();
    }
}
