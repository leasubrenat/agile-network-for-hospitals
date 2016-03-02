/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Anh
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.lop.api.BoardsResource.class);
        resources.add(com.lop.api.LocationResource.class);
        resources.add(com.lop.api.LocationsResource.class);
        resources.add(com.lop.api.NotificationResource.class);
        resources.add(com.lop.api.NotificationsResource.class);
        resources.add(com.lop.api.PatientResource.class);
        resources.add(com.lop.api.PatientsResource.class);
        resources.add(com.lop.api.PostResource.class);
        resources.add(com.lop.api.PostsResource.class);
        resources.add(com.lop.api.RecordResource.class);
        resources.add(com.lop.api.RecordsResource.class);
        resources.add(com.lop.api.RoleResource.class);
        resources.add(com.lop.api.RolesResource.class);
        resources.add(com.lop.api.SearchResource.class);
        resources.add(com.lop.api.TasksResource.class);
        resources.add(com.lop.api.UsersResource.class);
    }
    
}
