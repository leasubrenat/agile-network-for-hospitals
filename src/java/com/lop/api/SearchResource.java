/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.api;

import com.lop.model.Link;
import com.lop.model.User;
import com.lop.model.World;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 * REST Web Service
 *
 * @author Anh
 */
@Path("/search")
public class SearchResource {

    @Context
    private UriInfo uriInfo;

    /**
     * Creates a new instance of SearchResource
     */
    public SearchResource() {
    }

    /**
     * Retrieves representation of an instance of com.lop.api.SearchResource
     * @param query (part of ) user name to search
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<User> getXml(@QueryParam("query") String query) {
        List<User> results = new ArrayList<>();
        try {
            if (query.length() == 0) return results;
            Pattern p = Pattern.compile(query);
            for (Entry<String, User> e : World.getInstance().getUsers().getById().entrySet()) {
                User u = e.getValue();
//                Matcher m = p.matcher(u.getName());
//                System.out.println(u.getName());
                if (p.matcher(u.getName()).lookingAt()) {
                    results.add(u);
                    Link.addLinks(u, uriInfo);
                }
            }
        } catch (NullPointerException e) {

        } finally {
            return results;
        }
    }

    /**
     * PUT method for updating or creating an instance of SearchResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
