/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trand.data;

import com.trand.model.Patient;
import com.trand.model.Task;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
public class DatabaseClass {

    private static Map<Long, Task> tasks = new HashMap<>();
    private static Map<String, Patient> patients = new HashMap<>();
    private static Map<Long, Task> locations = new HashMap<>();
    

    public static Map<Long, Task> getTasks() {
        return tasks;
    }

    public static Map<String, Patient> getPatients() {
        return patients;
    }
}
