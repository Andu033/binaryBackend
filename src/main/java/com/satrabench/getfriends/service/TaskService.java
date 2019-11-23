package com.satrabench.getfriends.service;

import com.satrabench.getfriends.model.Task;
import com.satrabench.getfriends.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public ResponseEntity<Object> getAll(){
        List<Task> tasks = taskRepository.findAll();
        return new ResponseEntity<Object>(tasks, HttpStatus.OK);
    }

    public ResponseEntity<Object> create(Task task) {
        Task t = taskRepository.save(task);
        return new ResponseEntity<Object>(t, HttpStatus.OK);
    }
}
