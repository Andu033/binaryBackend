package com.satrabench.getfriends.controller;

import com.satrabench.getfriends.model.Incident;
import com.satrabench.getfriends.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/incidents")
public class IncidentController {

    private final IncidentService incidentService;

    @Autowired
    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @GetMapping("/getincidents")
    public ResponseEntity<Object> getOpen(){
        return incidentService.getAllOpen();
    }

    @GetMapping("/invalidate")
    public ResponseEntity<Object> invalidate(@RequestParam("id") int id){
        return incidentService.invalidate(id);
    }

    @GetMapping("/ongoing")
    public ResponseEntity<Object> ongoing(@RequestParam("id") int id){
        return incidentService.ongoing(id);
    }

    @PostMapping("/addincident")
    public ResponseEntity<Object> addIncident(@RequestBody Incident incident,@RequestParam("id") int id){
        return incidentService.createIncident(incident,id);
    }

    @GetMapping("/ban")
    public ResponseEntity<Object> ban(@RequestParam("id") int id){
        return incidentService.blockUser(id);
    }



}
