/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
@XmlRootElement
public class Post implements Serializable, Comparable<Post> {

    private int id;
    private User author;
    private String title;
    private String content;
    private HashSet<Task> tasks;
    private ArrayList<Post> comments;
    private Date createdAt;
    private Post repliedTo;
    private HashSet<Link> links = new HashSet<>();

    public Post() {
    }

    public Post(int id, User author, String title, String content) {
        this(id, author, title, content, null, null, new Date(), null);
    }
    
    public Post(int id, User author, String title, String content, Post repliedTo) {
        this(id, author, title, content, null, null, new Date(), repliedTo);
    }

    public Post(int id, User author, String title, String content, HashSet<Task> tasks, ArrayList<Post> comments, Date createdAt, Post repliedTo) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.tasks = tasks;
        this.comments = comments;
        this.createdAt = createdAt;
        this.repliedTo = repliedTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HashSet<Task> getTasks() {
        return tasks;
    }

    public void setTasks(HashSet<Task> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<Post> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Post> comments) {
        this.comments = comments;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Post getRepliedTo() {
        return repliedTo;
    }

    public void setRepliedTo(Post repliedTo) {
        this.repliedTo = repliedTo;
    }

    public HashSet<Link> getLinks() {
        return links;
    }

    public void setLinks(HashSet<Link> links) {
        this.links = links;
    }
    
    public Post addLink(String url, String rel) {
        Link link = new Link();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
        return this;
    }

    @Override
    public int compareTo(Post o) {
        return createdAt.compareTo(o.createdAt);
    }
}
