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

    /**
     * @api {get} /user/get/:openid 获取指定用户信息
     * @apiName   GetUseOne
     * @apiGroup User
     *
     * @apiParam  {String}  openid 用户openid
     * @apiExample {curl} 样例：
     *  curl -i http://api.example.com/v1/user/get/oPskq1SIo24iEDvYtso5UlDMqP7A
     *
     * @apiSuccess (成功返回) {int}  code 返回码 ，200表示成功，其他表示失败
     * @apiSuccess (成功返回) {String}  msg 返回信息 成功返回 OK
     * @apiSuccess (成功返回) {Object}  data 返回体数据
     * @apiSuccessExample   {json}  Success-Response:
     *     HTTP/1.1 200 OK
     *     {
     *        "code": 200
     *        "msg": "OK",
     *        "data":{
     *            nickname:" 小志" ,
     *            "customer_type": "BUYER"
     *        }
     *     }
     *
     *   @apiVersion 1.0.0
     */
    @GetMapping("/get/{openid}")
    public Map<String,Object> findByOpenid(@PathVariable("openid") String openid){

       Customer customer =  customerService.queryByOpenid(openid);
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("name",customer.getNickname());
        return retMap;
    }

    /**
     * @api {get} /user/getall 获取用户信息（分页）
     * @apiName   GetAllUserPage
     * @apiGroup User
     *
     * @apiParam  {String}  offset 返回记录的开始位置
     * @apiParam  {String}  limit 指定返回记录的数量
     * @apiExample {curl} 样例：
     *  curl -i http://api.example.com/v1/user/getall?offset=0&limit=5
     *
     * @apiSuccess (成功返回) {int}  code 返回码 ，200表示成功，其他表示失败
     * @apiSuccess (成功返回) {String}  msg 返回信息 成功返回 OK
     * @apiSuccess (成功返回) {Object}  data 返回体数据
     * @apiSuccessExample   {json}  Success-Response:
     *     HTTP/1.1 200 OK
     *     {
     *        "code": 200
     *        "msg": "OK",
     *        "data":{
     *            "nickname":" 小志" ,
     *            "customer_type": "BUYER"
     *        }
     *     }
     *
     *   @apiError 9000  请求超时
     *   @apiErrorExample {json} Error-Response:
     *   HTTP/1.1 400  Bad Request
     *   {
     *      "code": "9000"
     *      "msg": "请求超时"
     *   }
     *
     *   @apiVersion 1.0.0
     */
    @GetMapping("/getall")
    public WResponse findAllUsersPage(@RequestParam("offset") int pageNum, @RequestParam("limit") int pageSize){
        logger.info("pageNum:{},pageSize:{}",pageNum,pageSize);

        List<Customer> list =  customerService.findAllCustomersPage(pageNum,pageSize);
        return new WResponse(list);
    }
}
