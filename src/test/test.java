// Referenced from Internet
// Summary:
/*
    Pre-defined format of the result string or message is stored and an argument string 
    message is created via filling the placeholders by fetching data from database, then 
    this string is compared with the string that is actually retrieved via the method:
    shareRideDetails();
*/

//Mockito module helps write unit test cases by implementing mock objects of the actual stubs.
package src.test;
import  src.test.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class MainTest {

    @Test
    public void testShareRideDetails() {
        // Input Provided
        Ride ride = new Ride("123", "Shashank", "1234567890", "ABC123");
        Traveler traveler = new Traveler("Sumit");
        // expected return message
        // Hard-Coded(in this case, dynamically fetched in actual implementation)
        String expected = "Sharing ride details via WhatsApp/SMS: Trip ID - 123, Driver Name - John's Driver, Driver Phone Number - 1234567890, Cab Number - ABC123";
        
        // actual message retrieved
        String actual = traveler.shareRideDetails(ride);
        
        // Comparing
        assertEquals(expected, actual);
    }

    @Test
    public void testTrackRide() {
        // Input Provided
        Ride ride = new Ride("123", "Shashank", "1234567890", "ABC123");
        TravelerCompanion companion = new TravelerCompanion("Kaushal");
         // expected return message
        // Hard-Coded(in this case, dynamically fetched in actual implementation)
        String expected = "Tracking ride with Trip ID - 123";

        // actual message retrieved
        String actual = companion.trackRide(ride);

        // Comparing
        assertEquals(expected, actual);
    }

    @Test
    public void testReceiveNotification() {
        // Input Provided
        TravelerCompanion companion = new TravelerCompanion("Kaushal");
        boolean tripComplete = true;
        // expected return message
        // Hard-Coded(in this case, dynamically fetched in actual implementation)
        String expected = "Received notification: Trip is complete.";

        // actual message retrieved
        String actual = companion.receiveNotification(tripComplete);

        // Comparing
        assertEquals(expected, actual);
    }

    @Test
    public void testShareFeedbackWithAdmin() {
        // Input provided
        TravelerCompanion companion = new TravelerCompanion("Kaushal");
        String feedback = "Great experience!";
         // expected return message
        // Hard-Coded(in this case, dynamically fetched in actual implementation)
        String expected = "Sharing feedback with Admin: Great experience!";

        // actual message retrieved
        String actual = companion.shareFeedbackWithAdmin(feedback);

        // Comparing
        assertEquals(expected, actual);
    }

    @Test
    public void testAddRide() {
        // Input Provided
        Admin admin = new Admin("Vishnu");
        Ride ride = new Ride("123", "Shashank", "1234567890", "ABC123");

        // real time data
        admin.addRide(ride);
        int expectedSize = 1;

        // Comparing
        assertEquals(expectedSize, admin.getRides().size());
    }

    @Test
    public void testAccessAllRides() {
        // Input Provided
        Admin admin = new Admin("Vishnu");
        Ride ride1 = new Ride("123", "Shashank", "1234567890", "ABC123");
        Ride ride2 = new Ride("456", "Divya", "9876543210", "XYZ789");
        admin.addRide(ride1);
        admin.addRide(ride2);
        String expected = "Accessing all rides shared by users...\nTrip ID: 123, Driver Name: Shashank's Driver\nTrip ID: 456, Driver Name: Divya's Driver\n";

        // actual message retrieval
        String actual = admin.accessAllRides();

        // Comparing
        assertEquals(expected, actual);
    }

    @Test
    public void testAccessExperienceFeedback() {
        // Admin Details
        Admin admin = new Admin("Vishnu");

        // expected debugging console message
        String expected = "Accessing overall experience feedback of users...";

        // actual message 
        String actual = admin.accessExperienceFeedback();

        // Comparing
        assertEquals(expected, actual);
    }
}
