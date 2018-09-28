package com.richway.base.dao;

import com.richway.base.domain.EnterpriseAddress;
import com.richway.base.protocal.PageQuery;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Boao on 2018/6/13.
 */
@Mapper
@Component
public interface EnterpriseAddressMapper {

    @SelectProvider(type = EnterpriseAddressSqlProvider.class, method = "getEnterpriseAddressList")
    List<EnterpriseAddress> getEnterpriseAddressList(PageQuery query);

    @SelectProvider(type = EnterpriseAddressSqlProvider.class, method = "getEnterpriseAddressListCount")
    Integer getEnterpriseAddressListCount(PageQuery query);

    @InsertProvider(type = EnterpriseAddressSqlProvider.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer insert(EnterpriseAddress enterpriseAddress);
}

