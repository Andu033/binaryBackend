package com.satrabench.getfriends.service;

import com.satrabench.getfriends.model.Invitation;
import com.satrabench.getfriends.repository.InvitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvitationService {

    private final InvitationRepository invitationRepository;

    @Autowired
    public InvitationService(InvitationRepository invitationRepository) {
        this.invitationRepository = invitationRepository;
    }

    public ResponseEntity<Object> getAll(){
        List<Invitation> invitations = invitationRepository.findAll();
        return new ResponseEntity<Object>(invitations, HttpStatus.OK);
    }

    public ResponseEntity<Object> create(int idSuper, int idUser) {
        Invitation i = invitationRepository.save(new Invitation(idSuper, idUser));
        return new ResponseEntity<Object>(i, HttpStatus.OK);
    }
}

