/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.api;

import com.lop.model.Board;
import com.lop.model.Link;
import com.lop.model.Patient;
import com.lop.model.Task;
import com.lop.model.Tasks;
import com.lop.model.User;
import com.lop.model.World;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
@Path("/tasks")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class TasksResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TasksResource
     */
    public TasksResource() {
    }

    public TasksResource(@Context UriInfo context) {
        this.context = context;
    }

    /**
     * Retrieves representation of an instance of com.lop.api.TasksResource
     * when /tasks, gets all tasks, when users/{id}/tasks, gets tasks for that user
     * @return an instance of com.lop.model.Tasks
     */
    @GET
    @Produces("application/xml")
    public List<Task> getXml(@PathParam("UserId") String userId, @Context HttpServletRequest request) {
        HttpSession session = request.getSession();
        User me = (User) session.getAttribute("me");
        // System.out.println((User) session.getAttribute("me"));
        if (me == null) {
            System.out.println("me null");
            return new ArrayList<Task>();
        }
        List<Task> tasks;
        // when there is a UserId param show only tasks for the user, show all tasks when no UserId param
        if (userId != null) {
            tasks = new ArrayList<>(World.getInstance().getUsers().getById().get(userId).getJoinedTasks());
            for (Task t : tasks) {
                Link.addLinks(t, context);
            }
        } else {
            tasks = new ArrayList<>(World.getInstance().getTasks().getById().values());
            for (Task t : tasks) {
                Link.addLinks(t, context);
            }
        }
        return tasks;
    }

    /**
     * POST method for creating an instance of TaskResource
     *
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    public Response postXml(Task content, @Context HttpServletRequest request) {
        //set the POST author using username
        HttpSession session = request.getSession();
        /// set user with session "me"
        try {
            content.setPoster((User) session.getAttribute("me"));
        } catch (NullPointerException e) {
            return Response.status(400).entity("Invalid user").build();
        }
        /// set patients
        try {
            content.setPatient(World.getInstance().getPatients().getById().get(Integer.toString(content.getPatient().getId())));
        } catch (NullPointerException e) {
            return Response.status(400).entity("Invalid patient").build();
        }
        
        /// two way association, add this task to the participants
        for (User u : content.getParticipants()){
            u.addJoinedTask(content);
            World.getInstance().getUsers().getById().put(Integer.toString(u.getId()), u);
        }
        World.getInstance().getTasks().add(content);
        //poster.addTask(content);
        URI uri = context.getAbsolutePathBuilder().path(Integer.toString(content.getId())).build();
        return Response.created(uri)
                .entity(content)
                .build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public TaskResource getTaskResource(@PathParam("id") String id) {
        return TaskResource.getInstance(id);
    }
}
