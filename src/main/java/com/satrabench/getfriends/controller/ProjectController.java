package com.satrabench.getfriends.controller;

import com.satrabench.getfriends.model.User;
import com.satrabench.getfriends.service.ProjectService;
import com.satrabench.getfriends.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    @GetMapping("/project")
    public ResponseEntity<Object> getAll(){
        return projectService.getAll();
    }
    @PostMapping("/project/create")
    public ResponseEntity<Object> create(@RequestBody User user){
        return projectService.create(project);
    }

    public ResponseEntity<Object> calculateCompletedTasks() {return projectService.calculateCompletedTasks(); }

    public ResponseEntity<Object>  completion() {return projectService.completion(); }

    public ResponseEntity<Object> isDone() {return projectService.isDone(); }


}
