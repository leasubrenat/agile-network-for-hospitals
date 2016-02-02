/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop;

import java.util.HashMap;

/**
 *
 * @author Anh
 */
public class Dogs {
    private HashMap<Integer, Dog> byId;
    private HashMap<String, Dog> byName;
    private HashMap<String, Dog> byBreed;
    
    public Dogs() {
        byId = new HashMap<>();
        byName = new HashMap<>();
        byBreed = new HashMap<>();
    }
    
    public Dog add(Dog d) {
        byId.put(d.getId(), d);
        byName.put(d.getName(), d);
        byBreed.put(d.getBreed(), d);
        return d;
    }
    
    public Dog get(Integer key) {
        return byId.get(key);
    }
    
    public Dog get(String key, String method) {
        switch (method) {
            case "name":
                return byName.get(key);
            case "breed":
                return byBreed.get(key);
            default:
                return byId.get(Integer.parseInt(key));
        }
    }
}
