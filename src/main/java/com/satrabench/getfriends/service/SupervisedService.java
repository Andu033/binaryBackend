package com.satrabench.getfriends.service;

import com.satrabench.getfriends.model.*;
import com.satrabench.getfriends.repository.SupervisedRepository;
import com.satrabench.getfriends.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SupervisedService {

    private final UserRepository userRepository;

    private final SupervisedRepository supervisedRepository;

    @Autowired
    public SupervisedService(UserRepository userRepository,
                             SupervisedRepository supervisedRepository) {
        this.userRepository = userRepository;
        this.supervisedRepository = supervisedRepository;
    }

    public ResponseEntity<Object> createSupervised(Supervised supervised, int userId) {
        User u = userRepository.findById(userId);
        supervised.setUser(u);
        Supervised supervised1 = supervisedRepository.save(supervised);
        u.getIncidents().add(supervised1);
        userRepository.save(u);
        return new ResponseEntity<>(supervised1, HttpStatus.OK);
    }

    public ResponseEntity<Object> getSupervised(int id) {
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }

    public ResponseEntity<Object> delete(int id) {
        supervisedRepository.deleteById(id);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    public ResponseEntity<Object> invalidate(int supervisedId) {
        Supervised supervised = supervisedRepository.findById(supervisedId).get();
        supervisedRepository.save(supervised);
        return new ResponseEntity<>("saved", HttpStatus.OK);
    }

    public ResponseEntity<Object> ongoing(int supervisedId) {
        Supervised supervised = supervisedRepository.findById(supervisedId).get();
        supervisedRepository.save(supervised);
        return new ResponseEntity<>("saved", HttpStatus.OK);
    }

    public ResponseEntity<Object> create(Supervised supervised) {
        Supervised supervised1 = supervisedRepository.save(supervised);
        return new ResponseEntity<>(supervised1, HttpStatus.OK);
    }

    public ResponseEntity<Object> getAllTasks(int id) {
        Supervised supervised = supervisedRepository.findById(id).get();
        List<Task> alltasks = new ArrayList<Task>();
        List<Project> projects = supervised.getProjects();

        for (Project project : projects) {
            alltasks.addAll(project.getProjects());
        }
        alltasks.sort(new Sortbydeadline());
        return new ResponseEntity<>(alltasks, HttpStatus.OK);
    }

    public ResponseEntity<Object> projectToSupervised(Integer supervisedId, Project project) {
        Supervised supervised = supervisedRepository.findById(supervisedId).get();
        supervised.getProjects().add(project);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    //comparator for deadlines
    public static class Sortbydeadline implements Comparator<Task> {
        public int compare(Task a, Task b) {
            return a.getDeadline().compareTo(b.getDeadline());
        }
    }
}

