package com.stereo.endpoint_information.services;

import com.stereo.endpoint_information.dao.UserDao;
import com.stereo.endpoint_information.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public List<User> getAllUsers() {

        return userDao.get();
    }

    @Override
    @Transactional
    public User getUser(String username) {
        return userDao.get(username);
    }

    @Override
    @Transactional
    public void addUser(User user) {

        userDao.save(user);

    }


    @Override
    @Transactional
    public String deleteUser(String username) {

        return userDao.delete(username);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUserDetails(user);
    }

}
