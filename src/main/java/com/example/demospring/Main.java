package com.example.demospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("beansUsers.xml");
    private static final Scanner in = new Scanner(System.in);
    private static BankATM bankATM = new BankATM();
    private static UserService userService = new UserService();
    
    public static void main(String[] args){
        bankATM = context.getBean("users",BankATM.class);
        System.out.println("Enter id of user's card:");
        int userID = in.nextInt();
        System.out.println("Pin: ");
        int userPin = in.nextInt();
        User user = bankATM.check(userID, userPin);
    if (user != null){
            while(true){
                menu(user);
            }
        }else {
            System.out.println("Wrong credentials!");
        }
    }

    private static void menu(User user) {
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
                if (bankATM.deposit(num, user.getUserID())) {
                    userService.updateAccounts(user);
                }
                break;
            case 2:
                System.out.println("Enter the number: ");
                num = in.nextInt();
                if (bankATM.withdrawal(num, user.getUserID())) {
                    userService.updateAccounts(user);
                }
                break;
            case 3:
                bankATM.checkBalance(user.getUserID());
                break;
            case 4:
                System.exit(0);
                break;
        }
    }
}
