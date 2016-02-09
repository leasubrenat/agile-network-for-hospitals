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
    private final Boards boards;
    private final Posts posts;
    // Test Collection
    private Dogs dogs;

    private World() {
        users = new Users();
        roles = new Roles();
        locations = new Locations();
        patients = new Patients();
        boards = new Boards();
        posts = new Posts();

        users.add(new User("huj", "111111", "Hugh Jackman"));
        users.add(new User("ctu", "111111", "Channing Tatum"));
        users.add(new User("batman", "111111", "Christiano"));
        users.add(new User("superman", "111111", "Channing Tatum"));
        users.add(new User("hulk", "111111", "ugly"));
        users.add(new User("vampire", "111111", "blood seeker"));
        
        roles.add(new Role("doctor"));
        roles.add(new Role("nurse"));

        locations.add(new Location("3"));

        patients.add(new Patient("Lawton", 28, users.get("1"), locations.getById().get("1")));
        patients.add(new Patient("Cross", 50, users.get("1"), locations.getById().get("1")));
        patients.add(new Patient("Presence", 75, users.get("2"), locations.getById().get("1")));

        boards.add(new Board(1, "Emergency Board"));
        boards.add(new Board(2, "Notice"));
        boards.getById().get("1").addUser(users.getById().get("1"));
        boards.getById().get("1").addUser(users.getById().get("2"));
        boards.getById().get("1").addUser(users.getById().get("3"));
        boards.getById().get("2").addUser(users.getById().get("4"));
        boards.getById().get("2").addUser(users.getById().get("5"));
        boards.getById().get("2").addUser(users.getById().get("6"));
        
        posts.add(new Post(1, users.get("1"), "A crafty eyedoctor needed: The lenses got stuck in his eye"));
        posts.add(new Post(2, users.get("2"), "A charismatic psychologist needed: This guy seems to be out of his mind."));

        boards.getById().get("1").addPost(posts.getById().get("1"));
        boards.getById().get("2").addPost(posts.getById().get("2"));
        
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

    public Boards getBoards() {
        return boards;
    }

    public Posts getPosts() {
        return posts;
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
