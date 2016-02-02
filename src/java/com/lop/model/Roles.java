/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Anh
 */
public class Roles {
    private final ConcurrentHashMap<Integer, Role> byId;
    
    public Roles() {
        byId = new ConcurrentHashMap<>();
    }
    
    public Role add(Role o) {
        return byId.put(o.getId(), o);
    }
    
    public Role get(Integer key) {
        return byId.get(key);
    }
    
    public Role get(String key, String method) {
        return byId.get(key);
    }
}
