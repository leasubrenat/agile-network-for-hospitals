/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.api;

import com.lop.model.Post;
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
public class PostResource {

    private String id;

    /**
     * Creates a new instance of PostResource
     */
    private PostResource(String id) {
        this.id = id;
    }

    /**
     * Get instance of the PostResource
     */
    public static PostResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of PostResource class.
        return new PostResource(id);
    }

    /**
     * Retrieves representation of an instance of com.lop.api.PostResource
     * @return an instance of com.lop.model.Post
     */
    @GET
    @Produces("application/xml")
    public Post getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of PostResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(Post content) {
    }

    /**
     * DELETE method for resource PostResource
     */
    @DELETE
    public void delete() {
    }
}
