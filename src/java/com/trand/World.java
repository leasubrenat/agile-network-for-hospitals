/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trand;

/**
 *
 * @author Anh
 */
public class World {
    private static World instance = new World();
    
    private World() {
    }
    
    public static World getInstance() {
        return World.instance;
    }
    
    
}
