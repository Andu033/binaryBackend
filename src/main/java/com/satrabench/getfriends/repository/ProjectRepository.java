package com.satrabench.getfriends.repository;


import com.satrabench.getfriends.model.Incident;
import com.satrabench.getfriends.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> {

    List<Project> findAllById();



}
