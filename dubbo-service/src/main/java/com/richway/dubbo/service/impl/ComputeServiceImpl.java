package com.richway.dubbo.service.impl;

import com.richway.dubbo.service.ComputeService;

/**
 * Created by Boao on 2018/6/13.
 */
public class ComputeServiceImpl implements ComputeService {

    @Override
    public Integer add(int a, int b) {
        return a + b;
    }
}
