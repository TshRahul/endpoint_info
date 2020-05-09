package com.stereo.endpoint_information.dao;

import com.stereo.endpoint_information.models.User;

import java.util.List;

public interface UserDao {

    List<User> get();

    User get(String username);

    void save(User user);

    String delete(String username);

    void updateUserDetails(User user);

  //  int updateProfileImage(String profileImage, String username);
}
