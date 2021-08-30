package com.example.myapplication.Domain;

import java.io.Serializable;

public class User implements Serializable {
    private String Password;
    private String Email;
    private String Username ="";
    private String token="null";
    public User(String email, String password, String username, String token) {
        this.Password = password;
        this.Email = email;
        this.Username = username;
        this.token = token;
    }
    public User(String email, String password,String username){

        this.Password = password;
        this.Email = email;
        this.Username =username;
    }

    public User(String email, String password){

        this.Password = password;
        this.Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
