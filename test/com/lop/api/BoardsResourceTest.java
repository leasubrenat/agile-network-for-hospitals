/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.api;

import static com.lop.api.UsersResourceTest.instance;
import static com.lop.api.UsersResourceTest.request;
import com.lop.model.Board;
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
public class BoardsResourceTest {
    
    static BoardsResource instance;
    static HttpServletRequest request;

    public BoardsResourceTest() {
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
        instance = new BoardsResource();
        instance.setUriInfo(uriinfo);
        request = new TestHttpRequest();
    }

    @After
    public void tearDown() {
        request = null;
    }

    /**
     * Test of getXml method, of class BoardsResource.
     */
    @Test
    public void testGetXml_should_return_list_of_boards_in_World_class() {
        System.out.println("getXml");
        List<Board> expResult = new ArrayList<>(World.getInstance().getBoards().getById().values());
        List<Board> result = instance.getXml();
        assertEquals(expResult, result);
    }

    /**
     * Test of postXml method, of class BoardsResource.
     */
    @Test
    public void testPostXml_should_return_successful_response() {
        System.out.println("postXml");
        Board content = new Board(3, "Nurses Board");
        URI uri = instance.getUriInfo().getAbsolutePathBuilder().path(Integer.toString(content.getId())).build();
        Response expResult = Response.created(uri)
                .entity(content)
                .build();
        Response result = instance.postXml(content);
        assertEquals(expResult.toString(), result.toString());
    }
    
    @Test(expected = NullPointerException.class)
    public void testPostXml_should_throw_null_pointer_exception() {
        System.out.println("postXml");
        Board content = null;
        URI uri = instance.getUriInfo().getAbsolutePathBuilder().path(Integer.toString(content.getId())).build();
        Response expResult = Response.created(uri)
                .entity(content)
                .build();
        Response result = instance.postXml(content);
        assertEquals(expResult.toString(), result.toString());
    }

}
