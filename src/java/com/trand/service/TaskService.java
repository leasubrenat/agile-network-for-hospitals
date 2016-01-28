/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trand.service;

import com.trand.data.DatabaseClass;
import com.trand.model.Task;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */
public class TaskService {
    
	private Map<Long, Task> tasks = DatabaseClass.getTasks();
	
	public TaskService() {
		tasks.put(1L, new Task("Heart Operations"));
		tasks.put(2L, new Task("Blood infusions"));
	}
	
	public List<Task> getAllTasks() {
		return new ArrayList<Task>(tasks.values()); 
	}
	
	public List<Task> getAllTasksPaginated(int start, int size) {
		ArrayList<Task> list = new ArrayList<Task>(tasks.values());
		if (start + size > list.size()) return new ArrayList<Task>();
		return list.subList(start, start + size); 
	}
	
	
	public Task getTask(long id) {
		return tasks.get(id);
	}
	
	public Task addTask(Task task) {
		task.setId(Task.count);
		tasks.put(task.getId(), task);
		return task;
	}
	
	public Task updateTask(Task task) {
		if (task.getId() <= 0) {
			return null;
		}
		tasks.put(task.getId(), task);
		return task;
	}
	
	public Task removeTask(long id) {
		return tasks.remove(id);
	}
}
