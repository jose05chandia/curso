package com.cursojava.curso.dao;

import com.cursojava.curso.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository

@Transactional

public class UserDaoImpl implements UserDao{

    @Override
    public List<User> getUsers() {
        String var;
        return null;
    }
}
