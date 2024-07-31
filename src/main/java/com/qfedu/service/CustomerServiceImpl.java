package com.qfedu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dao.CustomerMapper;
import com.qfedu.pojo.Customer;
import com.qfedu.vo.CustomerVo;
import com.qfedu.vo.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerMapper customerMapper;
    /**
     * 分页查询
     * @return
     */
    @Override
    public DataGridView queryAllCustomer(CustomerVo customerVo) {
        //通过PageHelper完成分页查询
        Page<Object> page = PageHelper.startPage(customerVo.getPage(), customerVo.getLimit());
        List<Customer> customers = customerMapper.queryAllCustomer(customerVo);
        return new DataGridView(page.getTotal(),customers);
    }

    /**
     * 添加客户
     *
     */
    @Override
    public void addCustomer(CustomerVo customerVo) {
        customerMapper.addCustomer(customerVo);
    }

    @Override
    public void updateCustomer(CustomerVo customerVo) {
        customerMapper.updateCustomer(customerVo);
    }

    @Override
    public void deleteCustomer(String identity) {
        customerMapper.deleteCustomer(identity);
    }
}
