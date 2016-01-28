/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trand.resources;

import com.trand.model.Task;
import com.trand.service.TaskService;
import java.net.URI;
import java.util.List;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Won Seob Seo <Wons at Metropolia UAS>
 */

@Path("/tasks")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class TaskResource {

        private TaskService taskService = new TaskService();
        
	@GET
	public List<Task> getTasks() {
		return taskService.getAllTasks();
	}

	@POST
	public Task addTask(Task task) {
		
		Task newTask = taskService.addTask(task);
		String newId = String.valueOf(newTask.getId());
		return newTask;
	}
	
	@PUT
	@Path("/{taskId}")
	public Task updateTask(@PathParam("taskId") long id, Task task) {
		task.setId(id);
		return taskService.updateTask(task);
	}
	
	@DELETE
	@Path("/{taskId}")
	public void deleteTask(@PathParam("taskId") long id) {
		taskService.removeTask(id);
	}
	
	
	@GET
	@Path("/{taskId}")
	public Task getTask(@PathParam("taskId") long id) {
		return taskService.getTask(id);
	}
}
