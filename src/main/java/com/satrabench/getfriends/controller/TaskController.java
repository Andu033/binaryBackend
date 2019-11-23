package com.satrabench.getfriends.controller;

import com.satrabench.getfriends.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

        private final Task tasks;

        @Autowired
        public Task(Task task) {
            this.tasks = task;
        }

        @GetMapping("/tasks")
        public ResponseEntity<Object> getAll() {
            return tasks.getAll();
        }

        @PostMapping("/tasks/create")
        public ResponseEntity<Object> create(@RequestBody Task task) {
            return tasks.create(task);
        }
}
