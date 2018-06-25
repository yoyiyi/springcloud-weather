package com.yoyiyi.gradle.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名：HelloController
 * 描述：TODO
 * 时间：2018/6/22 16:02
 *
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
