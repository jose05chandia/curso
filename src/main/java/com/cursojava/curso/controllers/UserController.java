package com.cursojava.curso.controllers;

import com.cursojava.curso.models.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping(value="prueba")
    public List<String> prueba(){
        return List.of("prueba","prueba2");
    }

    @RequestMapping(value="users")
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        User u1=new User();
        u1.setId(1L);
        u1.setName("Jose");
        u1.setLastname("Chandia");
        u1.setEmail("jose05chandia@gmail.com");
        u1.setPhone("993245344");
        u1.setPassword("1234");
        users.add(u1);

        User u2=new User();
        u2.setId(2L);
        u2.setName("Jose");
        u2.setLastname("Chandia");
        u2.setEmail("jose05chandia@gmail.com");
        u2.setPhone("993245344");
        u2.setPassword("1234");
        users.add(u2);

        User u3=new User();
        u3.setId(3L);
        u3.setName("Jose");
        u3.setLastname("Chandia");
        u3.setEmail("jose05chandia@gmail.com");
        u3.setPhone("993245344");
        u3.setPassword("1234");
        users.add(u3);
        return users;

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

    @RequestMapping(value="delete/{id}")
    public User delete(@PathVariable Long id){
        User u=new User();
        u.setId(id);
        u.setName("Jose");
        u.setLastname("Chandia");
        u.setEmail("jose05chandia@gmail.com");
        u.setPhone("993245344");
        u.setPassword("1234");
        return u;
    }

}
