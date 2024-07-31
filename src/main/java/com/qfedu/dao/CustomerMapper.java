package com.qfedu.dao;

import com.qfedu.pojo.Customer;
import com.qfedu.vo.CustomerVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface CustomerMapper {

    /**
     * 查询客户信息
     */
    List<Customer> queryAllCustomer(Customer customer);

    /**
     * 添加客户
     * @param customerVo
     */
    void addCustomer(CustomerVo customerVo);

    /**
     * 修改客户
     * @param customerVo
     */
    void updateCustomer(CustomerVo customerVo);

    void deleteCustomer(String identity);
}
