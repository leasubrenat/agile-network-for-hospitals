/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trand.resources;

import com.trand.model.Location;
import com.trand.model.Locations;
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
@Path("/locations")
public class LocationsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LocationsResource
     */
    public LocationsResource() {
    }

    /**
     * Retrieves representation of an instance of com.trand.resources.LocationsResource
     * @return an instance of com.trand.model.Locations
     */
    @GET
    @Produces("application/xml")
    public Locations getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * POST method for creating an instance of LocationResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    public Response postXml(Location content) {
        //TODO
        return Response.created(context.getAbsolutePath()).build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public LocationResource getLocationResource(@PathParam("id") String id) {
        return LocationResource.getInstance(id);
    }
}
