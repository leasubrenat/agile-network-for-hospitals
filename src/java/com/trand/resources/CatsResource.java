/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trand.resources;

import com.trand.model.Cats;
import com.trand.model.Cat;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Anh
 */
@Path("/cats")
public class CatsResource {

    @Context
    private UriInfo context;
    private Cats collection;

    /**
     * Creates a new instance of CatsResource
     */
    public CatsResource() {
        collection = Cats.getInstance();
    }

    /**
     * Retrieves representation of an instance of com.trand.CatsResource
     * @return an instance of com.trand.Cats
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Cats getXml() {
        //TODO return proper representation object
        return collection;
    }

    /**
     * POST method for creating an instance of CatResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response postXml(Cat content) {
        collection.getCats().add(content);
        return Response.created(context.getAbsolutePath()).build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public CatResource getCatResource(@PathParam("id") String id) {
        return CatResource.getInstance(id);
    }
}
