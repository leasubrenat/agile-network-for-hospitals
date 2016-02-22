/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.api;

import static com.lop.api.BoardsResourceTest.instance;
import com.lop.model.Location;
import com.lop.model.Patient;
import com.lop.model.Task;
import com.lop.model.User;
import com.lop.model.World;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
public class TasksResourceTest {
    
    static TasksResource instance;
    static HttpServletRequest request;
    
    public TasksResourceTest() {
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
        TestUriInfo uriinfo = new TestUriInfo("boards");
        instance = new TasksResource();
        instance.setContext(uriinfo);
        request = new TestHttpRequest();
    }
    
    @After
    public void tearDown() {
        request = null;
    }

    /**
     * Test of getXml method, of class TasksResource.
     */
    @Test
    public void testGetXml_when_pathparam_userID_is_null_it_returns_list_of_tasks_from_World() {
        System.out.println("getXml");
        String userId = null;
        List<Task> expResult = new ArrayList<>(World.getInstance().getTasks().getById().values());
        List<Task> result = instance.getXml(userId);
        assertEquals(expResult, result);
    }

    /**
     * Test of postXml method, of class TasksResource.
     */
    @Test
    public void testPostXml_should_give_right_response() {
        System.out.println("postXml");
        TestHttpSession session = (TestHttpSession) request.getSession();
        User poster = new User("Hyvaa", "Paivaa");
        session.setAttribute("me", poster);
        Patient patient = new Patient("Appa", 25, poster, new Location("3"));
        Task content = new Task("Important task", "Really Important", poster, patient);
        URI uri = instance.getContext().getAbsolutePathBuilder()
                .path(Integer.toString(content.getId())).build();
        Response expResult = Response.created(uri)
                .entity(content)
                .build();
        Response result = instance.postXml(content, request);
        assertEquals(expResult.toString(), result.toString());
    }
    
    /**
    * Test of postXml method, of class TasksResource.
    */
    @Test(expected = NullPointerException.class)
    public void testPostXml_throws_null_pointer_exception() {
        System.out.println("postXml");
        TestHttpSession session = (TestHttpSession) request.getSession();
        User poster = new User("Hyvaa", "Paivaa");
        session.setAttribute("me", poster);
        Patient patient = new Patient("Appa", 25, poster, new Location("3"));
        Task content = null;
        URI uri = instance.getContext().getAbsolutePathBuilder()
                .path(Integer.toString(content.getId())).build();
        Response expResult = Response.created(uri)
                .entity(content)
                .build();
        Response result = instance.postXml(content, request);
        assertEquals(expResult.toString(), result.toString());
    }
    
}
