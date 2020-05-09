package com.stereo.endpoint_information.repositories;

import com.stereo.endpoint_information.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {

    Optional<User> findByUsername(String username);

}
