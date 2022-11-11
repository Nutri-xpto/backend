package com.example.demo.dto;

public class LoginDTO {

    private String email;

    private String password;

    public LoginDTO(String email, String password){
        this.email =  email;
        this.password = password;
    }

    public String getEmail() { return this.email; }

    public String getPassword() { return this.password; }
}
