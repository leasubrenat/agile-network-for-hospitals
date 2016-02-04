/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.api;

import com.lop.model.Patient;
import com.lop.model.World;
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
public class PatientResource {

    private String id;

    /**
     * Creates a new instance of PatientResource
     */
    private PatientResource(String id) {
        this.id = id;
    }

    /**
     * Get instance of the PatientResource
     */
    public static PatientResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of PatientResource class.
        return new PatientResource(id);
    }

    /**
     * Retrieves representation of an instance of com.lop.api.PatientResource
     * @return an instance of com.lop.model.Patient
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Patient getXml() {
        return World.getInstance().getPatients().getById().get(id);
    }

    /**
     * PUT method for updating or creating an instance of PatientResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(Patient content) {
        World.getInstance().getPatients().getById().replace(id, content); 
    }

    /**
     * DELETE method for resource PatientResource
     */
    @DELETE
    public void delete() {
        World.getInstance().getPatients().getById().remove(id);
    }
}
