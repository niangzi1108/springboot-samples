package com.iphotowalking.samples.service;

import com.github.pagehelper.PageHelper;
import com.iphotowalking.samples.mybatis.mapper.CustomerMapper;
import com.iphotowalking.samples.mybatis.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jianglz
 * @since 2018/3/2.
 */
@Service
public class CustomerService {

    public static Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    CustomerMapper customerMapper;

    public Customer queryByOpenid(String openid) {
        return customerMapper.selectByOpenid(openid);
    }

    /**
     * 获取所有用户 （分页）
     * @param pageNum     当前页
     * @param pageSize       当前页展示数目
     * @return
     */
    public List<Customer> findAllCustomersPage(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return customerMapper.selectAllCustomersPage();
    }
}
