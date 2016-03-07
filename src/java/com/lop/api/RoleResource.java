package com.lop.api;

import com.lop.model.Role;
import com.lop.model.World;
import javax.ws.rs.BadRequestException;
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
public class RoleResource {

    private String id;

    /**
     * Creates a new instance of RoleResource
     */
    private RoleResource(String id) {
        this.id = id;
    }

    /**
     * Get instance of the RoleResource
     */
    public static RoleResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of RoleResource class.
        return new RoleResource(id);
    }

    /**
     * Retrieves representation of an instance of com.lop.api.RoleResource
     * @return an instance of com.lop.model.Role
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Role getXml() {
        return World.getInstance().getRoles().get(id);
    }

    /**
     * PUT method for updating or creating an instance of RoleResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(Role content) {
        World.getInstance().getRoles().getById().replace(id, content);
    }

    /**
     * DELETE method for resource RoleResource
     */
    @DELETE
    public void delete() {
        World.getInstance().getRoles().getById().remove(id);
    }
}
