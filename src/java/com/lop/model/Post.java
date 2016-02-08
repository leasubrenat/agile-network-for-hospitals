/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
public class Post implements Serializable {
    
    private static AtomicInteger count = new AtomicInteger();
    private int id;
    private User author;
    private String title;
    private String content;
    private HashSet<Task> tasks;
    private ArrayList<Comment> comments;
}
