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
    private final Roles roles;
    private final Locations locations;
    private final Patients patients;
    // Test Collection
    private Dogs dogs;
    
    private World() {
        users = new Users();
        roles = new Roles();
        locations = new Locations();
        patients = new Patients();
        
        users.add(new User("huj", "111111","Hugh Jackman"));
        users.add(new User("ctu", "111111", "Channing Tatum"));
        
        roles.add(new Role("doctor"));
        roles.add(new Role("nurse"));
        
        locations.add(new Location("3"));
        
        patients.add(new Patient("Lawton", 28, users.get("1"), locations.getById().get("1")));
        patients.add(new Patient("Cross", 50, users.get("1"), locations.getById().get("1")));
        patients.add(new Patient("Presence", 75, users.get("2"), locations.getById().get("1")));
        
        dogs = new Dogs();
    }
    
    public static World getInstance() {
        return World.instance;
    }

    public Users getUsers() {
        return users;
    }

    public Roles getRoles() {
        return roles;
    }

    public Locations getLocations() {
        return locations;
    }

    public Patients getPatients() {
        return patients;
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
