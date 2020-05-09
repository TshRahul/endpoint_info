package com.stereo.endpoint_information.services;

import com.stereo.endpoint_information.models.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(String username);

    void addUser(User user);

    void updateUser(User user);

    String deleteUser(String username);

//    int store(MultipartFile file, String username, HttpSession session);

}
