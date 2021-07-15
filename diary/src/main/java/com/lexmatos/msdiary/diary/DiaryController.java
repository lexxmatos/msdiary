package com.lexmatos.msdiary.diary;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/diarys")
public class DiaryController {

    @Autowired
    private DiaryRepository repository;

    @Autowired
    private DiaryService diaryService;
    
    @Autowired
    private Environment environment;

    @GetMapping
    public ResponseEntity <List<Diary>> findAll(){
    	
    	log.info("Port: "+ environment.getProperty("local.server.port"));
    	
        List <Diary> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <Diary> findById(@PathVariable Long id){

        Optional <Diary> diary = repository.findById(id);

        if (!diary.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        return new ResponseEntity<>(diary.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/complete/{diaryId}")
    public ResponseEntity <DiaryVO> findComplete(@PathVariable Long diaryId){

        DiaryVO vo = diaryService.findDairyById(diaryId);
        vo.setDiaryPort(environment.getProperty("local.server.port"));
        
        return new ResponseEntity<>(vo, HttpStatus.OK);
    }
}
