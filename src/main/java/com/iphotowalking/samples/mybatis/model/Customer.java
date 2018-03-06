package com.iphotowalking.samples.mybatis.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Customer {
    private Integer customer_id;

    private String open_id;

    private String trader_password;

    private Integer super_id;

    private String nickname;

    private String head_img;

    private String customer_type;

    private String name;

    private String mobile;

    private String qcode;

    private Byte is_certify;

    private Byte is_bank;

    private Byte status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date create_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date up_time;

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id == null ? null : open_id.trim();
    }

    public String getTrader_password() {
        return trader_password;
    }

    public void setTrader_password(String trader_password) {
        this.trader_password = trader_password == null ? null : trader_password.trim();
    }

    public Integer getSuper_id() {
        return super_id;
    }

    public void setSuper_id(Integer super_id) {
        this.super_id = super_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img == null ? null : head_img.trim();
    }

    public String getCustomer_type() {
        return customer_type;
    }

    public void setCustomer_type(String customer_type) {
        this.customer_type = customer_type == null ? null : customer_type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getQcode() {
        return qcode;
    }

    public void setQcode(String qcode) {
        this.qcode = qcode == null ? null : qcode.trim();
    }

    public Byte getIs_certify() {
        return is_certify;
    }

    public void setIs_certify(Byte is_certify) {
        this.is_certify = is_certify;
    }

    public Byte getIs_bank() {
        return is_bank;
    }

    public void setIs_bank(Byte is_bank) {
        this.is_bank = is_bank;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUp_time() {
        return up_time;
    }

    public void setUp_time(Date up_time) {
        this.up_time = up_time;
    }
}