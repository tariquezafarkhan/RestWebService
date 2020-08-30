package com.task;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/tasks")
public class TaskResource {
	
	public TaskDAO o = new TaskDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		return Response.ok(o.getAll()).build();
	}
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id) {
		return Response.ok(o.get(id)).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Task task) throws URISyntaxException {
		int newId = o.add(task);
		URI uri = new URI("/taks/" + newId);
		return Response.created(uri).build();
	}
	
	@PUT
	@Path("{id}")
	public Response update(@PathParam("id") int id, Task task) {
		task.setId(id);
		if(o.update(task)) {
			return Response.ok().build();
		} else {
			return Response.notModified().build();
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") int id) {
		if(o.delete(id)) {
			return Response.ok().build();
		} else {
			return Response.notModified().build();
		}
	}
}
