/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.model;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Anh
 */
public interface ModelCollectionInterface<M> {
    void add(M obj);
    ConcurrentHashMap<String, M> getById();
}
