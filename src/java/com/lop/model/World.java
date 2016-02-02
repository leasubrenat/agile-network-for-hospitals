/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import com.lop.Dog;
import com.lop.Dogs;
import javax.inject.Singleton;

/**
 *
 * @author Anh
 */
@Singleton
public class World {
    private static World instance = new World();
    private Users users;
    private ModelCollection<Role> roles;
    private ModelCollection<Location> locations;
    private Dogs dogs;
    
    private World() {
        users = new Users();
        users.add(new User("huj", "Hugh Jackman"));
        users.add(new User("ctu", "Channing Tatum"));
        
        roles = new ModelCollection<>();
        roles.add(new Role("doctor"));
        roles.add(new Role("nurse"));
        
        locations = new ModelCollection<>();
        
        dogs = new Dogs();
    }
    
    public static World getInstance() {
        return World.instance;
    }

    public Users getUsers() {
        return users;
    }

    public ModelCollection<Role> getRoles() {
        return roles;
    }
    
    public Dogs getDogs() {
        return dogs;
    }
    
    private void populate() {
        
        dogs.add(new Dog("Hunter", "german shepherd"));
        dogs.add(new Dog("Pope", "terrier"));
        dogs.add(new Dog("Witch", "some breed 1"));
        dogs.add(new Dog("Hunter", "some breed 2"));
    }
    
}
