package com.example.demospring;

import java.util.HashMap;
import java.util.Map;

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

    User check(int userID, int userPin) {
        for (User user : users.keySet()){
            if (user.getUserID() == userID && user.getUserPin() == userPin){
                return user;
            }
        }
        return null;
    }

    public boolean deposit(int amount, int userID) {
        for (User user: users.keySet()){
            if (user.getUserID() == userID) {
                int remain = user.getBalance() + amount;
                user.setBalance(remain);
                System.out.println("Success!");
                return true;
            }
        }
        return false;
    }
    public boolean withdrawal(int amount, int userID) {
        for (User user: users.keySet()){
            if (user.getUserID() == userID){
                int remain = user.getBalance() - amount;
                user.setBalance(remain);
                System.out.println("Success!");
                return true;
            }

        }
        return false;
    }
    public boolean changePin(int newPin, int userID, int userPin) {
        for (User user: users.keySet()){
            if (user.getUserID() == userID && user.getUserPin() == userPin){
                user.setUserPin(newPin);
                return true;
            }
        }
        return false;
    }


    public void checkBalance(int userID) {
        for (User user: users.keySet()){
            if (user.getUserID() == userID){
                System.out.println("Your balance: " + user.getBalance());
            }
        }
    }
}
