package com.example.demospring;

public class User {
    private int userID;
    private int userPin;
    private int balance;
    public User(){}
    public User(int userID, int userPin, int balance) {
        this.userID = userID;
        this.userPin = userPin;
        this.balance = balance;
    }

    public int getUserID() {
        return userID;
    }

    public int getUserPin() {
        return userPin;
    }

    public int getBalance() {
        return balance;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserPin(int userPin) {
        this.userPin = userPin;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
