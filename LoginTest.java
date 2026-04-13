package com.chat.app;

import org.junit.jupiter.api.Test;

public class LoginTest {

    Login login = new Login();

    @Test
    public void testUsernameFormat() {
        // Test Data: "kyl_1" should be true
        assertTrue(login.checkUserName("kyl_1"));
        // Test Data: "kyle!!!!!!!" should be false
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testPasswordComplexity() {
        // Test Data: "Ch&&sec@ke99" should be true
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99"));
        // Test Data: "password" should be false
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testPhoneFormat() {
        // Test Data: "+27838968976" should be true
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
        // Test Data: "08966553" should be false
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    private void assertTrue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertFalse() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}