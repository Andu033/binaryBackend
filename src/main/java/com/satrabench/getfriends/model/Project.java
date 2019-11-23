package com.satrabench.getfriends.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


public class Project {


    private List<String> project = new ArrayList<>(); //TASK IN LOC DE STRING
    private String name;
    private String description;
    private int completion;
    private boolean isDone;
    private int completedTasks;


}
