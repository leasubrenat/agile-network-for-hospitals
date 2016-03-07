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
 * @author Won Seob Seo
 */
public class Records implements ModelCollectionInterface<Record>, Serializable {
    
    private AtomicInteger count;
    private final ConcurrentHashMap<String, Record> byId;
    private final ConcurrentHashMap<String, Record> byTitle;

    public Records() {
        count = new AtomicInteger();
        byId = new ConcurrentHashMap<>();
        byTitle = new ConcurrentHashMap<>();
    }
    
    @Override
    public void add(Record obj) {
        obj.setId(count.incrementAndGet());
        byId.put(Integer.toString(obj.getId()), obj);
        byTitle.put(obj.getTitle(), obj);
    }

    @Override
    public ConcurrentHashMap<String, Record> getById() {
        return byId;
    }
    
    public ConcurrentHashMap<String, Record> getByName() {
        return byTitle;
    }
}
