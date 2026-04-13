package com.chat.app;

import java.util.Scanner;

public class PROG5121_POE_Part1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login log = new Login(); // Connects to your Login class

        System.out.println("--- REGISTRATION ---");
        System.out.print("First Name: ");
        String fName = input.nextLine();
        
        System.out.print("Last Name: ");
        String lName = input.nextLine();
        
        System.out.print("Choose Username: ");
        String user = input.nextLine();
        
        System.out.print("Choose Password: ");
        String pass = input.nextLine();

        // Register and print the response from the Login class
        String status = log.registerUser(fName, lName, user, pass);
        System.out.println(status);

        // Only ask for login if registration was successful
        if (status.equals("Username successfully captured.")) {
            System.out.println("\n--- LOGIN ---");
            System.out.print("Username: ");
            String logUser = input.nextLine();
            
            System.out.print("Password: ");
            String logPass = input.nextLine();

            boolean isOk = log.loginUser(logUser, logPass);
            System.out.println(log.returnLoginStatus(isOk));
        }
    }
}