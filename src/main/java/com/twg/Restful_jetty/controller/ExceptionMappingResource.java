package com.twg.Restful_jetty.controller;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.eclipse.jetty.http.HttpStatus;

import com.twg.Restful_jetty.exception.BaseException;
import com.twg.Restful_jetty.exception.ErrorType;
import com.twg.Restful_jetty.util.Result;

/**
 * 异常处理器
 * @author twg
 *
 */
@Provider
public class ExceptionMappingResource implements ExceptionMapper<Throwable> {
 
 
	@Override
	public Response toResponse(Throwable t) {
		// 返回模型
		Result re = null;
		
		if (t instanceof BaseException) {
			BaseException e = (BaseException) t;
			re = new Result(e.getCode(), e.getMessage());
			System.out.println(re);
		} else {
			re = new Result(ErrorType.Fail.getCode(), t.getMessage());
			System.out.println(t.getMessage());
		}
		// 返回响应
		return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).entity(re).build();
	}
}
