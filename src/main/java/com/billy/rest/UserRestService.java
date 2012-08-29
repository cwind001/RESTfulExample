package com.billy.rest;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/users")
public class UserRestService {
	@GET
	public Response getUser() {
		return Response.status(200).entity("getUser is called").build();
	}

	@GET
	@Path("/vip")
	public Response getVip() {
		return Response.status(200).entity("getVip is called").build();
	}

	@GET
	@Path("/{param}")
	public Response getUserByName(@PathParam("param") String name) {
		return Response.status(200)
				.entity("getUserByName is called, name: " + name).build();
	}

	@GET
	@Path("{id : \\d+}")
	public Response getUserById(@PathParam("id") String id) {
		return Response.status(200).entity("getUserById is called, id : " + id)
				.build();
	}
	
	@GET
	@Path("/username/{username : [a-zA-Z][a-zA-Z_0-9]}")
	public Response getUserByUserName(@PathParam("username") String username) {
 
	   return Response.status(200)
		.entity("getUserByUserName is called, username : " + username).build();
 
	}
 
	@GET
	@Path("/books/{isbn : \\d+}")
	public Response getUserBookByISBN(@PathParam("isbn") String isbn) {
 
	   return Response.status(200)
		.entity("getUserBookByISBN is called, isbn : " + isbn).build();
 
	}
	
	@GET
	@Path("{year}/{month}/{day}")
	public Response getUserHistory(
			@PathParam("year") int year,
			@PathParam("month") int month, 
			@PathParam("day") int day) {
 
	   String date = year + "/" + month + "/" + day;
 
	   return Response.status(200)
		.entity("getUserHistory is called, year/month/day : " + date)
		.build();
 
	}
	
	@GET
	@Path("/query")
	public Response getUsers(@Context UriInfo info) {
 
		String from = info.getQueryParameters().getFirst("from");
		String to = info.getQueryParameters().getFirst("to");
		List<String> orderBy = info.getQueryParameters().get("orderBy");
 
		return Response
		   .status(200)
		   .entity("getUsers is called, from : " + from + ", to : " + to
			+ ", orderBy" + orderBy.toString()).build();
 
	}
	
	@GET
	@Path("/query")
	public Response getUsers(
		@DefaultValue("1000") @QueryParam("from") int from,
		@DefaultValue("999")@QueryParam("to") int to,
		@DefaultValue("name") @QueryParam("orderBy") List<String> orderBy) {
 
		return Response
		   .status(200)
		   .entity("getUsers is called, from : " + from + ", to : " + to
			+ ", orderBy" + orderBy.toString()).build();
 
	}
	
	@POST
	@Path("/add")
	public Response addUser(
		@FormParam("name") String name,
		@FormParam("age") int age) {
 
		return Response.status(200)
			.entity("addUser is called, name : " + name + ", age : " + age)
			.build();
 
	}
	
	@GET
	@Path("/get")
	public Response addUser(@HeaderParam("user-agent") String userAgent) {
 
		return Response.status(200)
			.entity("addUser is called, userAgent : " + userAgent)
			.build();
 
	}

}
