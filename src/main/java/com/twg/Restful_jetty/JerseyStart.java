package com.twg.Restful_jetty;

import java.net.URI;

import org.glassfish.jersey.jetty.JettyHttpContainerFactory;

public class JerseyStart {

	public static void main(String[] args) {
		try {
			// uri只有第一个路径段将用作上下文路径，其余部分将被忽略
			JettyHttpContainerFactory.createServer(URI.create("http://localhost:8080/"), new RestApplication());
		} catch (Exception e) {
			throw e;
		}
	}
}
