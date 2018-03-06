package com.iphotowalking.samples.common;

/**
 * @author jianglz
 * @since 2018/3/2.
 */
public class WResponse {

    //响应码 200：成功返回
    private int code = 200;
    //响应描述
    private String msg = "OK";
    //响应数据
    private Object data;

    public WResponse(){
        
    }
    public WResponse(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
