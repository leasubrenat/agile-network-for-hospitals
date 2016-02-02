/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Anh
 */
public class CatResource {

    private String id;
    private Cats collection;

    /**
     * Creates a new instance of CatResource
     */
    private CatResource(String id) {
        this.id = id;
        this.collection = Cats.getInstance();
    }

    /**
     * Get instance of the CatResource
     */
    public static CatResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of CatResource class.
        return new CatResource(id);
    }

    /**
     * Retrieves representation of an instance of com.trand.CatResource
     * @return an instance of com.trand.Cat
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Cat getXml() {
        //TODO return proper representation object
        try {
            int index = Integer.parseInt(id);
            return collection.getCats().get(index);
        } catch (NumberFormatException numberFormatException) {
            throw new BadRequestException("ID should be a number.");
        } catch (IndexOutOfBoundsException e) {
            throw new NotFoundException("The ID requested is not found.");
        }
    }

    /**
     * PUT method for updating or creating an instance of CatResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(Cat content) {
    }

    /**
     * DELETE method for resource CatResource
     */
    @DELETE
    public void delete() {
    }
}
