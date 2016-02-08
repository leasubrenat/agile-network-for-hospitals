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
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
public class Boards implements ModelCollectionInterface<Board>, Serializable {

    private AtomicInteger count;
    private final ConcurrentHashMap<String, Board> byId;
    private final ConcurrentHashMap<String, Board> byName;
    
    public Boards() {
        count = new AtomicInteger();
        byId = new ConcurrentHashMap<>();
        byName = new ConcurrentHashMap<>();
    }
    
    @Override
    public void add(Board obj) {
        obj.setId(count.incrementAndGet());
        byId.put(Integer.toString(obj.getId()), obj);
        byName.put(obj.getName(), obj);
    }

    @Override
    public ConcurrentHashMap<String, Board> getById() {
        return byId;
    }
}
