package com.iphotowalking.samples.mybatis.mapper;


import com.iphotowalking.samples.mybatis.model.Customer;

import java.util.List;

public interface CustomerMapper {
    Customer selectByPrimaryKey(Integer customer_id);

    Customer selectByOpenid(String openid);

    List<Customer> selectAllCustomersPage();
}