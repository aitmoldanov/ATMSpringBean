package com.example.demospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankATM {
    private Map<User,User> users = new HashMap<>();
    public BankATM() {
    }

    public BankATM(Map<User, User> users) {
        this.users = users;
    }

    public Map<User, User> getUsers() {
        return users;
    }

    public void setUsers(Map<User, User> users) {
        this.users = users;
    }

    boolean check(int userID, int userPin) {
        for (User user : users.keySet()){
            if (user.getUserID() == userID && user.getUserPin() == userPin){
                return true;
            }
        }
        return false;
    }

    public void deposit(int amount, int userID) {
        for (User user: users.keySet()){
            if (user.getUserID() == userID){
                int remain = user.getBalance() + amount;
                user.setBalance(remain);
                System.out.println("Success!");
            }else if(amount < 0) {
                System.out.println("Wrong input data!");
            }
        }
    }
    public void withdrawal(int amount, int userID) {
        for (User user: users.keySet()){
            if (user.getUserID() == userID){
                int remain = user.getBalance() - amount;
                user.setBalance(remain);
                System.out.println("Success!");
            }else if (amount < 0 && amount > user.getBalance()){
                System.out.println("Error!");
            }
        }
    }


    public void checkBalance(int userID) {
        for (User user: users.keySet()){
            if (user.getUserID() == userID){
                System.out.println("Your balance: " + user.getBalance());
            }
        }
    }
}
