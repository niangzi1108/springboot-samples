package com.iphotowalking.samples.web;

import com.iphotowalking.samples.common.WResponse;
import com.iphotowalking.samples.exception.BusinessException;
import com.iphotowalking.samples.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
     *  @apiParam {String} redis key
     *  @apiSuccess {String} redis value
     *
     * @apiSuccessExample      Success-Response:
     *     HTTP/1.1 200 OK
     *     {
     *       "springboot_test": "service-a",
     *     }
     *   @apiError error
     *   @apiErrorExample Error-Response:
     *   HTTP/1.1 500
     *     {
     *       "code": "9999"
     *       "msg": "Not Found Key-Value"
     *     }
     *
     * @param key
     * @return
     */
    @GetMapping("/redis/get/{key}")
    public String testRedisGet(@PathVariable("key") String key) {
        String value = (String) redisUtils.get(key);
        logger.info(key + ":" + value);
        return value;
    }

    @GetMapping("/error")
    public WResponse testError(){
        throw new BusinessException("9999","this is an error test");
    }

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
