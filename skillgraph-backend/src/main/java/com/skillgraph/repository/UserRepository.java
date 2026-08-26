package com.skillgraph.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skillgraph.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}