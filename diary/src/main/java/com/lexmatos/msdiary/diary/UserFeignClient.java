package com.lexmatos.msdiary.diary;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Component
@FeignClient(name = "user", path = "/users")
public interface UserFeignClient {

	@GetMapping(value = "/{id}")
    public ResponseEntity <User> findById(@PathVariable("id") Long id);
}
