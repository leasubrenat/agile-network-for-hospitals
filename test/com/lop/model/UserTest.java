/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import java.util.ArrayList;
import java.util.HashSet;
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
public class UserTest {
    
    public UserTest() {
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
     * Test of send method, of class User.
     */
    @Test
    public void testSend() {
        System.out.println("send");
        User u = new User();
        Notification notification = new Notification();
        User instance = new User();
        instance.send(u, notification);
    }

    /**
     * Test of receive method, of class User.
     */
    @Test
    public void testReceive() {
        System.out.println("receive");
        Notification n = new Notification();
        User instance = new User();
        instance.receive(n);
    }

    /**
     * Test of getId method, of class User.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        User instance = new User();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        User instance = new User("huj", "111111", "Hugh Jackman");
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = new User();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        User instance = new User();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRole method, of class User.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        User instance = new User();
        Role expResult = null;
        Role result = instance.getRole();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOffice method, of class User.
     */
    @Test
    public void testGetOffice() {
        System.out.println("getOffice");
        User instance = new User();
        Location expResult = null;
        Location result = instance.getOffice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPatients method, of class User.
     */
    @Test
    public void testGetPatients() {
        System.out.println("getPatients");
        User instance = new User();
        ArrayList<Patient> expResult = null;
        ArrayList<Patient> result = instance.getPatients();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNotifications method, of class User.
     */
    @Test
    public void testGetNotifications() {
        System.out.println("getNotifications");
        User instance = new User();
        ArrayList<Notification> expResult = null;
        ArrayList<Notification> result = instance.getNotifications();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class User.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        User instance = new User();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class User.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        User instance = new User();
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        User instance = new User();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class User.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        User instance = new User();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRole method, of class User.
     */
    @Test
    public void testSetRole() {
        System.out.println("setRole");
        Role role = null;
        User instance = new User();
        instance.setRole(role);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOffice method, of class User.
     */
    @Test
    public void testSetOffice() {
        System.out.println("setOffice");
        Location office = null;
        User instance = new User();
        instance.setOffice(office);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedTasks method, of class User.
     */
    @Test
    public void testGetCreatedTasks() {
        System.out.println("getCreatedTasks");
        User instance = new User();
        ArrayList<Task> expResult = null;
        ArrayList<Task> result = instance.getCreatedTasks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJoinedTasks method, of class User.
     */
    @Test
    public void testGetJoinedTasks() {
        System.out.println("getJoinedTasks");
        User instance = new User();
        ArrayList<Task> expResult = null;
        ArrayList<Task> result = instance.getJoinedTasks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCreatedTask method, of class User.
     */
    @Test
    public void testAddCreatedTask() {
        System.out.println("addCreatedTask");
        Task t = null;
        User instance = new User();
        instance.addCreatedTask(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addJoinedTask method, of class User.
     */
    @Test
    public void testAddJoinedTask() {
        System.out.println("addJoinedTask");
        Task t = null;
        User instance = new User();
        instance.addJoinedTask(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLinks method, of class User.
     */
    @Test
    public void testSetLinks() {
        System.out.println("setLinks");
        HashSet<Link> links = null;
        User instance = new User();
        instance.setLinks(links);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLinks method, of class User.
     */
    @Test
    public void testGetLinks() {
        System.out.println("getLinks");
        User instance = new User();
        HashSet<Link> expResult = null;
        HashSet<Link> result = instance.getLinks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addLink method, of class User.
     */
    @Test
    public void testAddLink() {
        System.out.println("addLink");
        String url = "";
        String rel = "";
        User instance = new User();
        User expResult = null;
        User result = instance.addLink(url, rel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        User instance = new User();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
