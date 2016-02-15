/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anh
 */
@XmlRootElement
public class Patient extends Model {

    private int id;
    private String name;
    private int age;
    private User mainDoctor;
    private Location room;
    private String description;
    private Date hospitalizedAt;
    private final ArrayList<Record> records = new ArrayList<>();
    private HashSet<Link> links = new HashSet<>();

    public Patient() {
    }

    public Patient(int id) {
        this.id = id;
    }

    public Patient(String name, int age, User mainDoctor, Location room) {
        this.name = name;
        this.age = age;
        this.mainDoctor = mainDoctor;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User getMainDoctor() {
        return mainDoctor;
    }

    public void setMainDoctor(User mainDoctor) {
        this.mainDoctor = mainDoctor;
    }

    public Location getRoom() {
        return room;
    }

    public void setRoom(Location room) {
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getHospitalizedAt() {
        return hospitalizedAt;
    }

    public void setHospitalizedAt(Date hospitalizedAt) {
        this.hospitalizedAt = hospitalizedAt;
    }

    public HashSet<Link> getLinks() {
        return links;
    }

    public void setLinks(HashSet<Link> links) {
        this.links = links;
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public Patient addLink(String url, String rel) {
        Link link = new Link();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
        return this;
    }

}
