package com.satrabench.getfriends.service;

import com.satrabench.getfriends.model.Project;
import com.satrabench.getfriends.model.Task;
import com.satrabench.getfriends.model.User;
import com.satrabench.getfriends.repository.ProjectRepository;
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

    public ResponseEntity<Object> create(Project project){
        Project p = projectRepository.save(project);
        return new ResponseEntity<Object>(p, HttpStatus.OK);
    }

    public ResponseEntity<Object> calculateCompletedTasks(Project project) {
        Integer completedTasks = 0;
        for (Task task : project.getProjects()) {
            if (task.isDone())
                completedTasks++;
        }
        return new ResponseEntity<Object>(completedTasks, HttpStatus.OK);
    }

    public ResponseEntity<Object> completion(Project project) {
        Integer completion = 0;
        completion = (project.getProjects().size() * 100) / project.getCompletedTasks();
        return new ResponseEntity<Object>(completion, HttpStatus.OK);
    }


}
