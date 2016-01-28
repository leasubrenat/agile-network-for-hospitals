/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trand.resources;

import com.trand.model.Location;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

/**
 * REST Web Service
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
public class LocationResource {

    private String id;

    /**
     * Creates a new instance of LocationResource
     */
    private LocationResource(String id) {
        this.id = id;
    }

    /**
     * Get instance of the LocationResource
     */
    public static LocationResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of LocationResource class.
        return new LocationResource(id);
    }

    /**
     * Retrieves representation of an instance of com.trand.resources.LocationResource
     * @return an instance of com.trand.model.Location
     */
    @GET
    @Produces("application/xml")
    public Location getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of LocationResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(Location content) {
    }

    /**
     * DELETE method for resource LocationResource
     */
    @DELETE
    public void delete() {
    }
}
