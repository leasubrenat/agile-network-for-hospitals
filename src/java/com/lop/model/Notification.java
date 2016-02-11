/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anh
 */
@XmlRootElement
public class Notification implements Serializable {
    private int id;
    private User sender;
    private User recipient;
    private Post post;
    private boolean unread;
    private String title;

    public Notification() {
    }

    public Notification(User sender, Post post, String title) {
        this(sender, null, post, true, title);
    }

    public Notification(User from, User to, Post post, boolean read, String title) {
        this.sender = from;
        this.recipient = to;
        this.post = post;
        this.unread = read;
        this.title = title;
    }
    
    public void send(User u) {
        recipient = u;
        u.receive(this);
    }

    // GETTERS AND SETTERS
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    @XmlElement
    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public boolean isUnread() {
        return unread;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
