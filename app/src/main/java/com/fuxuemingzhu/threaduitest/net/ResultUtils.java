package com.fuxuemingzhu.threaduitest.net;

import com.alibaba.fastjson.JSON;

public class ResultUtils {
    private int status;

    private String data;

    private String message;

    public ResultUtils() {
    }

    public ResultUtils(int status, String data, String message) {
        super();
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
