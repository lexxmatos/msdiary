package com.lexmatos.msdiary.diary;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Getter
public class DiaryVO {

    private Long diaryId;
    private LocalDate diaryDate;
    private String diaryPort;

    private Long userId;
    private String userMail;
    private String userName;
    private String userPort;


    public DiaryVO(Diary diary, User user){
        this.diaryId = diary.getId();
        this.diaryDate = diary.getDate();

        this.userId = user.getId();
        this.userMail = user.getEmail();
        this.userName = user.getName();
        this.userPort = user.getPort();
    }
    
    public DiaryVO(){  }
}
