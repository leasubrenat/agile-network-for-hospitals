/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trand;

import java.io.File;
import java.util.HashMap;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anh
 */
@XmlRootElement
public class Dogs {

    private static Dogs instance = new Dogs();
    private HashMap<String, Dog> dogs;

    private Dogs() {
        dogs = new HashMap<>();
        dogs.put("a", new Dog("Willy"));
        dogs.put("b", new Dog("Hunter"));
        dogs.put("c", new Dog("Bull"));
    }
    
    public static Dogs getInstance() {
        return instance;
    }

    @XmlElement
    public HashMap<String, Dog> getDogs() {
        return dogs;
    }

    public void setDogs(HashMap<String, Dog> dogs) {
        this.dogs = dogs;
    }
    
    public void readData(String filename) {
        
    }
    
    public void writeData(String filename) {
        
    }

}
