package com.twg.Restful_jetty.util;

import com.twg.Restful_jetty.exception.ErrorType;

public class Result {
	private String code;
	private String msg;
	private Object body;
 
	public Result() {
	}
 
	public Result(ErrorType type) {
		this.code = type.getCode();
		this.msg = type.getMsg();
	}
 
	public Result(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
 
	public Result(String code, String msg, Object body) {
		this.code = code;
		this.msg = msg;
		this.body = body;
	}
 
	public static Result gen(String code, String msg, Object data) {
		return new Result(code, msg, data);
	}
 
	public static Result gen(ErrorType type, Object data) {
		return new Result(type.getCode(), type.getMsg(), data);
	}
 
	public static Result ok() {
		return gen(ErrorType.Succ, null);
	}
 
	public static Result ok(Object data) {
		return gen(ErrorType.Succ, data);
	}
 
	public static Result fail(String msg) {
		return new Result(ErrorType.Fail.getCode(), msg, null);
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

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}
	
}
