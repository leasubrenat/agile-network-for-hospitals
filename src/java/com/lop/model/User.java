/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author Anh
 */
@XmlRootElement
public class User implements Serializable {

    private int id;
    private String username;
    private String password;
    private String name;
    private Role role;
    private Location office;
    private ArrayList<Patient> patients;
    private HashSet<Link> links = new HashSet<>();

    public User() {
    }

    public User(String username, String password, String name) {
        this(username, password, name, null, null);
    }

    public User(String username, String password, String name, Role role, Location office) {
        this.username = username;
        this.password = password;
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

    @XmlTransient // TRANSIENT
    public String getPassword() {
        return password;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setLinks(HashSet<Link> links) {
        this.links = links;
    }

    public HashSet<Link> getLinks() {
        return links;
    }

    public User addLink(String url, String rel) {
        Link link = new Link();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
        return this;
    }
}
