package com.satrabench.getfriends.repository;

import com.satrabench.getfriends.model.Supervised;
import com.satrabench.getfriends.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupervisedRepository extends JpaRepository<Supervised, Integer> {
    Supervised findByNameAndPassword(String user, String password);

}
