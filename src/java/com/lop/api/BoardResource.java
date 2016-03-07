package com.lop.api;

import com.lop.model.Board;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

/**
 * BoardResource REST Web Service.
 * Returns single Board upon the request from BoardsResource, the collection class.
 * 
 * @author Won Seob Seo 
 */
public class BoardResource {

    private String id;

    /**
     * Creates a new instance of BoardResource
     */
    private BoardResource(String id) {
        this.id = id;
    }

    /**
     * Get instance of the BoardResource
     */
    public static BoardResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of BoardResource class.
        return new BoardResource(id);
    }

    /**
     * Retrieves representation of an instance of com.lop.api.BoardResource
     * @return an instance of com.lop.model.Board
     */
    @GET
    @Produces("application/xml")
    public Board getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of BoardResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(Board content) {
    }

    /**
     * DELETE method for resource BoardResource
     */
    @DELETE
    public void delete() {
    }
}
