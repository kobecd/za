package com.richway.controller;

import com.richway.domain.User;
import com.richway.inter.HelloService;
import com.richway.inter.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Boao on 2018/6/4.
 */
@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @Autowired
    RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/feign-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2",method = RequestMethod.GET)
    public String helloConsumer2(){
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        System.out.println(sb);
        sb.append(helloService.hello("DIDI")).append("\n");
        System.out.println(sb);
        sb.append(helloService.hello("DIDI",30)).append("\n");
        System.out.println(sb);
        sb.append(helloService.hello(new User("DIDI",30))).append("\n");
        return sb.toString();
    }

    @RequestMapping(value = "/feign-consumer3",method = RequestMethod.GET)
    public String helloConsumer3(){
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("DIDI")).append("\n");
        sb.append(refactorHelloService.hello("DIDI",30)).append("\n");
        sb.append(refactorHelloService.hello(new com.richway.domain.User("DIDI",30))).append("\n");
        return sb.toString();
    }
}
