/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trand;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Anh
 */
public class DogResource {

    private String id;
    private Dogs dogs;

    /**
     * Creates a new instance of DogResource
     */
    private DogResource(String id) {
        this.id = id;
        this.dogs = Dogs.getInstance();
    }

    /**
     * Get instance of the DogResource
     */
    public static DogResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of DogResource class.
        return new DogResource(id);
    }

    /**
     * Retrieves representation of an instance of com.trand.DogResource
     * @return an instance of com.trand.Dog
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Dog getXml() {
        //TODO return proper representation object
        //return dogs.getDogs().get(id);
        System.out.println("GET GET GET GET");
        return Dogs.getInstance().getDogs().get(id);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_XML)
    public Dog postXml() {
        //TODO return proper representation object
        //return dogs.getDogs().get(id);
        System.out.println("POST POST POST");
        return Dogs.getInstance().getDogs().get(id);
    }

    /**
     * PUT method for updating or creating an instance of DogResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(Dog content) {
//        dogs.getDogs().get(id).setName(content.getName());
        Dogs.getInstance().getDogs().put(content.getName(), content);
    }

    /**
     * DELETE method for resource DogResource
     */
    @DELETE
//    @Produces(MediaType.APPLICATION_XML)
    public void delete() {
        System.out.println("DEL DEL DEL DEL DEL");
        Dogs.getInstance().getDogs().remove(id);
    }
}
