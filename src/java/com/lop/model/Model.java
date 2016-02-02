/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anh
 */
@XmlRootElement
public class Model implements Serializable {

    protected int id;
    
    public Model() {
    }

    public Model(int id) {
        this.id = id;
    }

    @XmlElement
    public int getId() {
        return id;
    }
    
    void setId(int id) {
        this.id = id;
    }
}
