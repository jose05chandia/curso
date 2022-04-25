package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UserDao;
import com.cursojava.curso.models.User;
import com.cursojava.curso.utils.JWTUtil;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {
    @Autowired
    UserDao userDao;

    @Autowired
    JWTUtil jwtUtil;

    @RequestMapping(value="login", method = RequestMethod.POST)
    public String login(@RequestBody User user){
        User userLogged=userDao.login(user);
        if(userLogged!=null){
            String token=jwtUtil.create(String.valueOf(userLogged.getId()), user.getEmail());
            return token;
        }
        return "fail";
    }

}
