/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author Anh
 */
@XmlRootElement
public class User implements Sender, Serializable {

    private int id;
    private String username;
    private String password;
    private String name;
    private Role role;
    private Location office;
    private final ArrayList<Patient> patients = new ArrayList<>();
    private final ArrayList<Notification> notifications = new ArrayList<>();
    private final ArrayList<Task> createdTasks = new ArrayList<>();
    private final ArrayList<Task> joinedTasks = new ArrayList<>();
    private HashSet<Link> links = new HashSet<>();

    public User() {
    }

    public User(String username, String password) {
        this(username, password, null, null, null);
    }
    
    public User(String username, String password, String name) {
        this(username, password, name, null, null);
    }

    public User(String username, String password, String name, Role role) {
        this(username, password, name, role, null);
    }

    public User(String username, String password, String name, Role role, Location office) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
        this.office = office;
    }

    @Override
    public void send(User u, Notification notification) {
//        u.receive(notification);
        notification.send(u);
    }
    
    public void receive(Notification n) {
        notifications.add(n);
    }
    
    // GETTERS AND SETTERS
    
    @XmlElement
    public int getId() {
        return id;
    }

    @XmlElement
    public String getUsername() {
        return username;
    }

//    @XmlTransient
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

//    @XmlElement
    public ArrayList<Patient> getPatients() {
        return patients;
    }
    
//    @XmlElement
//    public ConcurrentHashMap<String, User> getUsers() {
//        return World.getInstance().getUsers().getById();
//    }

//    @XmlElement
//    public Notification getNotification() {
//        return new Notification(null, null, new Post(), true, name);
//    }
    
//    @XmlElement
//    // TODO: Returns only unread notificaitons
    public ArrayList<Notification> getNotifications() {
        return notifications;
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

    public ArrayList<Task> getCreatedTasks() {
        return createdTasks;
    }

    public ArrayList<Task> getJoinedTasks() {
        return joinedTasks;
    }
    
    public void addCreatedTask(Task t){
        if (!joinedTasks.contains(t))
            createdTasks.add(t);
    }
    
    public void addJoinedTask(Task t){
        if (!joinedTasks.contains(t))
            joinedTasks.add(t);
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
    
    // toString
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + '}';
    }
    
}
