package com.example.javaee_practise.service;

import com.example.javaee_practise.Dao.loginDao;
import com.example.javaee_practise.Dto.userDto;
import com.example.javaee_practise.Vo.changeUserInfo;
import com.example.javaee_practise.model.user;
import com.example.javaee_practise.utilts.jdbc;

import java.util.ArrayList;
import java.util.List;

public class userService {
    loginDao myloginDao = null;
    public userService() {
        myloginDao = new loginDao();
    }
    public boolean ifLogin(user user){
        user user1 = myloginDao.getUserByName(user.getUsername());
        if(user.equals(user1)){
            return true;
        }
        else return false;
    }
    public List<userDto> getAllUserInfo(){
        List<user> userList = myloginDao.getAllUserInfo();
        List<userDto>   userDtoList = new ArrayList<>();
        for(user user : userList){
            userDtoList.add(new userDto(user));
        }
        return userDtoList;
    }

    public boolean changeUserByName(changeUserInfo changeUserInfo){
        return myloginDao.changeUserByName(changeUserInfo.getUsername(), new user(changeUserInfo.getNewUsername(), changeUserInfo.getNewPassword()));
    }
}
