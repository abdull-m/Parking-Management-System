package test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import GUI.BookingWindow;
import GUI.Login;
import bookingsystem.Booking;
import bookingsystem.Payment;

public class BookingTest {
	public String path = "../parkingManagement/CSVs/booking.csv";
    private Booking booking;
    private Login login;
    private BookingWindow bookingWindow;
    private Payment payment;
    @Before
    public void setUp() {
    	
        booking = new Booking();
        login = new Login();
        login.loadClientsFromFile();
        bookingWindow = new BookingWindow();
        payment = new Payment();
    }
    
    
//    @After
//    public void tearDown() {
//        // perform any cleanup after each test
//    }
//    
    
    
    @Test
    public void testValidateSuccessful() {
        assertTrue("Validation should succeed with correct credentials",
                   login.validate("james@gmail.com", "111"));
    }
    
    @Test
    public void testValidateFailed() {
        assertFalse("Validation should fail with incorrect email and password",
                login.validate("invalid@gmail.com", "111"));
    }
    
    @Test
    public void testBookParkingSpace() throws IOException {
        // Add a new booking to the CSV file
        booking.bookparkingSpace("james@gmail.com", "2023-04-07", "10:00", "2", "SpotA", "10.00", "Paid", "ABC123");
        
        // Verify that the booking was added to the CSV file
        BufferedReader reader = new BufferedReader(new FileReader("../parkingManagement/CSVs/booking.csv"));
        String line;
        boolean found = false;
        while ((line = reader.readLine()) != null) {
            if (line.contains("james@gmail.com") && line.contains("2023-04-07") && line.contains("10:00") && line.contains("2")
                    && line.contains("SpotA") && line.contains("10.00") && line.contains("Paid") && line.contains("ABC123")) {
                found = true;
                break;
            }
        }
        reader.close();
        assertTrue(found);
    }
    
    
    
    
    @Test
    public void testCancelBooking() throws IOException {
        // Remove a booking from the CSV file
        booking.cancelBooking("james@gmail.com", "2023-04-07", "10:00", "2", "SpotA", "10.00", "Paid", "ABC123");
        
        // Verify that the booking was removed from the CSV file
        BufferedReader reader = new BufferedReader(new FileReader("../parkingManagement/CSVs/booking.csv"));
        String line;
        boolean found = false;
        while ((line = reader.readLine()) != null) {
            if (line.contains("james@gmail.com") && line.contains("2023-04-07") && line.contains("10:00") && line.contains("2")
                    && line.contains("SpotA") && line.contains("10.00") && line.contains("Paid") && line.contains("ABC123")) {
                found = true;
                break;
            }
        }
        reader.close();
        assertFalse(found);
    }
    
    
    
    @Test
	public void testInitialGUIState() {
		// Verify that the initial state of the GUI is as expected
		assertEquals("Client HomePage", bookingWindow.getTitle());
		assertNotNull(bookingWindow.getContentPane());
		assertEquals(650, bookingWindow.getWidth());
		assertEquals(400, bookingWindow.getHeight());
	}
	
	@Test
	public void testLocationComboBox() {
		// Verify that selecting a location sets the corresponding parking spot code
		bookingWindow.lst.setSelectedIndex(0);
		assertEquals("L1", bookingWindow.locationCode.getText());
		
		bookingWindow.lst.setSelectedIndex(1);
		assertEquals("L2", bookingWindow.locationCode.getText());
		
		bookingWindow.lst.setSelectedIndex(2);
		assertEquals("L3", bookingWindow.locationCode.getText());
		
		bookingWindow.lst.setSelectedIndex(3);
		assertEquals("L4", bookingWindow.locationCode.getText());
	}

	

    @Test
    public void testCheckOutWithValidInputs() {
        Payment payment = new Payment();
        double result = payment.checkOut(2.5, "ali@yorku.ca");
        assertEquals(12.5, result, 0.0);
    }

    @Test
    public void testCheckOutWithInvalidClientType() {
    
        double result = payment.checkOut(2.5, "invalid@example.com");
        assertEquals(-1.0, result, 0.0);
    }

    @Test
    public void testCheckOutWithZeroHours() {
        
        double result = payment.checkOut(0.0, "ali@yorku.ca");
        assertEquals(0.0, result, 0.0);
    }

    @Test
    public void testCheckOutWithNegativeHours() {
       
        double result = payment.checkOut(-2.5, "ali@yorku.ca");
        assertEquals(0.0, result, 0.0);
    }

    @Test
    public void testGetClientTypeWithValidEmail() {
        
        String result = payment.getClientType("ali@yorku.ca");
        assertEquals("Student", result);
    }

    @Test
    public void testGetClientTypeWithInvalidEmail() {
       
        String result = payment.getClientType("invalid@example.com");
        assertEquals("", result);
    }

    @Test
    public void testTimeStamp() {
        
        String result = payment.timeStamp();
        assertEquals(result, result);
    }
    
  
    

}