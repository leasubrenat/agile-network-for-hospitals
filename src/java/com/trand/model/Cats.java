/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trand.model;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anh
 */
public class Cats {
    private static Cats instance = new Cats();
    private ArrayList<Cat> cats;

    private Cats() {
        cats = new ArrayList<>();
        readData("Cat.dat");
    }

    public static Cats getInstance() {
        return instance;
    }

    public ArrayList<Cat> getCats() {
        return cats;
    }

    public void setCats(ArrayList<Cat> cats) {
        this.cats = cats;
    }
    
    public void readData(String filename) {
        String subfolder = "java_tmp";
        File file = new File("C:" + File.separator + subfolder + File.separator + filename);
        ObjectInputStream is = null;
        try {
            is = new ObjectInputStream(new FileInputStream(file));
            while (true) {
                cats.add((Cat)is.readObject());
            }
        } catch (EOFException ex) {
            System.out.println("Reading of Cats is finished.");
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Cats.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    Logger.getLogger(Cats.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void writeData(String filename) {
        
    }
}
