/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Won Seob Seo
 */
public class Comment implements Serializable, Comparable<Comment>  {
    
    private int id;
    private User author;
    private String content;
    private Date timestamp;
    private ArrayList<Comment> comments;

    @Override
    public int compareTo(Comment o) {
        return timestamp.compareTo(o.timestamp);
    }
    
        
}
