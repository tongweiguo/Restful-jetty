package com.twg.Restful_jetty.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.twg.Restful_jetty.util.Result;

@Path("/user")
public class UserController {

	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String hi() {
		return "hello jersey";
	}
 
	@GET
	@Path("/{username}/{age}")
	@Produces(MediaType.APPLICATION_JSON)
	public Result findByKey(@PathParam("username") String username, @PathParam("age") int age) {
		System.out.println("接收到请求" + username);
//		User user = new User();
//		user.setUsername(username);
//		user.setAge(age);
//		user.setStatus(20);
//		user.setModdate(new Date());
		return Result.ok("{id:12,name:\"twg\"}");
 
	}
}
