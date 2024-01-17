package com.management;

import com.management.entities.Role;
import com.management.entities.User;
import com.management.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MainApplication {
    @Autowired
    UserService userService;
    public static void main(String[] args) {SpringApplication.run(MainApplication.class, args);}
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){return new BCryptPasswordEncoder();}
    //@PostConstruct
    void initial_users(){
        userService.addRole(new Role("ADMIN"));
        userService.addRole(new Role("ORGANISER"));
        userService.addRole(new Role("CLIENT"));
        //userService.addRole(new Role("CREATE"));

        userService.saveUser(new User("admin","123",true,null));
        userService.saveUser(new User("organiser","123",true,null));
        userService.saveUser(new User("client","123",true,null));

        userService.addRoleToUser("admin","ADMIN");
        //userService.addRoleToUser("admin","CREATE");
        userService.addRoleToUser("organiser","ORGANISER");
        //userService.addRoleToUser("organiser","CREATE");
        userService.addRoleToUser("client","CLIENT");

    }
}