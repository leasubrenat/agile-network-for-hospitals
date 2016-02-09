/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.api;

import com.lop.model.Link;
import com.lop.model.Post;
import com.lop.model.Posts;
import com.lop.model.World;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
@Path("/posts")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class PostsResource {

    @Context
    private UriInfo uriInfo;

    /**
     * Creates a new instance of PostsResource
     */
    public PostsResource() {
    }

    /**
     * Retrieves representation of an instance of com.lop.api.PostsResource
     * @return an instance of com.lop.model.Posts
     */
    @GET
    @Produces("application/xml")
    public List<Post> getXml() {
        List<Post> posts = new ArrayList<>(World.getInstance().getPosts().getById().values());
        for (Post b : posts) {
            Link.addLinks(b, uriInfo);
        }
        return posts;
    }

    /**
     * POST method for creating an instance of PostResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    public Response postXml(Post content) {
        //set the POST author using username
        String authorName = content.getAuthor().getUsername();
        try {
            content.setAuthor(World.getInstance().getUsers().getByUsername().get(authorName));
        } catch (NullPointerException e) {
            return Response.status(400).entity("The username not found").build();
        }
        
        World.getInstance().getPosts().add(content);
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
    public Response getPostResource(@PathParam("id") String id) {
        Post post = Link.addLinks(World.getInstance().getPosts().get(id), uriInfo);
        return Response.ok(Link.getUriForSelf(post, uriInfo))
                .entity(post)
                .build();
    }
}
