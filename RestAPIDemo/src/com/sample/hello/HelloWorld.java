package com.sample.hello;

import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/hello")
public class HelloWorld {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getList(
			@QueryParam("to") @DefaultValue("1") String to,
			@QueryParam("from") @DefaultValue("2") String from,
			@QueryParam("query") @DefaultValue("3") List<String> list,
			@HeaderParam("Content-Type") String contentType,
			@Context HttpHeaders httpHeaders,
			@Context UriInfo uriInfo,
			@MatrixParam("author") String author,
			@MatrixParam("country") String country) {

		NewCookie cookie1 = new NewCookie("myStrCookie", "cookieStrVal");
		NewCookie cookie2 = new NewCookie("myDateCookie", "2017-03-28");
		NewCookie cookie3 = new NewCookie("myIntCookie", "100");

		System.out.println(
				" to " + to + " from " + from + " query " + list + 
				" HttpHeader " + httpHeaders.getRequestHeaders());

		System.out.println(" path parameter " + uriInfo.getPathParameters());
		System.out.println(" query parameter " + uriInfo.getQueryParameters());
		JsonObject obj = Json.createObjectBuilder().add("1", "Hello World").build();
		return Response.ok(obj).cookie(cookie1, cookie2, cookie3).build();
	}

}
