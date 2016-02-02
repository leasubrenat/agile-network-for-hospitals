/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anh
 */
@XmlRootElement
public class Dog {
    public static int count;
    private int id;
    private String name;
    private String breed;

    public Dog() {
    }

    public Dog(String name, String breed) {
        this.id = count;
        count++;
        this.name = name;
        this.breed = breed;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @XmlElement
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Dog{" + "id=" + id + ", name=" + name + ", breed=" + breed + '}';
    }
    
}
