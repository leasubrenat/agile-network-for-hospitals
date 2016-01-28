/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trand.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anh
 */
@XmlRootElement 
public class Task {
    
    public static long count;
    private long id;
    private boolean emergencyClass;
    private User poster;
    private List<User> participants;
    private String name;
    private String desc;
    private List<Patient> patient;

    public Task() {
        count += 1;
    }

    public Task(String name) {
        this();
        this.name = name;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isEmergencyClass() {
        return emergencyClass;
    }

    public void setEmergencyClass(boolean emergencyClass) {
        this.emergencyClass = emergencyClass;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Patient> getPatient() {
        return patient;
    }

    public void setPatient(List<Patient> patient) {
        this.patient = patient;
    }
    
    
}

