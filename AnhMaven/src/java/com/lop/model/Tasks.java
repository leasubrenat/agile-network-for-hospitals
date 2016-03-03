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
public class Tasks implements ModelCollectionInterface<Task>, Serializable {

    private AtomicInteger count;
    private final ConcurrentHashMap<String, Task> byId;
    private final ConcurrentHashMap<String, Task> byName;

    public Tasks() {
        count = new AtomicInteger();
        byId = new ConcurrentHashMap<>();
        byName = new ConcurrentHashMap<>();
    }

    public Task get(String key) {
        return byId.get(key);
    }

    public Task get(String key, String method) throws NumberFormatException {
        return byId.get(key);
    }

    @Override
    public void add(Task obj) {
        obj.setId(count.incrementAndGet());
        byId.put(Integer.toString(obj.getId()), obj);
        byName.put(obj.getName(), obj);
    }

    @Override
    public ConcurrentHashMap<String, Task> getById() {
        return byId;
    }

    public ConcurrentHashMap<String, Task> getByName() {
        return byName;
    }
}
