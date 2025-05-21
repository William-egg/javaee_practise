package com.example.javaee_practise.Dao;

import com.example.javaee_practise.model.user;
import com.example.javaee_practise.utilts.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class loginDao {
    jdbc myjdbc = null;
    Connection connection = null;
    public loginDao() {
        myjdbc = new jdbc();
        connection = myjdbc.getConnection();
    }
    public user getUserByName(String name){
        String sql = "SELECT * FROM userinfo WHERE username = ?";
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user user = new user();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<user> getAllUserInfo(){
        String sql = "SELECT * FROM userinfo";
        List<user> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                user user = new user();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                //将user添加到List中
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
    public boolean changeUserByName(String oldUserName,user newUser){
        String sql = "UPDATE userinfo SET username = ?, password = ? WHERE username = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newUser.getUsername());
            preparedStatement.setString(2, newUser.getPassword());
            preparedStatement.setString(3, oldUserName);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
