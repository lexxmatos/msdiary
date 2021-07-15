package com.lexmatos.msdiary.diary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {

    private Long id;
    private String email;
    private String name;
    private String port;
}
