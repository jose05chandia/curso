package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UserDao;
import com.cursojava.curso.models.User;
import com.cursojava.curso.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.aspectj.apache.bcel.classfile.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @Autowired
    JWTUtil jwtUtil;

    @RequestMapping(value="prueba")
    public List<String> prueba(){
        return List.of("prueba","prueba2");
    }

    @RequestMapping(value="users")
    public List<User> getUsers(@RequestHeader(value="Authorization") String token){
        if(!validateToken(token)){return null;}
        return userDao.getUsers();
    }

    @RequestMapping(value="user/{id}")
    public User user(@PathVariable Long id){
        User u=new User();
        u.setId(id);
        u.setName("Jose");
        u.setLastname("Chandia");
        u.setEmail("jose05chandia@gmail.com");
        u.setPhone("993245344");
        u.setPassword("1234");
        return u;
    }

    @RequestMapping(value="update/{id}")
    public User update(@PathVariable Long id){
        User u=new User();
        u.setId(id);
        u.setName("Jose");
        u.setLastname("Chandia");
        u.setEmail("jose05chandia@gmail.com");
        u.setPhone("993245344");
        u.setPassword("1234");
        return u;
    }

    @RequestMapping(value="create", method= RequestMethod.POST)
    public void create(@RequestBody User user){

        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash=argon2.hash(1,1024,1,user.getPassword());
        user.setPassword(hash);
        userDao.create(user);
    }
    @RequestMapping(value="delete/{id}", method= RequestMethod.DELETE)
    public void delete(@PathVariable Long id,@RequestHeader(value="Authorization") String token){
        if(!validateToken(token)){return;}
        userDao.delete(id);
    }


    public boolean validateToken(String token){
        String idUser=jwtUtil.getKey(token);
        return idUser!=null;
    }

}
