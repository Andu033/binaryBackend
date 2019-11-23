package com.satrabench.getfriends.service;

import com.satrabench.getfriends.repository.IncidentRepository;
import com.satrabench.getfriends.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
