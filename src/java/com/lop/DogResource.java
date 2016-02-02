/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop;

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
public class DogResource {

    private String id;
    private String method;
    private Dogs collection;
    
    /**
     * Creates a new instance of DogResource
     */
    private DogResource(String id, String method) {
        this.id = id;
        this.method = method;
        this.collection = World.getInstance().getDogs();
    }

    /**
     * Get instance of the DogResource
     */
    public static DogResource getInstance(String id, String search) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of DogResource class.
        return new DogResource(id, search);
    }

    /**
     * Retrieves representation of an instance of com.trand.DogResource
     * @return an instance of com.trand.model.Dog
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Dog getXml() {
        //TODO return proper representation object
        return collection.get(id, method);
    }

    /**
     * PUT method for updating or creating an instance of DogResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(Dog content) {
    }

    /**
     * DELETE method for resource DogResource
     */
    @DELETE
    public void delete() {
    }
}
