/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.api;

import com.lop.model.Link;
import com.lop.model.Patient;
import com.lop.model.Patients;
import com.lop.model.User;
import com.lop.model.World;
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

/**
 * REST Web Service
 *
 * @author Anh
 */
@Path("/patients")
public class PatientsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PatientsResource
     */
    public PatientsResource() {
    }

    /**
     * Retrieves representation of an instance of com.lop.api.PatientsResource
     * @return an instance of com.lop.model.Patients
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Patient> getXml(@Context HttpServletRequest request) {
        HttpSession session = request.getSession();
        User me = (User) session.getAttribute("me");
        // System.out.println((User) session.getAttribute("me"));
        if (me == null) {
            System.out.println("me null");
            return new ArrayList<Patient>();
        }
        List<Patient> patients = new ArrayList<>(World.getInstance().getPatients().getById().values());
        for (Patient p : patients){
            // Link.addLinks(p.getMainDoctor(), context);
            Link.addLinks(p, context);
        }
        return patients;
    }

    /**
     * POST method for creating an instance of PatientResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response postXml(Patient content) {
        World.getInstance().getPatients().add(content);
        return Response.created(context.getAbsolutePath()).build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public PatientResource getPatientResource(@PathParam("id") String id) {
        return PatientResource.getInstance(id);
    }
    
    @Path("/{patientId}/records")
    public RecordsResource getRecordsResource() {
        return new RecordsResource(context);
    }
    
}
