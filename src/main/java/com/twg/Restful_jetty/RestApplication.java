package com.twg.Restful_jetty;

import org.glassfish.jersey.server.ResourceConfig;

import com.twg.Restful_jetty.controller.JacksonConf;

/**
 * servlet应用层
 * @author twg
 *
 */
public class RestApplication extends ResourceConfig {
	public RestApplication() {
		System.out.println("---------ResourceConfig---------");
		// 服务类所在的包路径
		packages("com.twg.Restful_jetty.controller");
		// 注册日期格式转换层
		register(JacksonConf.class);
 
		// register(JacksonJsonProvider.class);
//		register(ValidationFeature.class);
	}
}
