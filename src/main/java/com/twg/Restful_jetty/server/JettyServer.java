package com.twg.Restful_jetty.server;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;
import org.glassfish.jersey.servlet.ServletContainer;

import com.twg.Restful_jetty.RestApplication;

/**
 * restful服务启动类
 * @author twg
 *
 */
public class JettyServer {

			
	private static final int port = 8010;
	private static final String contextPath = "/";
	private static final String resourceBase = "src/main/resources";
	private static final int maxThreads = 10;
	//private static final String ipWhiteList = "";
 
	private Server server;
 
	public JettyServer() {
	}
 
	public void start() throws Exception {
		// 创建服务
		//server = new Server(8010);
		server = new Server(createThreadPool());
		// 添加连接
		server.addConnector(createConnector());
		// 设置处理层
		server.setHandler(createHandlers());
		// 设置可停止
		server.setStopAtShutdown(true);
		// 启动服务
		server.start();
	}
 
	/**
	 * 阻塞等待
	 * @throws InterruptedException
	 */
	public void join() throws InterruptedException {
		//阻塞等待
		server.join();
	}
 
	/**
	 * 销毁服务
	 */
	public void destroy() {
		//销毁服务
		server.destroy();
	}
	
	/**
	 * 停止服务
	 * @throws Exception
	 */
	public void stop() throws Exception {
		//停止服务
		server.stop();
	}
 
	/**
	 * 创建队列线程池
	 * @return ThreadPool
	 */
	private ThreadPool createThreadPool() {
		// 创建队列线程池
		QueuedThreadPool threadPool = new QueuedThreadPool();
		// 设置线程池名称
		threadPool.setName("embed-jetty-http");
		// 设置最小线程数
		threadPool.setMinThreads(1);
		// 设置最大线程数
		threadPool.setMaxThreads(maxThreads);
		// 返回线程池
		return threadPool;
	}
 
	
	/**
	 * 创建连接器
	 * @return
	 */
	private ServerConnector createConnector() {
		// 创建连接器
		ServerConnector connector = new ServerConnector(server);
		// 设置端口
		connector.setPort(port);
		// 返回连接器
		return connector;
	}
	
	/**
	 * 创建所有处理层
	 * @return
	 */
	private HandlerCollection createHandlers() {
		// 创建处理层
		ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		// 设置根路径
		handler.setContextPath(contextPath);
		// 设置基础资源
		handler.setResourceBase(resourceBase);
		// 添加容器
		ServletHolder holder = handler.addServlet(ServletContainer.class, "/*");
		// 设置初始话顺序
		holder.setInitOrder(1);
		// 设置应用
		holder.setInitParameter("javax.ws.rs.Application", RestApplication.class.getName());
		///holder.setInitParameter("jersey.config.server.provider.packages", "com.twg.Restful_jetty.controller");
		// 创建处理层集
		HandlerCollection handlerCollection = new HandlerCollection();
		// 设置处理层
		handlerCollection.setHandlers(new Handler[]{handler});
		// 返回所有处理层
		return handlerCollection;
	}
	
	/**
	 * 创建web上下文
	 * @return
	 */
	public WebAppContext createWebAppContext() {
		// 创建web上下文
		WebAppContext webapp = new WebAppContext();
		// 设置描述符位置
		//webapp.setDescriptor("./web/WEB-INF/web.xml");
		// 设置web资源
		webapp.setResourceBase("E:/apache-tomcat-7.0.47/webapps/test");
		// 也可以通过设置 war 包的方式
		// webapp.setWar("C:/TVPlay.war");
		// 设置上下文路径
		webapp.setContextPath("/");
		// 返回web上下文
		return webapp;
	}
 
//	private static InetAccessHandler getFireWallHandler() {
//		InetAccessHandler ipHandler = new InetAccessHandler();
//		if (StrUtil.isBlank(ipWhiteList)) {// 空,不配置,则不校验
//			return ipHandler;
//		}
//
//		String[] ipList = ipWhiteList.split(",");
//		for (String ip : ipList) {
//			ipHandler.include(ip);
//		}
//		return ipHandler;
//	}

}
