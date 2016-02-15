/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package com.lop.api;

import com.lop.model.Notification;
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
public class NotificationResource {

    private String id;

    /**
     * Creates a new instance of NotificationResource
     */
    private NotificationResource(String id) {
        this.id = id;
    }

    /**
     * Get instance of the NotificationResource
     */
    public static NotificationResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of NotificationResource class.
        return new NotificationResource(id);
    }

    /**
     * Retrieves representation of an instance of com.lop.api.NotificationResource
     * @return an instance of com.lop.model.Notification
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Notification getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of NotificationResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(Notification content) {
    }

    /**
     * DELETE method for resource NotificationResource
     */
    @DELETE
    public void delete() {
    }
}
