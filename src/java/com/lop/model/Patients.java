/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anh
 */
@XmlRootElement
public class Patients implements ModelCollectionInterface<Patient>, Serializable {
    
    private AtomicInteger count;
    private final ConcurrentHashMap<String, Patient> byId;

    public Patients() {
        count = new AtomicInteger();
        byId = new ConcurrentHashMap<>();
    }

    @Override
    public void add(Patient obj) {
        obj.setId(count.incrementAndGet());
        byId.put(Integer.toString(obj.getId()), obj);
    }

    @XmlElement
    @Override
    public ConcurrentHashMap<String, Patient> getById() {
        return byId;
    }
    
}
