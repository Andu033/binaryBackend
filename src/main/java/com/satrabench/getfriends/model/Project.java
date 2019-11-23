package com.satrabench.getfriends.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @ElementCollection
    @OneToMany(mappedBy = "project")
    private List<String> project = new ArrayList<>(); //TASK IN LOC DE STRING

    private String name;
    private String description;
    private int completion;
    private boolean isDone;
    private int completedTasks;

    public boolean isDone(Project project) {
        if (project.completion== 100)
            return true;
        return false;
    }
}
