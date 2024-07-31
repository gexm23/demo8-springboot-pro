package com.qfedu.vo;

import com.qfedu.pojo.Customer;

/**
 * 客户的视图对象
 */
public class CustomerVo extends Customer {
    /**
     * 分页参数
     */
    private Integer page;  //当前页
    private Integer limit; //每页展示多少条

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
