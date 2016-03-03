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
public class ModelCollection<M extends Model> implements Serializable {

    protected AtomicInteger count;
    protected Class<M> model;
    protected ConcurrentHashMap<String, M> byId;
    
    public ModelCollection() {
        count = new AtomicInteger();
        byId = new ConcurrentHashMap<>();
    }
    
    public void add(M obj) {
        obj.setId(count.incrementAndGet());
        byId.put(Integer.toString(obj.getId()), obj);
    }
    
    public M get(String key) {
        return byId.get(key);
    }
    
    public ConcurrentHashMap<String, M> getById() {
        return byId;
    }
    
}
