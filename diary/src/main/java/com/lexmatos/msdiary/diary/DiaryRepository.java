package com.lexmatos.msdiary.diary;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository <Diary, Long>{
    
}
