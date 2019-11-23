package com.satrabench.getfriends.controller;

import com.satrabench.getfriends.model.Project;
import com.satrabench.getfriends.model.Supervised;
import com.satrabench.getfriends.service.SupervisedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supervised")
public class SupervisedController {

    private final SupervisedService supervisedService;

    @Autowired
    public SupervisedController(SupervisedService supervisedService) {
        this.supervisedService = supervisedService;
    }

    @GetMapping("/getsupervised")
    public ResponseEntity<Object> getOpen(@RequestParam("id") int id){
        return supervisedService.getSupervised(id);
    }

    @GetMapping("/invalidate")
    public ResponseEntity<Object> invalidate(@RequestParam("id") int id){
        return supervisedService.invalidate(id);
    }

    @GetMapping("/ongoing")
    public ResponseEntity<Object> ongoing(@RequestParam("id") int id){
        return supervisedService.ongoing(id);
    }

    @PostMapping("/addincident")
    public ResponseEntity<Object> addIncident(@RequestBody Supervised supervised,@RequestParam("id") int id){
        return supervisedService.createSupervised(supervised,id);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Supervised supervised){
        return supervisedService.create(supervised);
    }

    @GetMapping("/addProject")
    public ResponseEntity<Object> projectToSupervised(@RequestParam Integer supervisedId, @RequestBody Project project ) {return supervisedService.projectToSupervised(supervisedId, project); }



}
