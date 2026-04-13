package com.chat.app;

public class Login {
    // These store the user's data while the program is running
    private String firstName, lastName, savedUser, savedPass;

    // 1. Check Username (Must have _ and be 5 chars or less)
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // 2. Check Password (8 chars, Capital, Number, Special char)
    public boolean checkPasswordComplexity(String password) {
        boolean hasCap = false, hasNum = false, hasSpec = false;
        
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) hasCap = true;
            if (Character.isDigit(c)) hasNum = true;
            if (!Character.isLetterOrDigit(c)) hasSpec = true;
        }
        return password.length() >= 8 && hasCap && hasNum && hasSpec;
    }

    // 3. Register User (Returns exact messages from your assignment rubric)
    public String registerUser(String fName, String lName, String user, String pass) {
        if (!checkUserName(user)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        } 
        if (!checkPasswordComplexity(pass)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        
        // Save data if validation passes
        this.firstName = fName;
        this.lastName = lName;
        this.savedUser = user;
        this.savedPass = pass;
        return "Username successfully captured.";
    }

    // 4. Login Logic
    public boolean loginUser(String user, String pass) {
        return user.equals(savedUser) && pass.equals(savedPass);
    }

    // 5. Final Status Message
    public String returnLoginStatus(boolean success) {
        if (success) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    boolean checkCellPhoneNumber(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}