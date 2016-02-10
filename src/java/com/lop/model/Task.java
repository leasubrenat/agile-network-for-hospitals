/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anh
 */
@XmlRootElement
public class Task implements Serializable {

    private int id;
    private String name;
    private String description;
    private User poster;
    private Status status;
    private ArrayList<User> participants = new ArrayList<>();
    private Patient patient;
    private HashSet<Link> links = new HashSet<>();

    public enum Status {
        ACHIEVED, FAILED, UNDER_PROCESS
    }

    public Task() {
        this.status = Status.UNDER_PROCESS;
    }

    public Task(String name, String description, User poster, Patient patient) {
        this(0, name, description, poster, patient);
    }

    public Task(int id, String name, String description, User poster, Patient patient) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.poster = poster;
        this.patient = patient;
        status = Status.UNDER_PROCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public void addParticipant(User p) {
        participants.add(p);
    }

    public ArrayList<User> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<User> participants) {
        this.participants = participants;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public HashSet<Link> getLinks() {
        return links;
    }

    public void setLinks(HashSet<Link> links) {
        this.links = links;
    }

    public Task addLink(String url, String rel) {
        Link link = new Link();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
        return this;
    }

}
