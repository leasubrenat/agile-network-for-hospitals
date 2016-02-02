/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Anh
 */
public class AutoId {

    public static int create(AtomicInteger i) {
        return i.incrementAndGet();
    }
}
