package com.richway.base.controller;

import com.richway.base.domain.EnterpriseAddress;
import com.richway.base.protocal.PageQuery;
import com.richway.base.protocal.PageResult;
import com.richway.base.protocal.ServiceResponse;
import com.richway.base.service.EnterpriseAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Boao on 2018/6/13.
 */
@RestController
@RequestMapping("/enterprise/address")
public class EnterpriseAddressController {

    @Autowired
    private EnterpriseAddressService enterpriseAddressService;

    @GetMapping("/add")
    public  void addEnterpriseAddress(){
        enterpriseAddressService.addEnterpriseAddress();
    }

    //获取企业收货地址列表
    @GetMapping("/list")
    public ServiceResponse<PageResult<EnterpriseAddress>> getEnterpriseAddressList(@RequestParam Map<String, Object> listQuery ){
        PageQuery query = new PageQuery(listQuery);
        PageResult<EnterpriseAddress> result=enterpriseAddressService.getEnterpriseAddressList(query);
        return new ServiceResponse(result);
    }
}
