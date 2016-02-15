/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.api;

import com.lop.model.Link;
import com.lop.model.Notification;
import com.lop.model.World;
import java.util.List;
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
@Path("/notifications")
public class NotificationsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of NotificationsResource
     */
    public NotificationsResource() {
    }
    
    public NotificationsResource(@Context UriInfo uriInfo) {
        this.context = uriInfo;
    }

    /**
     * Retrieves representation of an instance of com.lop.api.NotificationsResource
     * @param id ID of the User from /users/{id}
     * @return an instance of com.lop.model.Notifications
     */
//    @GET
//    @Produces(MediaType.APPLICATION_XML)
//    public Notifications getXml() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Notification> getXml(@PathParam("id") String id) {
        List<Notification> notifications = World.getInstance().getUsers().getById().get(id).getNotifications();
        for (Notification n :notifications)
        {
            Link.addLinks(Integer.toString(n.getPost().getBoardId()), n.getPost(), context);
        }
        return notifications;
    }

    /**
     * POST method for creating an instance of NotificationResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response postXml(Notification content) {
        //TODO
        return Response.created(context.getAbsolutePath()).build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public NotificationResource getNotificationResource(@PathParam("id") String id) {
        return NotificationResource.getInstance(id);
    }
}
