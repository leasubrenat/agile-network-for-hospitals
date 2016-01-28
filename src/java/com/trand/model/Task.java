/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trand.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anh
 */
@XmlRootElement
public class Task {
    
    // private static long count;
    private long id;
    private boolean emergencyClass;
    private User poster;
    private List<User> participants;
    private String name;
    private String desc;
    private List<Patient> patient;
}

