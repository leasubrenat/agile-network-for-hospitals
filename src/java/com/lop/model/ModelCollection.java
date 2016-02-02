/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Anh
 */
public class ModelCollection<M extends Model> implements Serializable {

    protected AtomicInteger count;
    protected Class<M> model;
    protected ConcurrentHashMap<Integer, M> byId;
    
    public ModelCollection() {
        count = new AtomicInteger();
        byId = new ConcurrentHashMap<>();
    }
    
    public M add(M obj) {
        obj.setId(count.incrementAndGet());
        return byId.put(obj.getId(), obj);
    }
    
    public M get(Integer key) {
        return byId.get(key);
    }
    
    public M create() {
        Model obj = new Model();
        obj.id = count.incrementAndGet();
        return (M)obj;
    }

    protected int createId() {
        return count.incrementAndGet();
    }
}
