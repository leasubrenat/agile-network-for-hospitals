/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trand;

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
        resources.add(com.trand.resources.CatResource.class);
        resources.add(com.trand.resources.CatsResource.class);
        resources.add(com.trand.resources.DogResource.class);
        resources.add(com.trand.resources.DogsResource.class);
        resources.add(com.trand.resources.LocationResource.class);
        resources.add(com.trand.resources.LocationsResource.class);
        resources.add(com.trand.resources.TaskResource.class);
        resources.add(com.trand.resources.TasksResource.class);
        resources.add(com.trand.resources.UserResource.class);
        resources.add(com.trand.resources.UsersResource.class);
    }
    
}
