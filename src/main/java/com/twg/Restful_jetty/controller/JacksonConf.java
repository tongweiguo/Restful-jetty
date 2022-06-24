package com.twg.Restful_jetty.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * 日期格式处理
 * @author twg
 *
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)  //必须增加@Produces注解
public class JacksonConf extends JacksonJsonProvider {
 
	
 
	@Override
	public void writeTo(Object value, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
	                    MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException {
		//log.info("------------date format convert-------------");
		// 将写给客户端的数据中的Date类型字段转换为特定格式
		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapper.setDateFormat(sdf);
 
		// 必须设置, 写给客户端的json数据中,Date类型字段才能转为自定义的格式
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.writeValue(entityStream, value);// 结果写给客户端
	}

}
