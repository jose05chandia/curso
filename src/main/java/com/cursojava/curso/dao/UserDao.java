package com.cursojava.curso.dao;

import com.cursojava.curso.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    User getUser(Long id);
    void update(Long id);
    void delete(Long id);

    void create(User user);

    User login(User user);
}
