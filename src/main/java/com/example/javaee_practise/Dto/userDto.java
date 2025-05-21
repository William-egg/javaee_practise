package com.example.javaee_practise.Dto;

import com.example.javaee_practise.model.user;
import lombok.Data;
import org.json.JSONObject;

@Data
public class userDto {
    private String username;
    private String password;

    public userDto() {
    }
    public userDto(user user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        jsonObject.put("password", password);
        return jsonObject;
    }
}
