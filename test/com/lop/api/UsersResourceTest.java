/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.api;

import com.lop.model.User;
import com.lop.model.World;
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

/**
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
public class UsersResourceTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getXml method, of class UsersResource.
     */
    @Test
    public void testGetXml() {
        System.out.println("getXml");
        String boardId = "1";
        UsersResource instance = new UsersResource();
        List<User> expResult = new ArrayList<User>(World.getInstance().getBoards().getById().get(boardId).getUsers());
        List<User> result = instance.getXml(boardId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of postXml method, of class UsersResource.
     */
    @Test
    public void testPostXml() {
        System.out.println("postXml");
        String boardId = "1";
        User content = null;
        UsersResource instance = new UsersResource();
        Response expResult = null;
        Response result = instance.postXml(boardId, content);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserResource method, of class UsersResource.
     */
    @Test
    public void testGetUserResource() {
        System.out.println("getUserResource");
        String id = "";
        UsersResource instance = new UsersResource();
        UserResource expResult = null;
        UserResource result = instance.getUserResource(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class UsersResource.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        HttpServletRequest request = null;
        User u = null;
        UsersResource instance = new UsersResource();
        Response expResult = null;
        Response result = instance.login(request, u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logout method, of class UsersResource.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        HttpServletRequest request = null;
        UsersResource instance = new UsersResource();
        Response expResult = null;
        Response result = instance.logout(request);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sessionCheck method, of class UsersResource.
     */
    @Test
    public void testSessionCheck() {
        System.out.println("sessionCheck");
        HttpServletRequest request = null;
        UsersResource instance = new UsersResource();
        Response expResult = null;
        Response result = instance.sessionCheck(request);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTasksResource method, of class UsersResource.
     */
    @Test
    public void testGetTasksResource() {
        System.out.println("getTasksResource");
        UsersResource instance = new UsersResource();
        TasksResource expResult = null;
        TasksResource result = instance.getTasksResource();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
