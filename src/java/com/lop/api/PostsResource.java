/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.api;

import com.lop.model.Board;
import com.lop.model.Link;
import com.lop.model.Post;
import com.lop.model.User;
import com.lop.model.World;
import java.net.URI;
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
@Path("/posts")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class PostsResource {

    @Context
    private UriInfo uriInfo;

    /**
     * Creates a new instance of PostsResource
     */
    public PostsResource() {
    }
    
    public PostsResource(@Context UriInfo uriInfo) {
        this.uriInfo = uriInfo;
    }

    /**
     * Retrieves representation of an instance of com.lop.api.PostsResource
     * @return an instance of com.lop.model.Posts
     */
    @GET
    @Produces("application/xml")
    public List<Post> getXml(@PathParam("boardId") String boardId) {
        Board board = World.getInstance().getBoards().getById().get(boardId);
        List<Post> posts = board.getPosts();
        for (Post p : posts) {
            Link.addLinks(boardId, p, uriInfo);
        }
        return posts;
    }

    /**
     * POST method for creating an instance of PostResource
     * @param content representation for the new resource
     * @param boardId
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    public Response postXml(Post content, @PathParam("id") String boardId,  @Context HttpServletRequest request) {
        //set the POST author using username
        HttpSession session = request.getSession();
        User author = (User) session.getAttribute("me");
        try {
            content.setAuthor(World.getInstance().getUsers().getByUsername().get(author.getName()));
        } catch (NullPointerException e) {
            return Response.status(400).entity("Invalid user").build();
        }
        Board board;
        try {
            board = World.getInstance().getBoards().getById().get(boardId);
        } catch (Exception e){
            return Response.status(400).entity("No such a board").build();
        }
        World.getInstance().getPosts().add(content);
        board.addPost(content);
        URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(content.getId())).build();
        return Response.created(uri)
                .entity(content)
                .build();
    }
    
    /**
     * Sub-resource locator method for {id}
     */
    @GET
    @Path("{postId}")
    public Response getPostResource(@PathParam("boardId") String boardId, @PathParam("postId") String postId) {
        Post post = Link.addLinks(boardId, World.getInstance().getPosts().get(postId), uriInfo);      
        return Response.ok(Link.getUriForSelf(boardId, post, uriInfo))
                .entity(post)
                .build();
    }
    
}
