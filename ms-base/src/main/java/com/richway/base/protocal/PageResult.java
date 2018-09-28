package com.richway.base.protocal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Boao on 2018/6/13.
 * 分页返回
 */
public class PageResult<T> {

    /**
     * 查询的开始序号（序号从零开始）
     **/
    private Integer start;

    /**
     * 最大返回的记录数
     **/
    private Integer limit;

    private Integer pageIndex;

    /**
     * 总记录数
     */
    private Integer total = 0;

    private List<T> results = new ArrayList<T>();

    public PageResult() {
    }

    public PageResult(PageQuery pageQuery) {
        this.pageIndex = pageQuery.getPageIndex();
        this.start = pageQuery.getStart() != null ? pageQuery.getStart() : 0;
        this.limit = pageQuery.getLimit();
    }

    public PageResult(PageQuery pageQuery, List<T> results, Integer total) {
        this.pageIndex = pageQuery.getPageIndex();
        this.start = pageQuery.getStart() != null ? pageQuery.getStart() : 0;
        this.limit = pageQuery.getLimit();
        this.results = results;
        this.total = total;
    }

    public Integer getStart() {
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }
}
