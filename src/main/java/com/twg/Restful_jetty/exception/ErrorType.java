package com.twg.Restful_jetty.exception;

public enum ErrorType {
	Succ("0","操作成功"),
    Fail("1","操作失败"),
    ReqParamMissing("0001","请求参数缺少"),
    DataNotExist("1000","数据不存在"),
    DataExist("1001","数据已存在"),
    InvalidQuery("1002","无效的查询"),
    InvalidMod("1003","无效的修改"),
    SysErr("9999","系统错误");
 
    private String code;
    private String msg;
 
    ErrorType(String code,String msg) {
        this.code=code;
        this.msg = msg;
    }
 
    public String getCode() {
        return code;
    }
 
    public String getMsg() {
        return msg;
    }
}
