package com.iphotowalking.samples.common;

/**
 * @author jianglz
 * @since 2018/3/5.
 */
public class WError {

    private String code = "500";

    private String msg;

    public WError() {
        super();
    }

    public WError(String msg) {
        this.msg = msg;
    }

    public WError(String code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
