/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Anh
 */
public class Users {
    private final ConcurrentHashMap<Integer, User> collection;
    
    public Users() {
        collection = new ConcurrentHashMap<>();
    }
    
    public User add(User o) {
        return collection.put(o.getId(), o);
    }
    
    public User get(Integer key) {
        return collection.get(key);
    }
}
