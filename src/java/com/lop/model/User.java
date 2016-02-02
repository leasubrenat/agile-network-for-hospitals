/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anh
 */
@XmlRootElement
public class User implements Serializable {
    private static AtomicInteger count = new AtomicInteger();

    private int id;
    private String username;
    private String name;
    private Role role;
    private Location office;
    private ArrayList<Patient> patients;

    public User() {
    }
    
    public User(String username, String name) {
        this(username, name, null, null);
    }
    
    public User(String username, String name, Role role, Location office) {
        this.id = count.incrementAndGet();
        this.username = username;
        this.name = name;
        this.role = role;
        this.office = office;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    @XmlElement
    public String getUsername() {
        return username;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    @XmlElement
    public Role getRole() {
        return role;
    }

    @XmlElement
    public Location getOffice() {
        return office;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setOffice(Location office) {
        this.office = office;
    }
    
}
