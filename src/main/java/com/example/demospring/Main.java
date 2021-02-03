package com.example.demospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("beansUsers.xml");
    private static final Scanner in = new Scanner(System.in);
    private static BankATM bankATM = new BankATM();
    
    public static void main(String[] args){
        bankATM = context.getBean("users",BankATM.class);
        System.out.println("Enter id of user's card:");
        int userID = in.nextInt();
        System.out.println("Pin: ");
        int userPin = in.nextInt();
        if (bankATM.check(userID, userPin)){
            while(true){
                menu(userID);
            }
        }else {
            System.out.println("Wrong credentials!");
        }
    }

    private static void menu(int userID) {
        System.out.println("1. deposit\n" +
                "2. withdrawal\n" +
                "3. check balance \n" +
                "4. exit");
        int choice = in.nextInt();
        int num = 0;
        switch (choice){
            case 1:
                System.out.println("Enter the number: ");
                num = in.nextInt();
                bankATM.deposit(num, userID);
                break;
            case 2:
                System.out.println("Enter the number: ");
                num = in.nextInt();
                bankATM.withdrawal(num, userID);
                break;
            case 3:
                bankATM.checkBalance(userID);
                break;
            case 4:
                System.exit(0);
                break;
        }
    }
}
