package com.satrabench.getfriends.service;

import com.satrabench.getfriends.model.Supervised;
import com.satrabench.getfriends.model.User;
import com.satrabench.getfriends.repository.SupervisedRepository;
import com.satrabench.getfriends.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SupervisedService {

    private final UserRepository userRepository;

    private final SupervisedRepository supervisedRepository;

    @Autowired
    public SupervisedService(UserRepository userRepository,
            SupervisedRepository incidentRepository) {
        this.userRepository = userRepository;
        this.supervisedRepository = incidentRepository;
    }

    public ResponseEntity<Object> createSupervised(Supervised supervised, int userId){
        User u = userRepository.findById(userId).get();
        supervised.setUser(u);
        Supervised incident1 = supervisedRepository.save(supervised);
        u.getIncidents().add(incident1);
        userRepository.save(u);
        return new ResponseEntity<>(incident1, HttpStatus.OK);
    }

    public ResponseEntity<Object> getSupervised(int id){
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }

    public ResponseEntity<Object> delete(int id){
        supervisedRepository.deleteById(id);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    public ResponseEntity<Object> invalidate(int incidentId){
        Supervised incident = supervisedRepository.findById(incidentId).get();
        supervisedRepository.save(incident);
        return new ResponseEntity<>("saved",HttpStatus.OK);
    }
    public ResponseEntity<Object> ongoing(int incidentId){
        Supervised incident = supervisedRepository.findById(incidentId).get();
        supervisedRepository.save(incident);
        return new ResponseEntity<>("saved",HttpStatus.OK);
    }

    public ResponseEntity<Object> create(Supervised supervised){
       Supervised supervised1 = supervisedRepository.save(supervised);
        return new ResponseEntity<>(supervised1,HttpStatus.OK);
    }

}
