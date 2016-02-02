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
    private final ConcurrentHashMap<Integer, User> byId;
    private final ConcurrentHashMap<String, User> byUsername;
    
    public Users() {
        byId = new ConcurrentHashMap<>();
        byUsername = new ConcurrentHashMap<>();
    }
    
    public User add(User o) {
        return byId.put(o.getId(), o);
    }
    
    public User get(Integer key) {
        return byId.get(key);
    }
    
    public User get(String key, String method) {
        return byId.get(key);
    }
}
