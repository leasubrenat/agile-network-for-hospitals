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
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * BoardsResource REST Web Service.
 * The collection resource class of Board.
 * @author Won Seob Seo
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
     * @param request HttpServletRequest for checking session
     * @return List of all the board (if user is not logged in, return new empty array
     */
    @GET
    @Produces("application/xml")
    public List<Board> getXml(@Context HttpServletRequest request) {
        HttpSession session = request.getSession();
        User me = (User) session.getAttribute("me");
        // System.out.println((User) session.getAttribute("me"));
        if (me == null) {
            System.out.println("me null");
            return new ArrayList<Board>();
        }
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
        try {
            Board board = Link.addLinks(World.getInstance().getBoards().get(id), uriInfo);
            return Response.ok(Link.getUriForSelf(board, uriInfo))
                    .entity(board)
                    .build();
        } catch (NullPointerException e) {
            throw new NotFoundException();
        }
    }

    /**
     * @return  posts under this board
     */
    @Path("/{boardId}/posts")
    public PostsResource getPostsResource() {
        return new PostsResource(uriInfo);
    }

    /**
     * @return subscribed users under this board
     */
    @Path("/{boardId}/users")
    public UsersResource getUsersResource() {
        return new UsersResource(uriInfo);
    }

    @POST
    @Path("/{id}/subscribe")
    @Consumes("application/xml")
    public Response addUserToBoard(@PathParam("id") String id, User content) {
        try {
            System.out.println(content);
            Board board = World.getInstance().getBoards().get(id);
            System.out.println(board);
            User user = World.getInstance().getUsers().getByUsername().get(content.getUsername());
            System.out.println(user);
            for (User u : board.getUsers()) {
                if (user.getUsername().equals(u.getUsername())) {
                    return Response.ok("The user has already subscribed to this board.").build();
                }
            }
            board.getUsers().add(user);
            return Response.ok("The user is now subscribed to this board.").build();
        } catch (NullPointerException e) {
            throw new NotFoundException();
        }
    }

}
