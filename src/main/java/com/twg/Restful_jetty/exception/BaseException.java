package com.twg.Restful_jetty.exception;

public class BaseException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8928843977991993360L;

	private String code;
	
	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
