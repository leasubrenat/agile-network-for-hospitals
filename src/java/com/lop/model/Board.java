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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
@XmlRootElement
public class Board implements Serializable {

    private int id;
    private String name;
    private final ArrayList<Post> posts = new ArrayList<>();
    private final ArrayList<User> users = new ArrayList<>();
    private HashSet<Link> links = new HashSet<>();

    public Board() {
    }

    public Board(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

//    public void setPosts(ArrayList<Post> posts) {
//        this.posts = posts;
//    }

    public HashSet<Link> getLinks() {
        return links;
    }

    public void setLinks(HashSet<Link> links) {
        this.links = links;
    }
    
    public void addPost(Post post){
        posts.add(post);
    }
    
    public void addUser(User user){
        users.add(user);
    }
    
    public void removeUser(User user){
        users.add(user);
    }
    
    public Board addLink(String url, String rel) {
        Link link = new Link();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
        return this;
    }
    
}
