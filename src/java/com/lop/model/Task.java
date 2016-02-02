/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import java.util.ArrayList;

/**
 *
 * @author Anh
 */
public class Task {
    private long id;
    private String name;
    private String description;
    private User poster;
    private ArrayList<User> participants;
    private ArrayList<Patient> patients;
}
