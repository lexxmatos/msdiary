package com.lexmatos.oauth.controller;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lexmatos.oauth.entities.User;
import com.lexmatos.oauth.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private Environment environment;

    @Autowired
    private UserService service;
    
    @GetMapping(value = "/search")
    // http://localhost:40999/users/search?email=Andre@rnp.br
    public ResponseEntity <List<User>> findBy(@RequestParam("email") String email){

        log.info("Port: "+ environment.getProperty("local.server.port"));

        try {
            var users = service.findUserByEmail(email);
            return new ResponseEntity<List<User>>(users, HttpStatus.OK); 
        } catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }     
}
