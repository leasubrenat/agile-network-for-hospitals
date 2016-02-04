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
public class Roles extends ModelCollection<Role> implements Serializable {
    
    public Roles() {
        count = new AtomicInteger();
        byId = new ConcurrentHashMap<>();
    }
//    
//    @Override
//    public void add(Role obj) {
//        obj.setId(count.incrementAndGet());
//        byId.put(Integer.toString(obj.getId()), obj);
//    }
//    
//    public Role get(String key) {
//        return byId.get(key);
//    }
//    
//    public Role get(String key, String method) {
//        return byId.get(key);
//    }
//    
    @XmlElement
    @Override
    public ConcurrentHashMap<String, Role> getById() {
        return byId;
    }
}
