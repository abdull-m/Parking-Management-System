package test;



import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import GUI.ManageParkingWindow;
import GUI.ManagementLoginWindow;
import bookingsystem.ManageParking;

public class ManageParkingTest {
	String path = "../parkingManagement/CSVs/management.csv";
    private ManageParking manageParking;
    private ManagementLoginWindow team;

    @Before
    public void setUp() {
        manageParking = new ManageParking();
         team = new ManagementLoginWindow();
        team.loadManagementFile();
    }

    
    @Test
    public void testValidateSuccessful() {
        assertTrue("Validation should succeed with correct credentials",
                   team.authenticate("zksff", "6hz7"));
    }
    
    @Test
    public void testAddSpaces() throws IOException {
        manageParking.addSpaces("Spot A");
        assertTrue(manageParking.checkParkingSpace("Spot A"));
    }

    @Test
    public void testRemoveSpaces() throws IOException {
        manageParking.addSpaces("Spot B");
        assertTrue(manageParking.checkParkingSpace("Spot B"));
        manageParking.removeSpaces("Spot B");
        assertFalse(manageParking.checkParkingSpace("Spot B"));
    }

    @Test
    public void testCheckParkingSpace() throws IOException {
        manageParking.addSpaces("Spot C");
        assertTrue(manageParking.checkParkingSpace("Spot C"));
        assertFalse(manageParking.checkParkingSpace("Spot D"));
    }


    @Test
    public void testViewBooking() throws IOException {
        manageParking.addSpaces("Spot F");
        List<String> bookings = manageParking.viewBooking("zksff");
        assertTrue(bookings.contains("Spot F"));
    }
    
    
    
    @Test
    public void testLocationCode() {
      ManageParkingWindow window = new ManageParkingWindow();
      window.lst.setSelectedIndex(0); // Select Lot1
      assertEquals("L1", window.locationCode.getText());
    }

    @Test
    public void testAddParkingSpace() {
      ManageParkingWindow window = new ManageParkingWindow();
      window.userName = "testuser";
      window.addInput.setText("L1-001"); // Add a new parking space in Lot1
      window.addButton.doClick(); // Click the add button
      assertEquals("Successfully Added Parking Space", window.addRemoveMessage.getText());
    }

    @Test
    public void testRemoveParkingSpace() {
      ManageParkingWindow window = new ManageParkingWindow();
      window.userName = "testuser";
      window.removeInput.setText("L1-001"); // Remove a parking space in Lot1
      window.removeButton.doClick(); // Click the remove button
      assertEquals("Successfully Removed Parking Space", window.addRemoveMessage.getText());
    }

}