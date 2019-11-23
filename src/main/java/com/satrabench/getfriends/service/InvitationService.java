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
        User u = userRepository.findById(idUser).get();
        i.setUser(u);
        invitationRepository.save(i);

        return new ResponseEntity<Object>(i, HttpStatus.OK);
    }
}

