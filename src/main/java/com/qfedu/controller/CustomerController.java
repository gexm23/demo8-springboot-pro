package com.qfedu.controller;


import com.alibaba.druid.support.json.JSONUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.qfedu.service.CustomerService;
import com.qfedu.utils.ResultObj;
import com.qfedu.vo.CustomerVo;
import com.qfedu.vo.DataGridView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 查询客户信息
     * 请求方式get 参数CustomerVo
     */
    @GetMapping
    public DataGridView loadAllCustomer(@RequestBody CustomerVo customerVo){
        return customerService.queryAllCustomer(customerVo);
    }

    /**
     * 添加客户
     * 请求类型为post 参数CustomerVo
     */
    @PostMapping
    public ResultObj addCustomer(@RequestBody CustomerVo customerVo){
        try {
            customerVo.setCreatetime(new Date());
            customerService.addCustomer(customerVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改客户
     * 请求类型为put 参数CustomerVo
     */
    @PutMapping
    public ResultObj updateCustomer(@RequestBody CustomerVo customerVo){
        try {
            customerService.updateCustomer(customerVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除客户
     * 请求类型为delete
     */
    @DeleteMapping
    public ResultObj updateCustomer(String identity){
        try {
            customerService.deleteCustomer(identity);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

}
