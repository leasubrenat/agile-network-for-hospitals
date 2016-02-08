/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
public class Posts implements ModelCollectionInterface<Post>, Serializable {

    @Override
    public void add(Post obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConcurrentHashMap<String, Post> getById() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
