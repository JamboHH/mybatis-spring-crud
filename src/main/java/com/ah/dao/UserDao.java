package com.ah.dao;

import com.ah.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    int deleteById(@Param("id") Integer id);

    List<User> findAll();

    int updateById(User user);

    int addUser(User user);
}
