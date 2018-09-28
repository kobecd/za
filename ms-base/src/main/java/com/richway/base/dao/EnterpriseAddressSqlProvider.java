package com.richway.base.dao;

import com.richway.base.domain.EnterpriseAddress;
import com.richway.base.protocal.PageQuery;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Boao on 2018/6/13.
 */
public class EnterpriseAddressSqlProvider {

    private String fields = "enterprise_address id, ent_id, ent_address, is_default, ";

    public String insert(final EnterpriseAddress enterpriseAddress) {
        return new SQL(){{
            INSERT_INTO("enterprise_address");
                VALUES("id", "#{id}");
                VALUES("ent_id","#{entId}");
                VALUES("ent_address","#{entAddress}");
                VALUES("is_default","#{isDefault}");
        }}.toString();
    }

    private String getEnterpriseAddressListSql(final PageQuery query) {
        return new SQL() {
            {
                SELECT("*");
                FROM("enterprise_address");
                if (query.get("entId") != null)
                    WHERE("ent_id = #{entId}");
                if (query.get("entAddress") != null)
                    WHERE(" ent_address like concat('%', #{entAddress}, '%')");
                if(query.get("isDefault") != null)
                    WHERE("is_default = #{isDefault}");
                if (query.getSortFields() != null && query.getSortFields().isEmpty() == false)
                    ORDER_BY(query.getSortFields());
            }
        }.toString();
    }

    public String getEnterpriseAddressList(PageQuery query) {
        return  getEnterpriseAddressListSql(query) + String.format(" limit %s,%s",query.getStart(),query.getLimit());
    }

    public String getEnterpriseAddressListCount(PageQuery query) {
        return "select count(*) total from (" + getEnterpriseAddressListSql(query) + ") t";
    }
}
