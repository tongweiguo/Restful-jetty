package com.twg.Restful_jetty;

import com.twg.Restful_jetty.server.JettyServer;

public class JettyStart {

	public static void main(String... args) {
		new JettyStart().start();
	}
 
	private JettyServer server;
 
	public JettyStart() {
		server = new JettyServer();
	}
 
	public void start() {
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			server.destroy();
		}
	}
}
