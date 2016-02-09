/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import javax.inject.Singleton;

/**
 *
 * @author Anh
 */
@Singleton
public class World {

    private static final World instance = new World();
    private final Users users;
    private final Roles roles;
    private final Locations locations;
    private final Patients patients;
    private final Boards boards;
    private final Posts posts;

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
        
        users.add(new User("huj", "111111", "Hugh Jackman"));
        users.add(new User("ctu", "111111", "Channing Tatum"));
        users.add(new User("sup", "222222", "Superman"));
        users.add(new User("bat", "222222", "Batman"));
        users.add(new User("hul", "222222", "The Hulk"));

        locations.add(new Location("3"));

        patients.add(new Patient("Lawton", 28, users.get("1"), locations.getById().get("1")));
        patients.add(new Patient("Cross", 50, users.get("1"), locations.getById().get("1")));
        patients.add(new Patient("Presence", 75, users.get("2"), locations.getById().get("1")));

        Board b = new Board(1, "Emergency Board");
        boards.add(b);
        boards.add(new Board(2, "Notice"));
        
        Post post1 = new Post(1, users.get("1"), "A crafty eyedoctor needed: The lenses got stuck in his eye");
        Post post2 = new Post(2, users.get("2"), "A charismatic psychologist needed: This guy seems to be out of his mind.");
        posts.add(post1);
        posts.add(post2);

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

    private void populate() {
        
    }

}
