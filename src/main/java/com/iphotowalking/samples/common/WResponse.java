package com.iphotowalking.samples.common;

/**
 * @author jianglz
 * @since 2018/3/2.
 */
public class WResponse {

    //响应码 0000：成功返回
    private String code = "0000";
    //响应描述
    private String msg = "OK";
    //响应数据
    private Object data;

    public WResponse(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
