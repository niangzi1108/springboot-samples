package com.iphotowalking.samples.web;

import com.iphotowalking.samples.common.WResponse;
import com.iphotowalking.samples.mybatis.model.Customer;
import com.iphotowalking.samples.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jianglz
 * @since 2018/3/2.
 */
@RestController
@RequestMapping("/user")
public class CustomerController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    CustomerService customerService;

    @GetMapping("/get/{openid}")
    public Map<String,Object> findByOpenid(@PathVariable("openid") String openid){

       Customer customer =  customerService.queryByOpenid(openid);
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("name",customer.getNickname());
        return retMap;
    }

    @GetMapping("/getall/{pageNum}/{pageSize}")
    public WResponse findAllUsersPage(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        logger.info("pageNum:{},pageSize:{}",pageNum,pageSize);

        List<Customer> list =  customerService.findAllCustomersPage(pageNum,pageSize);
        return new WResponse(list);
    }
}
