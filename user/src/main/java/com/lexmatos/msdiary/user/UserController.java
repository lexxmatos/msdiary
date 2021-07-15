package com.lexmatos.msdiary.user;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private Environment environment;

    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity <List<User>> findAll(){
        
        log.info("Port: "+ environment.getProperty("local.server.port"));

        List <User> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <User> findById(@PathVariable("id") Long id){

        log.info("Port: "+ environment.getProperty("local.server.port"));

        var user = repository.findById(id).get();
        user.setPort( environment.getProperty("local.server.port"));

        
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    @GetMapping(value = "/search")
    // http://localhost:40999/users/search?email=Andre@rnp.br
    public ResponseEntity <List<User>> findBy(@RequestParam("email") String email){

        log.info("Port: "+ environment.getProperty("local.server.port"));

        var users = repository.findByEmail(email);
        var port = environment.getProperty("local.server.port");
        
        users.forEach(u -> u.setPort(port));
        
        return new ResponseEntity<>(users, HttpStatus.OK);
    }    
}
