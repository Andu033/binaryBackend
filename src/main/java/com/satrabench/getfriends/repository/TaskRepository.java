package com.satrabench.getfriends.repository;

import com.satrabench.getfriends.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
}