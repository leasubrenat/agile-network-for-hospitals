/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import com.lop.api.BoardsResource;
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

    public static Post addLinks(Post p, @Context UriInfo uriInfo) {
        return p.addLink(getUriForSelf(p, uriInfo), "self");
    }

    public static Board addLinks(Board b, @Context UriInfo uriInfo) {
        return b.addLink(getUriForSelf(b, uriInfo), "self");
    }

    public static User addLinks(User user, @Context UriInfo uriInfo) {
        return user.addLink(getUriForSelf(user, uriInfo), "self");
    }

    public static String getUriForSelf(Post board, @Context UriInfo uriInfo) {
        String uri = uriInfo.getBaseUriBuilder()
                .path(BoardsResource.class)
                .path(Long.toString(board.getId()))
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
