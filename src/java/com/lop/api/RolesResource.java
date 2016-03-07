package com.lop.api;

import com.lop.model.Role;
import com.lop.model.Roles;
import com.lop.model.World;
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
@Path("/roles")
public class RolesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RolesResource
     */
    public RolesResource() {
    }

    /**
     * Retrieves representation of an instance of com.lop.api.RolesResource
     * @return an instance of com.lop.model.ModelCollection
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Roles getXml() {
        return World.getInstance().getRoles();
    }

    /**
     * POST method for creating an instance of RoleResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response postXml(Role content) {
        World.getInstance().getRoles().add(content);
        return Response.created(context.getAbsolutePath()).build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public RoleResource getRoleResource(@PathParam("id") String id) {
        return RoleResource.getInstance(id);
    }
}
