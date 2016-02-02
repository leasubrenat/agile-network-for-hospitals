/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import java.util.Date;

/**
 *
 * @author Anh
 */
public class Patient {

    private long id;
    private String name;
    private int age;
    private User mainDoctor;
    private Location room;
    private String description;
    private Date hospitalizedAt;

}
