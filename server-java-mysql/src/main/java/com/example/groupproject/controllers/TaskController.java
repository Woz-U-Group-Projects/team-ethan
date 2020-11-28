package com.example.groupproject.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.groupproject.models.Task;
import com.example.groupproject.models.TaskRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000/tasks")
@RequestMapping("/tasks")
public class TaskController {
	
	@ModelAttribute
	public void setResponseHeader(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
	}

  @Autowired
  TaskRepository taskRepository;
  @GetMapping()
  public List<Task> getTasks() {
    return taskRepository.findAll();
  }
  
  @GetMapping("/{id}")
  public Task getTask(@PathVariable Long id) {
	  Task foundTask = taskRepository.findById(id).orElse(null);
	    if (foundTask != null) {
	      return foundTask;
	    }
	    return null;
	  }

  @PostMapping()
  public Task addTask(@RequestBody Task task) {
    return taskRepository.save(task);
  }
  
  @DeleteMapping("/{id}")
  public void deleteTask(@PathVariable Long id) {
    taskRepository.deleteById(id);
  }

  @PutMapping("/{id}")
  public Task updateProject(@PathVariable Long id, @RequestBody Task task) {
    Task foundTask = taskRepository.findById(id).orElse(null);
    if (foundTask != null) {
    	foundTask.setName(task.getName());
    	foundTask.setComplete(task.getComplete());
      taskRepository.save(foundTask);
      return foundTask;
    }
    return null;
  }

}