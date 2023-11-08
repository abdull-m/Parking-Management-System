package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import GUI.Login;
import bookingsystem.Client;

public class RegistrationTest {

    private Login login;

    @Before
    public void setUp() {
        login = new Login();
        login.loadClientsFromFile();
        
    }

    @Test
    public void testRegister() {
        int initialSize = login.clients.size();
        login.register("Visitor", "test@example.com", "password123");
        int finalSize = login.clients.size();
        assertEquals("New client should be added to list", initialSize + 1, finalSize);
        Client newClient = login.clients.get(finalSize - 1);
        assertEquals("Client email should match", "test@example.com", newClient.getEmail());
        assertEquals("Client password should match", "password123", newClient.getPassword());
    }
    
    
    @Test
    public void testCheckClientType() {
        assertEquals("Visitor", login.checkClientType("test@example.com"));
        assertNull("Null should be returned for non-existing client",
                login.checkClientType("nonexistent@example.com"));
    }
    
    
}
