package com.richway.base.service;

import com.richway.base.dao.EnterpriseAddressMapper;
import com.richway.base.domain.EnterpriseAddress;
import com.richway.base.protocal.PageQuery;
import com.richway.base.protocal.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Boao on 2018/6/13.
 */
@Service
public class EnterpriseAddressService {

    @Autowired
    private EnterpriseAddressMapper enterpriseAddressMapper;

    //企业收货地址列表
    public PageResult<EnterpriseAddress> getEnterpriseAddressList(PageQuery query) {
        List<EnterpriseAddress> items =enterpriseAddressMapper.getEnterpriseAddressList(query);
        Integer count=enterpriseAddressMapper.getEnterpriseAddressListCount(query);
        return  new PageResult<EnterpriseAddress>(query,items,count);
    }

    public void addEnterpriseAddress() {
        EnterpriseAddress enterpriseAddress = new EnterpriseAddress();
        enterpriseAddress.setEntId(2L);
        enterpriseAddress.setEntAddress("天河1");
        enterpriseAddress.setIsDefault(1);
        enterpriseAddressMapper.insert(enterpriseAddress);


    }
}
