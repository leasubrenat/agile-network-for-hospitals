/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

/**
 *
 * @author Anh
 */
public class Notification {
    private int id;
    private Board from;
    private User to;
    private Post post;
    private boolean read;
    private String title;

    public Notification() {
    }

    public Notification(Board from, User to, Post post, boolean read, String title) {
        this.from = from;
        this.to = to;
        this.post = post;
        this.read = read;
        this.title = title;
    }

    // GETTERS AND SETTERS
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Board getFrom() {
        return from;
    }

    public void setFrom(Board from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
