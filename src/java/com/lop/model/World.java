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
    private final Tasks tasks;
    private final Records records;

    private World() {
        users = new Users();
        roles = new Roles();
        locations = new Locations();
        patients = new Patients();
        boards = new Boards();
        posts = new Posts();
        tasks = new Tasks();
        records = new Records();

        users.add(new User("huj", "111111", "Hugh Jackman"));
        users.add(new User("ctu", "111111", "Channing Tatum"));
        users.add(new User("batman", "111111", "Christiano"));
        users.add(new User("superman", "111111", "Channing Tatum"));
        users.add(new User("hulk", "111111", "ugly"));
        users.add(new User("vampire", "111111", "blood seeker"));
        
        users.add(new User("iHaveNoBoard", "111111", "nobody"));
        users.add(new User("meNoBoard", "111111", "transparentGuy"));
        
        roles.add(new Role("doctor"));
        roles.add(new Role("nurse"));

        locations.add(new Location("3"));

        patients.add(new Patient("Lawton", 28, users.get("1"), locations.getById().get("1")));
        patients.add(new Patient("Cross", 50, users.get("1"), locations.getById().get("1")));
        patients.add(new Patient("Presence", 75, users.get("2"), locations.getById().get("1")));

        Board b = new Board(1, "Emergency Board");
        boards.add(b);
        boards.add(new Board(2, "Notice"));
        
        // add users to boards
        boards.getById().get("1").addUser(users.getById().get("1"));
        boards.getById().get("1").addUser(users.getById().get("2"));
        boards.getById().get("1").addUser(users.getById().get("3"));
        boards.getById().get("2").addUser(users.getById().get("4"));
        boards.getById().get("2").addUser(users.getById().get("5"));
        boards.getById().get("2").addUser(users.getById().get("6"));
        
        posts.add(new Post(1, users.get("1"), "A crafty eyedoctor needed: The lenses got stuck in his eye."));
        posts.add(new Post(1, users.get("3"), "Emergency at the entrance."));
        posts.add(new Post(2, users.get("2"), "A charismatic psychologist needed: This guy seems to be out of his mind."));
        // add posts to the board
        boards.getById().get("1").addPost(posts.getById().get("1"));
        boards.getById().get("1").addPost(posts.getById().get("2"));
        boards.getById().get("2").addPost(posts.getById().get("3"));
        
        tasks.add(new Task("Take out the lense", "Lense is in the right eye", users.getById().get("1"), patients.getById().get("1")));
        tasks.add(new Task("Calm him down", "He keeps on babble", users.getById().get("2"), patients.getById().get("2")));
        tasks.getById().get("1").addParticipant(users.getById().get("3"));
        tasks.getById().get("1").addParticipant(users.getById().get("4"));
        // tasks.getById().get("1").addParticipant(users.getById().get("5"));
        // tasks.getById().get("1").addParticipant(users.getById().get("6"));
        
        records.add(new Record("Initial examination for Lawton", "MRI scan", users.get("1"), patients.getById().get("1"), "MRIScan.jpg"));
        records.add(new Record("2nd examination for Lawton", "X-ray scan", users.get("2"), patients.getById().get("1"), "X-rayScan"));
        records.add(new Record("3rd examination for Lawton", "Blood test", users.get("3"), patients.getById().get("1")));
        records.add(new Record("Initial examination for Cross", "Psycology test", users.get("4"), patients.getById().get("2")));
        
        patients.getById().get("1").addRecord(records.getById().get("1"));
        patients.getById().get("1").addRecord(records.getById().get("2"));
        patients.getById().get("1").addRecord(records.getById().get("3"));
        patients.getById().get("2").addRecord(records.getById().get("4"));
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

    public Tasks getTasks() {
        return tasks;
    }

    public Records getRecords() {
        return records;
    }
    
    private void populate() {
        
    }

}
