package com.yingsu.newbuss.entity.base;

public class ResultBase {
    // 返回结果编码默认为“1”，可调用setResultCode(String resultCode)方法修改。
    private String resultCode = "1";
    // 返回信息默认为"success"，可调用set方法修改
    private String resultMsg = "success";
    // 返回对象信息，一般为查询时要返回详细信息，增删改基本不用
    private Object object;

    // 以下为set()get()方法
    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
