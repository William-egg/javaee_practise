package com.example.javaee_practise.utilts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbc {
    String url = "jdbc:mysql://localhost:3306/practise_project?useSSL=false&serverTimezone=UTC";
    String username = "root";
    String password = "root";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    public jdbc() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = java.sql.DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }
    public boolean ifLogin(String username,String password){
        String sql = "SELECT * FROM userInfo WHERE username = ? AND password = ?";
        try{
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
