/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trand.resources;

import com.trand.model.Task;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
@Path("/tasks")
public class TasksResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TasksResource
     */
    public TasksResource() {
    }

    /**
     * Retrieves representation of an instance of com.trand.resources.TasksResource
     * @return an instance of com.trand.model.Task
     */
    @GET
    @Produces("application/xml")
    public Task getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * POST method for creating an instance of TaskResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    public Response postXml(Task content) {
        //TODO
        return Response.created(context.getAbsolutePath()).build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public TaskResource getTaskResource(@PathParam("id") String id) {
        return TaskResource.getInstance(id);
    }
}
