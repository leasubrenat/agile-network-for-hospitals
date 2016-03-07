package com.lop.api;

import com.lop.model.Link;
import com.lop.model.Task;
import com.lop.model.User;
import com.lop.model.World;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Won Seob Seo
 */
public class TaskResource {

    private String id;

    /**
     * Creates a new instance of TaskResource
     */
    private TaskResource(String id) {
        this.id = id;
    }

    /**
     * Get instance of the TaskResource
     * @param id
     * @return an instance of the TaskResource
     */
    public static TaskResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of TaskResource class.
        return new TaskResource(id);
    }

    /**
     * Retrieves representation of an instance of com.lop.api.TaskResource
     * @param uriInfo
     * @return an instance of com.lop.model.Task
     */
    @GET
    @Produces("application/xml")
    public Response getXml(@Context UriInfo uriInfo) {
        Task task = Link.addLinks(World.getInstance().getTasks().get(id), uriInfo);
        return Response.ok(Link.getUriForSelf(task, uriInfo))
                .entity(task)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of TaskResource
     * @param content representation for the resource
     * @param uriInfo
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public Response putXml(Task content, @Context UriInfo uriInfo) {
        Task task = World.getInstance().getTasks().getById().get(id);
        for (User u : content.getParticipants()){
            u = World.getInstance().getUsers().get(Integer.toString(u.getId()));
            if (u != null && !task.getParticipants().contains(u)) {
                task.addParticipant(u);
            }
        }
        for (User u : content.getParticipants()){
            u.addJoinedTask(content);
            World.getInstance().getUsers().getById().replace(Integer.toString(u.getId()), u);
        }
        Link.addLinks(World.getInstance().getTasks().get(id), uriInfo);
        return Response.ok(Link.getUriForSelf(World.getInstance().getTasks().get(id), uriInfo))
                .entity(World.getInstance().getTasks().get(id))
                .build();
    }

    /**
     * DELETE method for resource TaskResource
     */
    @DELETE
    public void delete() {
    }
}
