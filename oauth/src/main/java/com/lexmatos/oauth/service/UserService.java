package com.lexmatos.oauth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.lexmatos.oauth.entities.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

    @Autowired
    private Environment environment;

    @Autowired
    private UserFeignClient userFeignClient;

    public List<User> findUserByEmail(String email){

        log.info("Port: "+ environment.getProperty("local.server.port"));

        if (!userFeignClient.findByEmail(email).hasBody()) {
        	throw new IllegalArgumentException("Email não encontrado");
        }
        log.info("Email: "+email+" encontrado");
        
        return userFeignClient.findByEmail(email).getBody();
    }    
}
