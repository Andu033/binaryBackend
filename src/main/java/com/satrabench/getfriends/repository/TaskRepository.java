package com.satrabench.getfriends.repository;

import com.satrabench.getfriends.model.Incident;
import com.satrabench.getfriends.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
    List<Incident> findAllByActiveTrue();
}