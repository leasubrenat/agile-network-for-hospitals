/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.api;

import com.lop.model.User;
import com.lop.model.World;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static sun.invoke.util.ValueConversions.ignore;

/**
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
public class UsersResourceTest {
    
    static UsersResource instance;
    static HttpServletRequest request;
    
    
    public UsersResourceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        TestUriInfo uriinfo = new TestUriInfo("users");
        instance = new UsersResource(uriinfo);
        request = new TestHttpRequest();
    }
    
    @After
    public void tearDown() {
        request = null;
    }

    /**
     * Test of getXml method, of class UsersResource.
     */
    @Test
    public void testGetXml_should_return_list_of_users_from_world() {
        System.out.println("getXml");
        String boardId = "1";
        
        List<User> expResult = new ArrayList<User>(World.getInstance().getBoards().getById().get(boardId).getUsers());
        List<User> result = instance.getXml(boardId);
        assertEquals(expResult, result);
    }

    /**
     * Test of postXml method, of class UsersResource.
     */
    @Test
    public void testPostXml_should_return_successful_response() {
        System.out.println("postXml");
        String boardId = null;
        User content = new User("testUser", "testPassword");
        Response result = instance.postXml(boardId, content);
        System.out.println(result);
        URI uri = instance.getUriInfo().getAbsolutePathBuilder().path(Integer.toString(9)).build();
        System.out.println(uri);
        Response expResult = Response.created(uri)
                    .entity(content)
                    .build();
        System.out.println(expResult);
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of login method, of class UsersResource.
     */
    @Test
    public void testLogin_should_success() {
        System.out.println("login");
        User u = World.getInstance().getUsers().getById().get("1");
        
        Response result = instance.login(request, u);
        URI uri = instance.getUriInfo().getAbsolutePathBuilder()
                    .path(UsersResource.class)
                    .path(Integer.toString(u.getId()))
                    .build();
        Response expResult = Response.ok(uri)
                    .entity(u)
                    .build();
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of logout method, of class UsersResource.
     */
    @Test
    public void testLogout_returns_badrequest_for_trying_to_logout_without_login() {
        System.out.println("logout");
        Response expResult = Response.status(400).entity("<response>You are not logged in</response>").build();
        Response result = instance.logout(request);
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of sessionCheck method, of class UsersResource.
     */
    @Test
    public void testSessionCheck_returns_badrequest_with_Not_logged_in_message() {
        System.out.println("sessionCheck");
        Response expResult = Response.status(400).entity("<response>Not logged in</response>").build();
        Response result = instance.sessionCheck(request);
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult.toString(), result.toString());
    }
    
}
