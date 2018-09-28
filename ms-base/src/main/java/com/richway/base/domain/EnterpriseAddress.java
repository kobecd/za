package com.richway.base.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Boao on 2018/6/13.
 */
@Data
public class EnterpriseAddress implements Serializable{

    // 主键id
    private Long id;
    // 企业
    private Long entId;

    //联系人
    private  String linkMan;
    //手机
    private  String mobile;
    //邮编
    private  String postCode;
    //省市
    private  String province;
    // 详细地址
    private String entAddress;
    //备注
    private  String remark;
    // 是否默认地址
    private Integer isDefault;
}
