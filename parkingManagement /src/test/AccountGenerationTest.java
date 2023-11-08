package test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;


import GUI.SuperManagerWindow;
import bookingsystem.SuperManager;

public class AccountGenerationTest {

    private SuperManager manager;

    @Before
    public void setUp() {
        manager = SuperManager.getInstance();
    }

    @Test
    public void testGenerateUniqueName() {
        Set<String> usedNames = new HashSet<String>();
        for (int i = 0; i < 100; i++) {
            String name = manager.generateUniqueName();
            assertFalse(usedNames.contains(name));
            usedNames.add(name);
        }
    }

    @Test
    public void testGenerateUniquePassword() {
        Set<String> usedPasswords = new HashSet<String>();
        for (int i = 0; i < 100; i++) {
            String password = manager.generateUniquePassword();
            assertFalse(usedPasswords.contains(password));
            usedPasswords.add(password);
            assertTrue(password.matches("[A-Za-z0-9]{5}"));
        }
    }
    
    
    @Test
    public void testLoginWithCorrectCredentials() {
        SuperManagerWindow window = new SuperManagerWindow();
        window.usernameField.setText("supermanager");
        window.passwordField.setText("pass123");
        window.loginButton.doClick();

        // Check that the dashboard panel is displayed
        //assertEquals(window.getContentPane().getComponent(0), window.dashboardPanel);
    }

//    @Test
//    public void testLoginWithIncorrectCredentials() {
//        SuperManagerWindow window = new SuperManagerWindow();
//        window.usernameField.setText("wrongusername");
//        window.passwordField.setText("wrongpassword");
//        window.loginButton.doClick();
//
//        // Check that an error message is displayed
//       // assertEquals("Invalid username or password.", window.getComponents()[1].toString());
//    }

    @Test
    public void testGenerateUsername() {
        SuperManagerWindow window = new SuperManagerWindow();
        String username = window.generateUsername();
        assertEquals(5, username.length());
    }

    @Test
    public void testGeneratePassword() {
        SuperManagerWindow window = new SuperManagerWindow();
        String password = window.generatePassword();
        assertEquals(4, password.length());
    }
}