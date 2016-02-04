/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.api;

import com.lop.model.Location;
import com.lop.model.World;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Anh
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
     * Retrieves representation of an instance of com.lop.api.LocationResource
     * @return an instance of com.lop.model.Location
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Location getXml() {
        return World.getInstance().getLocations().getById().get(id);
    }

    /**
     * PUT method for updating or creating an instance of LocationResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(Location content) {
        World.getInstance().getLocations().getById().replace(id, content);
    }

    /**
     * DELETE method for resource LocationResource
     */
    @DELETE
    public void delete() {
        World.getInstance().getLocations().getById().remove(id);
    }
}
