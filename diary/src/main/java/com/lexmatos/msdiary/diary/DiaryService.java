package com.lexmatos.msdiary.diary;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

//https://spring.io/guides/gs/circuit-breaker/
// zull e eureka client

@Slf4j
@Service
public class DiaryService {

    @Autowired
    private Environment environment;

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private DiaryRepository repository;
    
    public DiaryVO findDairyById(Long id){

        log.info("Port: "+ environment.getProperty("local.server.port"));

        Diary diary = repository.findById(id).get();
        log.info("Diary: "+ diary.toString());
        
        User user = userFeignClient.findById(diary.getUserId()).getBody();

        return new DiaryVO(diary,user);
    }

    public DiaryVO findDairyByDefult(){

        log.info("Port: "+ environment.getProperty("local.server.port"));

        return new DiaryVO();
    }    
}
