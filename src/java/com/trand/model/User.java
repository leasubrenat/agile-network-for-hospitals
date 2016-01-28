/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trand.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anh
 */
@XmlRootElement
public class User implements Serializable {

    private long id;
    private String username;
    private String name;
    private Role role;
    private Location office;
    private ArrayList<Patient> patients;

    public User() {
    }
    
    public User(String username, String name, Role role, Location office) {
        this.username = username;
        this.name = name;
        this.role = role;
        this.office = office;
    }
    
    @XmlElement
    public long getId() {
        return id;
    }
    @XmlElement
    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

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
