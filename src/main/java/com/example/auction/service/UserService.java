package com.example.auction.service;

import com.example.auction.model.User;

import java.util.List;

public interface UserService {

    /**
     * Find User by Id
     *
     * @param userId
     * @return User
     */
    User findUserById (Long userId);

    /**
     * Find user by username
     * @param userName
     * @return User
     */
    User findByUsername (String userName);

    /**
     * Find all users
     *
     * @return list of existing users
     */
    List<User> findAllUsers();


    /**
     * Create new user
     *
     * @param user
     */
    void createUser(User user);

    /**
     * Update existing user
     *
     * @param user
     */
    void updateUser(User user);
}
