/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.api;

import com.lop.model.Link;
import com.lop.model.User;
import com.lop.model.World;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Anh
 */
public class UserResource {

    private String id;

    /**
     * Creates a new instance of UserResource
     */
    private UserResource(String id) {
        this.id = id;
    }

    /**
     * Get instance of the UserResource
     */
    public static UserResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of UserResource class.
        return new UserResource(id);
    }

    /**
     * Retrieves representation of an instance of com.lop.api.UserResource
     *
     * @return an instance of com.lop.model.User
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getXml(@Context UriInfo uriInfo) {
//        return World.getInstance().getUsers().get(id);
        User user = Link.addLinks(World.getInstance().getUsers().get(id), uriInfo);
        return Response.ok(Link.getUriForSelf(user, uriInfo))
                .entity(user)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of UserResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(User content) {
//        World.getInstance().getUsers().getById().replace(id, content);
        World.getInstance().getUsers().modify(id, content);
    }

    /**
     * DELETE method for resource UserResource
     */
    @DELETE
    public void delete() {
        World.getInstance().getUsers().getById().remove(id);
    }
    
    /**
     * Sub-resource locator to Notification
     */
    @Path("notifications")
    public NotificationsResource getNotificationsResource() {
        return new NotificationsResource();
    }
}
