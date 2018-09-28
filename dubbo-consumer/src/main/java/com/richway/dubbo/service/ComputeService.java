package com.richway.dubbo.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Boao on 2018/6/13.
 */
@Component
public interface ComputeService {

    Integer add(int a, int b);

}
