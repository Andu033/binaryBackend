package com.satrabench.getfriends.service;

import com.satrabench.getfriends.model.Incident;
import com.satrabench.getfriends.model.User;
import com.satrabench.getfriends.repository.IncidentRepository;
import com.satrabench.getfriends.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class IncidentService {


    private final UserRepository userRepository;

    private final IncidentRepository incidentRepository;

    @Autowired
    public IncidentService(UserRepository userRepository,
            IncidentRepository incidentRepository) {
        this.userRepository = userRepository;
        this.incidentRepository = incidentRepository;
    }

    public ResponseEntity<Object> createIncident(Incident incident, int userId){
        User u = userRepository.findById(userId).get();
        incident.setUser(u);
        Incident incident1 = incidentRepository.save(incident);
        u.getIncidents().add(incident1);
        userRepository.save(u);
        return new ResponseEntity<>(incident1, HttpStatus.OK);
    }

    public ResponseEntity<Object> getAllOpen(){
        return new ResponseEntity<>(incidentRepository.findAllByActiveTrue(), HttpStatus.OK);
    }

    public ResponseEntity<Object> delete(int id){incidentRepository.delete(incidentRepository.findById(id).get());
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    public ResponseEntity<Object> invalidate(int incidentId){
        Incident incident = incidentRepository.findById(incidentId).get();
        incident.setActive(false);
        incidentRepository.save(incident);
        return new ResponseEntity<>("saved",HttpStatus.OK);
    }
    public ResponseEntity<Object> ongoing(int incidentId){
        Incident incident = incidentRepository.findById(incidentId).get();
        incident.setHelp(true);
        incidentRepository.save(incident);
        return new ResponseEntity<>("saved",HttpStatus.OK);
    }

    public ResponseEntity<Object> blockUser(int incidentId){
        for(User user:userRepository.findAll()){
            for(Incident incident:user.getIncidents()){
                if(incident.getId() == incidentId){
                    user.setBanned(true);
                    incidentRepository.deleteById(incidentId);
                    userRepository.save(user);
                    break;
                }
            }
        }
        return new ResponseEntity<>("aasdasd",HttpStatus.OK);
    }

}
