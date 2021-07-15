package com.lexmatos.msdiary.diary;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/resilience")
public class ResilienceControler {

    @GetMapping
    @Retry(name="resilience", fallbackMethod = "fallbackResilience")
    public ResponseEntity <String> resilience(){
    	log.info("Requet to resilience");
    	
    	var response = new RestTemplate().getForEntity("http://localhost:8080",String.class);
    	return ResponseEntity.ok(response.getBody());
    }
    
    public ResponseEntity <String> fallbackResilience(Exception ex) {
    	
    	return ResponseEntity.ok("FallbackResilience is working");
    }
    
}
