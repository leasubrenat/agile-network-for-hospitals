/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.api;

import com.lop.model.Board;
import com.lop.model.Link;
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
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
@Path("/boards")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class BoardsResource {

    @Context
    private UriInfo uriInfo;

    /**
     * Creates a new instance of BoardsResource
     */
    public BoardsResource() {
    }

    /**
     * Retrieves representation of an instance of com.lop.api.BoardsResource
     *
     * @return an instance of com.lop.model.Boards
     */
    @GET
    @Produces("application/xml")
    public List<Board> getXml(@Context HttpServletRequest request) {
        HttpSession session = request.getSession();
        User me = (User) session.getAttribute("me");
        if (me == null) return new ArrayList<Board>();
        List<Board> boards = new ArrayList<>(World.getInstance().getBoards().getById().values());
        for (Board b : boards) {
            Link.addLinks(b, uriInfo);
        }
        return boards;
    }

    /**
     * POST method for creating an instance of BoardResource
     *
     * @param content representation for the new board
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    public Response postXml(Board content) {
        World.getInstance().getBoards().add(content);
        URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(content.getId())).build();
        return Response.created(uri)
                .entity(content)
                .build();
    }

    /**
     * Sub-resource GET method for {id}
     */
    @GET
    @Path("{id}")
    public Response getBoardResource(@PathParam("id") String id) {
        Board board = Link.addLinks(World.getInstance().getBoards().get(id), uriInfo);
        return Response.ok(Link.getUriForSelf(board, uriInfo))
                .entity(board)
                .build();
    }

    @Path("/{boardId}/posts")
    public PostsResource getPostsResource() {
        return new PostsResource(uriInfo);
    }
    
    @Path("/{boardId}/users")
    public UsersResource getUsersResource() {
        return new UsersResource(uriInfo);
    }

}
