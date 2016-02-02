/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Anh
 */
@Path("/dogs")
public class DogsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DogsResource
     */
    public DogsResource() {
    }

    /**
     * Retrieves representation of an instance of com.trand.DogsResource
     * @return an instance of com.trand.model.Dogs
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Dogs getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * POST method for creating an instance of DogResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response postXml(Dog content) {
        //TODO
        return Response.created(context.getAbsolutePath()).build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public DogResource getDogResource(
            @PathParam("id") String id,
            @DefaultValue("id") @QueryParam("search") String search) {
        return DogResource.getInstance(id, search);
    }
}
