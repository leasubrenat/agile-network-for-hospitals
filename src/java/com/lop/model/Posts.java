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
public class Posts implements ModelCollectionInterface<Post>, Serializable {

    private AtomicInteger count;
    private final ConcurrentHashMap<String, Post> byId;

    public Posts() {
        count = new AtomicInteger();
        byId = new ConcurrentHashMap<>();
    }
    
    public Post get(String key) {
        return byId.get(key);
    }
    
    public Post get(String key, String method) throws NumberFormatException {
        return byId.get(key);
    }
    
    @Override
    public void add(Post obj) {
        obj.setId(count.incrementAndGet());
        byId.put(Integer.toString(obj.getId()), obj);
    }

    @Override
    public ConcurrentHashMap<String, Post> getById() {
        return byId;
    }
    
}
