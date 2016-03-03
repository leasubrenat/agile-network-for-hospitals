/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.api;

import com.lop.model.Record;
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
public class RecordResource {

    private String id;

    /**
     * Creates a new instance of RecordResource
     */
    private RecordResource(String id) {
        this.id = id;
    }

    /**
     * Get instance of the RecordResource
     */
    public static RecordResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of RecordResource class.
        return new RecordResource(id);
    }

    /**
     * Retrieves representation of an instance of com.lop.api.RecordResource
     * @return an instance of com.lop.model.Record
     */
    @GET
    @Produces("application/xml")
    public Record getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of RecordResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(Record content) {
    }

    /**
     * DELETE method for resource RecordResource
     */
    @DELETE
    public void delete() {
    }
}
