package com.iphotowalking.samples.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.iphotowalking.samples.common.WResponse;
import com.iphotowalking.samples.exception.BusinessException;
import com.iphotowalking.samples.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianglz
 * @since 2018/3/5.
 */
@RestController
@RequestMapping("/test")
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    RestTemplate restTemplate;

    /**
     * @api {get} /test/redis/get/:key 获取redis键值
     * @apiName   GetRedisKeyValue
     * @apiGroup Test
     *
     * @apiParam  {String}  key redis key值
     *  
     * @apiSuccess (成功响应) {int}  code 返回码 ，200表示成功，其他表示失败
     * @apiSuccess (成功响应) {String}  msg 返回信息 成功返回 OK
     * @apiSuccess (成功响应) {Object}  data 返回体数据
     * @apiSuccessExample   {json}  Success-Response:
     *     HTTP/1.1 200 OK
     *     {
     *        "code": 200
     *        "msg": "OK",
     *        "data":{
     *            value:" springboot_test"
     *        }
     *     }
     *     
     *   @apiError 9999  业务异常
     *   @apiErrorExample {json} Error-Response:
     *   HTTP/1.1 400  Bad Request
     *   {
     *      "code": "9999"
     *      "msg": "键值不存在"
     *   }
     *
     *   @apiVersion 1.0.0
     */
    @GetMapping("/redis/get/{key}")
    public WResponse testRedisGet(@PathVariable("key") String key) {
        String value = (String) redisUtils.get(key);
        logger.info(key + ":" + value);
        return new WResponse(value);
    }

    /**
     * @api {post} /test/redis/set 设置redis键值
     * @apiName   SetRedisKeyValue
     * @apiGroup Test
     *
     * @apiParam  {String}  key redis key值
     * @apiParam  {String}  value redis value值
     *
     * @apiExample  {json} 请求样例：
     * {
     *     "key" :"springboot_test",
     *     "value":"this is a test value"
     * }
     *
     * @apiSuccess (成功响应) {int}  code 返回码 ，200表示成功，其他表示失败
     * @apiSuccess (成功响应) {String}  msg 返回信息 成功返回 OK
     * @apiSuccessExample   {json}  Success-Response:
     *     HTTP/1.1 200 OK
     *     {
     *        "code": 200
     *        "msg": "OK"
     *     }
     *
     *   @apiError 9998  参数不合法
     *   @apiErrorExample {json} Error-Response:
     *   HTTP/1.1 400  Bad Request
     *   {
     *      "code": "9998"
     *      "msg": "参数不合法"
     *   }
     *
     *   @apiVersion 1.0.0
     */
    @PostMapping("/redis/set")
    public WResponse testRedisSet(String jsonData){
        JSONObject jsonObject = JSON.parseObject(jsonData);
        String key = jsonObject.getString("key");
        String value = jsonObject.getString("value");
        redisUtils.set(key,value);
        return new WResponse();
    }

    @GetMapping("/error")
    public WResponse testError(){
        throw new BusinessException("9999","this is an error test");
    }

    /**
     * @api {get} /test/redis/wx_token 获取微信access_token
     * @apiName   Get Weixin AccessToken
     * @apiGroup Test
     *
     * @apiSuccess (成功响应) {int}  code 返回码 ，200表示成功，其他表示失败
     * @apiSuccess (成功响应) {String}  msg 返回信息  成功返回 OK
     * @apiSuccess (成功响应) {Object}  data 返回体数据
     * @apiSuccessExample   {json}  Success-Response:
     *     HTTP/1.1 200 OK
     *     {
     *       "code": 200,
     *       "msg": "OK",
     *       "data": {
     *       "access_token": "7_mH8AiwiS47jyXpB6muhgMaYpp4nfgYvU_KN5InGZKaopGvjRN27GjVd57cuqBR3G1yMiuhp_s6YVUxGZfGJtqleIimqG__6EzakHSHHxK9_pI1aiwuwKcszLwCoV52A_WMJ-9LoMp-9zNfgcENPhAFAHQS",
     *           "expires_in": 7200
     *        }
     *      }
     *   @apiError  9997   参数不存在
     *   @apiErrorExample Error-Response:
     *   HTTP/1.1 400  Bad Request
     *   {
     *      "code": "9997"
     *      "msg": "appid参数不存在"
     *   }
     *
     *   @apiVersion 1.0.0
     */
    @GetMapping("/rest/wx_token")
    public WResponse testRest() {
        // "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
        String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type={grant_type}&appid={appid}&secret={secret}";
        Map<String, Object> params = new HashMap<>();
        params.put("grant_type", "client_credential");
        params.put("appid", "wx8e9c7ee8d8953b17");
        params.put("secret", "5876b1563785d0138d22c9b2614de79b");
        Map resp = restTemplate.getForObject(ACCESS_TOKEN_URL , Map.class,params);
        return new WResponse(resp);
//        ResponseEntity<Map> responseEntity = restTemplate.getForEntity(ACCESS_TOKEN_URL,Map.class,params);
//        System.out.println(responseEntity.getBody());
//        return new WResponse(responseEntity.getBody());
    }
}
