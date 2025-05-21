package com.example.javaee_practise.model;

import lombok.Data;

@Data
public class user {
    private String username;
    private String password;


    public user(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public user() {
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof user )) return false;
        user user1 = (user) o;
        if(user1 == null||!user1.getUsername().equals(this.username)||!user1.getPassword().equals(this.password)) return false;
        return true;
    }
    @Override
    public String toString(){
        return "user{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
