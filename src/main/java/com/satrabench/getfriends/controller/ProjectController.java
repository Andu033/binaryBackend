package com.satrabench.getfriends.controller;

import com.satrabench.getfriends.model.Project;
import com.satrabench.getfriends.service.ProjectService;
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
    public ResponseEntity<Object> create(@RequestBody Project project){
        return projectService.create(project);
    }

    @GetMapping("/project/completed")
    public ResponseEntity<Object> calculateCompletedTasks(@RequestBody Project project) {return projectService.calculateCompletedTasks(project); }

    @GetMapping("/project/completion")
    public ResponseEntity<Object>  completion(@RequestBody Project project) {return projectService.completion(project); }

    //public ResponseEntity<Object> isDone(@RequestBody Project project) {return projectService.isDone(project); }


}
