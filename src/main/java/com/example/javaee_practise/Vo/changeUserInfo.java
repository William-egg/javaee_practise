package com.example.javaee_practise.Vo;

import lombok.Data;

@Data
public class changeUserInfo {
    String username;
    String newUsername;
    String newPassword;
    public changeUserInfo() {
    }

    public changeUserInfo(String username, String newUsername, String newPassword) {
        this.username = username;
        this.newUsername = newUsername;
        this.newPassword = newPassword;
    }

}
