package com.richway.service;

import com.richway.domain.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Boao on 2018/6/4.
 */
public class HelloServiceFallback implements com.richway.inter.HelloService {
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(@RequestParam("name") String name) {
        return "error";
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User("未知",0);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "error";
    }
}
