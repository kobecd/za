package com.richway.base.protocal;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Boao on 2018/6/13.
 * 分页查询参数
 *
 */
public class PageQuery extends LinkedHashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    /**
     * 查询的开始序号（序号从零开始）
     */
    private Integer start = 0;

    /**
     * 返回记录数
     */
    private Integer limit = 10;

    /**
     * 当前页码
     */
    private Integer pageIndex = 1;

    /**
     * 排序的字段
     */
    private String sortFields;

    public PageQuery(Map<String, Object> params) {
        this.putAll(params);
        // 分页参数
        if (params.get("pageIndex") != null) {
            this.pageIndex = Integer.parseInt(params.get("pageIndex").toString());
        }
        if (params.get("limit") != null) {
            this.limit = Integer.parseInt(params.get("limit").toString());
        }
        if (params.get("sortFields") != null) {
            this.sortFields = params.get("sortFields").toString();
        }
    }

    public Integer getStart() {
        if (start == 0 && pageIndex > 1) {
            setStart((pageIndex - 1) * limit);
        }
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getSortFields() {
        return sortFields;
    }

    public void setSortFields(String sortFields) {
        this.sortFields = sortFields;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
        this.start = (pageIndex - 1) * limit;
    }
}
