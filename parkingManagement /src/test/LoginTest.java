package test;

import org.junit.*;

import GUI.BookingWindow;
import GUI.Login;
import GUI.LoginWindow;

import static org.junit.Assert.*;

public class LoginTest {

    private Login login;

    @Before
    public void setUp() {
        login = new Login();
        login.loadClientsFromFile();
    }

 

    @Test
    public void testValidateSuccessful() {
        assertTrue("Validation should succeed with correct credentials",
                   login.validate("james@gmail.com", "111"));
    }

    @Test
    public void testValidateUnsuccessful() {
        assertFalse("Validation should fail with incorrect credentials",
                    login.validate("jane@example.com", "999"));
    }

    @Test
    public void testCheckClientTypeFound() {
        assertEquals("Client type should be returned for existing client",
                     "Faculty", login.checkClientType("james@gmail.com"));
    }

    @Test
    public void testCheckClientTypeNotFound() {
        assertNull("Null should be returned for non-existing client",
                   login.checkClientType("nonexistent@example.com"));
    }
    
    @Test
	public void testLoginWithValidCredentials() {
		LoginWindow loginWindow = new LoginWindow();
		Login login = new Login();
		login.loadClientsFromFile();
		String email = "fahad@gmail.com";
		String password = "999";
		loginWindow.userText.setText(email);
		loginWindow.passwordText.setText(password);
		loginWindow.loginButton.doClick();
		BookingWindow bookingWindow = new BookingWindow();
	
	}

	@Test
	public void testLoginWithInvalidCredentials() {
		LoginWindow loginWindow = new LoginWindow();
		Login login = new Login();
		login.loadClientsFromFile();
		String email = "invalid@example.com";
		String password = "invalidpassword";
		loginWindow.userText.setText(email);
		loginWindow.passwordText.setText(password);
		loginWindow.loginButton.doClick();
		assertEquals("User Not found", loginWindow.slabel.getText());
	}

	
    
    
    

}