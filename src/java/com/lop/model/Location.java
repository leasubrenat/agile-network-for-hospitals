/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Anh
 */
public class Location extends Model implements Serializable {

    private String number;
    private ArrayList<User> users;
    private ArrayList<Patient> patients;

    public Location() {
    }

    public Location(String number, ArrayList<User> users) {
        this.number = number;
        this.users = users;
        this.patients = new ArrayList<>();
    }

    public String getNumber() {
        return number;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }
    
}
