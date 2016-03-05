package com.lop.api;

import com.lop.model.Link;
import com.lop.model.Record;
import com.lop.model.Records;
import com.lop.model.Task;
import com.lop.model.User;
import com.lop.model.World;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
 * RecordsResource REST Web Service
 *
 * @author Won Seob Seo
 */
@Path("/records")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class RecordsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RecordsResource
     */
    public RecordsResource() {
    }
    
    public RecordsResource(@Context UriInfo context) {
        this.context = context;
    }

    /**
     * Retrieves representation of an instance of com.lop.api.RecordsResource
     * @param patientId patient ID of whom this record belongs to
     * @return List of records
     */
    @GET
    @Produces("application/xml")
    public List<Record> getXml(@PathParam("patientId") String patientId) {
        List<Record> records = null;
        // when there is a UserId param show only tasks for the user, show all tasks when no UserId param
        if (patientId != null) {
            records = new ArrayList<>(World.getInstance().getPatients().getById().get(patientId).getRecords());
            for (Record r : records) {
                Link.addLinks(patientId, r, context);
            }
        } else {
            records = new ArrayList<>(World.getInstance().getRecords().getById().values());
            for (Record r : records) {
                Link.addLinks(Integer.toString(r.getPatient().getId()), r, context);
            }
        }
        return records;
    }

    /**
     * POST method for creating an instance of RecordResource
     * @param content representation for the new resource
     * @param request
     * @return an HTTP response with content of the created RecordResource
     */
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    public Response postXml(Record content, @Context HttpServletRequest request) {
        //set the POST author using username
        HttpSession session = request.getSession();
        User author = (User) session.getAttribute("me");
        try {
            content.setAuthor(World.getInstance().getUsers().getByUsername().get(author.getUsername()));
        } catch (NullPointerException e) {
            return Response.status(400).entity("Invalid user").build();
        }
        World.getInstance().getRecords().add(content);
        World.getInstance().getPatients().getById().get(Integer.toString(content.getId())).addRecord(content);
        return Response.created(context.getAbsolutePath()).build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public RecordResource getRecordResource(@PathParam("id") String id) {
        return RecordResource.getInstance(id);
    }
    
}
