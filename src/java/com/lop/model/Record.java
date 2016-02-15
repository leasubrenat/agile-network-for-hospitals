/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
@XmlRootElement
public class Record implements Serializable{
    
    private int id;
    private String title;
    private String record;
    private User author;
    private Patient patient;
    private List<String> medicalImagePath = new ArrayList<>();
    private HashSet<Link> links = new HashSet<>();
    private Date createdAt;
    
    public Record() {
        createdAt = new Date();
    }

    public Record(String record, User author, Patient patient) {
        this(null, record, author, patient);
    }
    
    public Record(String title, String record, User author, Patient patient) {
        this.title = title;
        this.record = record;
        this.author = author;
        this.patient = patient;
        createdAt = new Date();
    }
    
    public Record(String title, String record, User author, Patient patient, String medicalImage) {
        this.title = title;
        this.record = record;
        this.author = author;
        this.patient = patient;
        medicalImagePath.add(medicalImage);
        createdAt = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<String> getMedicalImagePath() {
        return medicalImagePath;
    }

    public void setMedicalImagePath(List<String> medicalImagePath) {
        this.medicalImagePath = medicalImagePath;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public Record addLink(String url, String rel) {
        Link link = new Link();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
        return this;
    }
}