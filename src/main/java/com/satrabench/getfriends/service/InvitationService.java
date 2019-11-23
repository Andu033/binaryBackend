package com.satrabench.getfriends.service;

import com.satrabench.getfriends.model.Invitation;
import com.satrabench.getfriends.model.User;
import com.satrabench.getfriends.repository.InvitationRepository;
import com.satrabench.getfriends.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvitationService {

    private final InvitationRepository invitationRepository;
    private final UserRepository userRepository;
    @Autowired
    public InvitationService(InvitationRepository invitationRepository, UserRepository userRepository) {
        this.invitationRepository = invitationRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<Object> getAll(){
        List<Invitation> invitations = invitationRepository.findAll();
        return new ResponseEntity<Object>(invitations, HttpStatus.OK);
    }

    public ResponseEntity<Object> create(int idSuper, int idUser) {
        Invitation i = invitationRepository.save(new Invitation(idSuper, idUser));
        User u = userRepository.findById(idUser);
        i.setUser(u);
        invitationRepository.save(i);

        return new ResponseEntity<Object>(i, HttpStatus.OK);
    }

    public ResponseEntity<Object> accept(int idInvitation) {
        Invitation i = invitationRepository.findById(idInvitation);
        i.setStatus("accepted");
        User u = userRepository.findById(i.getIdUser());

        //u.setIncidents();
        //u.setIncidents(u.getIncidents().add());
        return new ResponseEntity<Object>(i, HttpStatus.OK);
    }
}

