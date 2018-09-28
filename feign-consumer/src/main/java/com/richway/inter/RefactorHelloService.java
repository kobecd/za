package com.richway.inter;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by Boao on 2018/6/4.
 */
@FeignClient(value = "HELLO-SERVICE")
public interface RefactorHelloService extends com.richway.service.HelloService {

}
