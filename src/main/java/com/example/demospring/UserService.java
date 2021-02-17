package com.example.demospring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private String dbLink;
    private String dbUsername;
    private String dbPassword;
    Connection connection;
    Statement statement;
    private List<User> accounts = new ArrayList<>();

    public List<User> getUsers() {
        return accounts;
    }

    public void updateAccounts(User user) {
        try {
            String query = "UPDATE account SET pin = '" + user.getUserPin() + "', cash = '" + user.getBalance() +"'  WHERE id = " + user.getUserID();
            statement = connection.createStatement();
            statement.executeUpdate(query);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void setDbLink(String dbLink) {
        this.dbLink = dbLink;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    @PostConstruct
    public void init() throws SQLException {
        this.createDbConnection();
    }

    public void createDbConnection() throws SQLException {
        // init connection
        try {
            connection = DriverManager.getConnection(dbLink, dbUsername, dbPassword);
            statement = connection.createStatement();
            String queryString = "select * from account";
            ResultSet resultSet = statement.executeQuery(queryString);
            while (resultSet.next()){
                User user = new User(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3));
                accounts.add(user);
            }
            System.out.println("UserService.createDbConnection");
            System.out.println(accounts);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
    }

    @PreDestroy
    public void destroyCustom() throws SQLException {
        this.closeConnections();
    }

    public void closeConnections() throws SQLException {
        connection.close();
        System.out.println("UserService.closeConnections");
    }
}
