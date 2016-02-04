/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.api;

import com.lop.model.User;
import com.lop.model.Users;
import com.lop.model.World;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import org.jboss.weld.context.http.HttpRequestContext;

/**
 * REST Web Service
 *
 * @author Anh
 */
@Path("/users")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class UsersResource {

    @Context
    private UriInfo uriInfo;
    @Context
    private HttpServletRequest request;

    /**
     * Creates a new instance of UsersResource
     */
    public UsersResource() {
    }

    /**
     * Retrieves representation of an instance of com.lop.api.UsersResource
     *
     * @return an instance of com.lop.model.Users
     */
    @GET
    public List<User> getXml() {
        List<User> users = new ArrayList<>(World.getInstance().getUsers().getById().values());
        for (User u : users) {
            addLinks(u);
        }
        return users;
    }

    /**
     * POST method for creating an instance of UserResource
     *
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    public Response postXml(User content) {
        World.getInstance().getUsers().add(content);
        URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(content.getId())).build();
        return Response.created(uri)
                .entity(content)
                .build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @GET
    @Path("{id}")
    public Response getUserResource(@PathParam("id") String id) {
        User user = addLinks(World.getInstance().getUsers().get(id));
        return Response.ok(getUriForSelf(user))
                .entity(user)
                .build();
    }

    @POST
    @Path("/login")
    public Response login(@Context HttpServletRequest request, User u) {
        User me = World.getInstance().getUsers().login(u);
        if (me != null) {
            HttpSession session = request.getSession();
            me = addLinks(me);
            session.setAttribute("me", me);
            // User userNoPassword = new User(me);
            URI uri = uriInfo.getAbsolutePathBuilder()
                    .path(UsersResource.class)
                    .path(Integer.toString(me.getId()))
                    .build();
            return Response.ok(uri)
                    .entity(me)
                    .build();
        } else {
            return Response.status(400)
                    .build();
        }
    }

    /**
     * *
     * @param user to be added with hateoas link
     * @return a user with the added links
     */
    private User addLinks(User user) {
        return user.addLink(getUriForSelf(user), "self");
    }

    public String getUriForSelf(User user) {
        String uri = uriInfo.getBaseUriBuilder()
                .path(UsersResource.class)
                .path(Long.toString(user.getId()))
                .build()
                .toString();
        return uri;
    }
}
