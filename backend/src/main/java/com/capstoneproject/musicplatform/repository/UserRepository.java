package com.capstoneproject.musicplatform.repository;

import com.capstoneproject.musicplatform.model.User;       //Import entity user
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;        //Null control

public interface UserRepository extends JpaRepository<User, Long> {     //Data type user, id type long
    Optional<User> findByUsername(String username);     //Find user in database by username - may not exist
    boolean existsByUsername(String username);         //Find user in database by username
    boolean existsByEmail(String email);        //Find user in database by email
}