package src.main;
import  src.main.*;
import java.util.HashMap;
import java.util.Map;

class Ride {
    private String tripId;
    private String driverName;
    private String driverPhoneNumber;
    private String cabNumber;
    // variable to store whether the current ride is completed or not
    private boolean inProgress; 
    public Ride(String id, String name, String phone, String cab) {
        this.tripId = id;
        this.driverName = name;
        this.driverPhoneNumber = phone;
        this.cabNumber = cab;
        this.inProgress = true;
    }

    public void complete() {
        this.inProgress = false;
    }

    public String getTripId() {
        return tripId;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverPhoneNumber() {
        return driverPhoneNumber;
    }

    public String getCabNumber() {
        return cabNumber;
    }

    public boolean isInProgress() {
        return inProgress;
    }
}

interface User {
    void shareRideDetails(Ride ride) throws Exception;
    void reviewRideAuditTrail() throws Exception;
}

class Traveler implements User {
    private String username;

    public Traveler(String name) {
        this.username = name;
    }

    @Override
    public void shareRideDetails(Ride ride) throws Exception {
        if (ride == null) {
            throw new IllegalArgumentException("Ride cannot be null");
        }
        // Share ride details through WhatsApp or SMS
        // A whatsapp integration service is needed.
        System.out.println("Sharing ride details via WhatsApp/SMS: Trip ID - " + ride.getTripId() +
                ", Driver Name - " + ride.getDriverName() + ", Driver Phone Number - " + ride.getDriverPhoneNumber() +
                ", Cab Number - " + ride.getCabNumber());
    }

    @Override
    public void reviewRideAuditTrail() throws Exception {
        // Review audit trail of rides
        System.out.println("Reviewing audit trail of rides...");
    }
}

/* 
Implementing interface would also to avoid forced is-a relationship and thereby
high level abstraction and security.
*/
class TravelerCompanion implements User {
    private String username;

    public TravelerCompanion(String name) {
        this.username = name;
    }

    @Override
    public void shareRideDetails(Ride ride) throws Exception {
        if (ride == null) {
            throw new IllegalArgumentException("Ride cannot be null");
        }
        // Companion does not share ride details
        System.out.println("Traveler companion does not share ride details.");
    }

    @Override
    public void reviewRideAuditTrail() throws Exception {
        // Companion does not review ride audit trail
        System.out.println("Traveler companion does not review ride audit trail.");
    }

    public void trackRide(Ride ride) throws Exception {
        if (ride == null) {
            throw new IllegalArgumentException("Ride cannot be null");
        }
        // Track the ride of the traveler
        System.out.println("Tracking ride with Trip ID - " + ride.getTripId());
    }

    public void receiveNotification(boolean tripComplete) throws Exception {
        if (tripComplete) {
            System.out.println("Received notification: Trip is complete.");
        } else {
            System.out.println("Received nearby notification: Cab is approaching traveler's drop location.");
        }
    }

    public void shareFeedbackWithAdmin(String feedback) throws Exception {
        if (feedback == null || feedback.isEmpty()) {
            throw new IllegalArgumentException("Feedback cannot be null or empty");
        }
        // Share feedback with Admin
        System.out.println("Sharing feedback with Admin: " + feedback);
    }
}

class Admin implements User {
    private String username;
    private Map<String, Ride> rides;

    public Admin(String name) {
        this.username = name;
        this.rides = new HashMap<>();
    }

    @Override
    public void shareRideDetails(Ride ride) throws Exception {
        // Admin does not share ride details
        System.out.println("Admin does not share ride details.");
    }

    @Override
    public void reviewRideAuditTrail() throws Exception {
        // Admin does not review ride audit trail
        System.out.println("Admin does not review ride audit trail.");
    }

    public void accessAllRides() throws Exception {
        // Access all rides shared by users
        System.out.println("Accessing all rides shared by users...");
        for (Ride ride : rides.values()) {
            System.out.println("Trip ID: " + ride.getTripId() + ", Driver Name: " + ride.getDriverName());
        }
    }

    public void accessExperienceFeedback() throws Exception {
        // Access overall experience feedback of users
        System.out.println("Accessing overall experience feedback of users...");
    }

    public void addRide(Ride ride) throws Exception {
        if (ride == null) {
            throw new IllegalArgumentException("Ride cannot be null");
        }
        rides.put(ride.getTripId(), ride);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            // Sample usage
            Traveler traveler = new Traveler("Shashank");
            TravelerCompanion companion = new TravelerCompanion("Kushal");
            Admin admin = new Admin("Admin");

            Ride ride = new Ride("123", "Shashank", "1234567890", "ABC123");

            // Traveler shares ride details
            traveler.shareRideDetails(ride);

            // Companion tracks the ride
            companion.trackRide(ride);

            // Simulate ride completion
            ride.complete();

            // Companion receives notification
            companion.receiveNotification(true);

            // Companion shares feedback with Admin
            companion.shareFeedbackWithAdmin("Great experience!");

            // Admin adds the ride to their records
            admin.addRide(ride);

            // Admin accesses all rides and feedback
            admin.accessAllRides();
            admin.accessExperienceFeedback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
