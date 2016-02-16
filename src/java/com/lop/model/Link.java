/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import com.lop.api.BoardsResource;
import com.lop.api.PatientsResource;
import com.lop.api.PostsResource;
import com.lop.api.RecordsResource;
import com.lop.api.TasksResource;
import com.lop.api.UsersResource;
import java.util.Objects;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
public class Link {

    private String link;
    private String rel;
    
    public static Record addLinks(String patientId, Record r, @Context UriInfo uriInfo) {
        return r.addLink(getUriForSelf(patientId, r, uriInfo), "self");
    }
    
    public static Patient addLinks(Patient p ,@Context UriInfo uriInfo) {
        return p.addLink(getUriForSelf(p, uriInfo), "self");
    }
    
    public static Task addLinks(Task t ,@Context UriInfo uriInfo) {
        return t.addLink(getUriForSelf(t, uriInfo), "self");
    }

    public static Task addLinks(String userId, Task t, @Context UriInfo uriInfo) {
        return t.addLink(getUriForSelf(userId, t, uriInfo), "self");
    }
    
    public static Post addLinks(String boardId, Post p, @Context UriInfo uriInfo) {
        return p.addLink(getUriForSelf(boardId, p, uriInfo), "self");
    }

    public static Board addLinks(Board b, @Context UriInfo uriInfo) {
        return b.addLink(getUriForSelf(b, uriInfo), "self");
    }

    public static User addLinks(User user, @Context UriInfo uriInfo) {
        return user.addLink(getUriForSelf(user, uriInfo), "self");
    }
    
    public static String getUriForSelf(String patientId, Record r, @Context UriInfo uriInfo) {
        String uri = uriInfo.getBaseUriBuilder()
                .path(PatientsResource.class) //patientId
                .path(PatientsResource.class, "getRecordsResource") // {id}/posts
                .path(RecordsResource.class) // /
                .path(Long.toString(r.getId())) // post ID
                .resolveTemplate("patientId", patientId)
                .build()
                .toString();
        return uri;
    }
    
    public static String getUriForSelf(Patient p, @Context UriInfo uriInfo) {        
        String uri = uriInfo.getBaseUriBuilder()
                .path(PatientsResource.class) // tasks
                .path(Long.toString(p.getId())) // ID
                .build()
                .toString();
        return uri;
    }
    
    public static String getUriForSelf(Task t ,@Context UriInfo uriInfo) {        
        String uri = uriInfo.getBaseUriBuilder()
                .path(TasksResource.class) // tasks
                .path(Long.toString(t.getId())) // ID
                .build()
                .toString();
        return uri;
    }
    
    public static String getUriForSelf(String userId, Task t, @Context UriInfo uriInfo) {        
        String uri = uriInfo.getBaseUriBuilder()
                .path(UsersResource.class) //users
                .path(UsersResource.class, "getTasksResource") // {UserId}/tasks
                // .path(TasksResource.class) // /
                .path(Long.toString(t.getId())) // task ID
                .resolveTemplate("UserId", userId)
                .build()
                .toString();
        return uri;
    }

    public static String getUriForSelf(String boardId, Post post, @Context UriInfo uriInfo) {   
//        System.out.println(boardId+ post+ uriInfo);
        String uri = uriInfo.getBaseUriBuilder()
                .path(BoardsResource.class) //boards
                .path(BoardsResource.class, "getPostsResource") // {id}/posts
                .path(PostsResource.class) // /
                .path(Long.toString(post.getId())) // post ID
                .resolveTemplate("boardId", boardId)
                .build()
                .toString();
        return uri;
    }

    public static String getUriForSelf(Board board, @Context UriInfo uriInfo) {
        String uri = uriInfo.getBaseUriBuilder()
                .path(BoardsResource.class)
                .path(Long.toString(board.getId()))
                .build()
                .toString();
        return uri;
    }

    public static String getUriForSelf(User user, @Context UriInfo uriInfo) {
        String uri = uriInfo.getBaseUriBuilder()
                .path(UsersResource.class)
                .path(Long.toString(user.getId()))
                .build()
                .toString();
        return uri;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.link);
        hash = 37 * hash + Objects.hashCode(this.rel);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Link other = (Link) obj;
        if (!Objects.equals(this.link, other.link)) {
            return false;
        }
        if (!Objects.equals(this.rel, other.rel)) {
            return false;
        }
        return true;
    }

}
