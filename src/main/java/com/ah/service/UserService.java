package com.ah.service;

import com.ah.pojo.User;

import java.util.List;

public interface UserService {
    int deleteById(Integer id);

    List<User> findAll();

    int updateById(User user);

    int addUser(User user);

}
