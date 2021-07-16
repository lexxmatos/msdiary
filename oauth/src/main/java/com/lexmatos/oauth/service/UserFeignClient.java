package com.lexmatos.oauth.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.lexmatos.oauth.entities.User;

@Component
@FeignClient(name = "user", path = "/users")
public interface UserFeignClient {

    @GetMapping(value = "/search")
    ResponseEntity <List<User>> findByEmail(@RequestParam("email") String email);
}