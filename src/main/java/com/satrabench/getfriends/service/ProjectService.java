package com.satrabench.getfriends.service;

import com.satrabench.getfriends.model.Project;
import com.satrabench.getfriends.model.User;
import com.satrabench.getfriends.repository.ProjectRepository;
import com.satrabench.getfriends.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
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

    public ResponseEntity<Object> create(Project project){
        Project p = projectRepository.save(project);
        return new ResponseEntity<Object>(p, HttpStatus.OK);
    }

    public ResponseEntity<Object> calculateCompletedTasks(Project project) {
        Integer completedTasks = 0;
        /*for (Task task : project.getProject()) {
            if (task.isDone() == 1)
                completedTasks++;
        }*/
        return new ResponseEntity<Object>(5, HttpStatus.OK);
    }

    public ResponseEntity<Object> completion(Project project) {
        Integer completion = 0;
        completion = (project.getProject().size() * 100) / project.getCompletedTasks();
        return new ResponseEntity<Object>(completion, HttpStatus.OK);
    }


}
