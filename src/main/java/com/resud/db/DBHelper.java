package com.resud.db;

import java.sql.*;

/**
 * Класс для обслуживания БД
 */
public class DBHelper {

    private final String URL = "jdbc:mysql://127.0.0.1:3306/Project";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    private Connection connection;

    public DBHelper(){
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if(!connection.isClosed()){
//                System.out.println("Соединение с БД установлено!");
            } else {
//                System.out.println("Ошибка подключения!");
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
