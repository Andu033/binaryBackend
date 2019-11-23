package com.satrabench.getfriends.service;

import com.satrabench.getfriends.model.Project;
import com.satrabench.getfriends.model.User;
import com.satrabench.getfriends.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public ResponseEntity<Object> getAll(){
        List<Project> project =projectRepository.findAll();
        return new ResponseEntity<Object>(project, HttpStatus.OK);
    }

    public ResponseEntity<Object> create(User user){
        Project p = projectRepository.save(project);
        return new ResponseEntity<Object>(p, HttpStatus.OK);
    }

    public ResponseEntity<Object> calculateCompletedTasks() {

        for (Task task : this.project) {
            if (task.isDone == 1)
                completedTasks++;
        }
        return completedTasks;
    }

    public ResponseEntity<Object>  completion() {

        this.completion = (this.project.size() * 100) / completedTasks;
        return completion;
    }

    public ResponseEntity<Object> isDone() {

        if (this.completion == 100)
            return true;
    }

}
