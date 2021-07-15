package com.lexmatos.oauth.entities;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    
    private String email;
    private String name;
    private String password;
    private Set <Role> roles;;
    
    private String port;
}
