// Spring-Boot Based Database Manipulation
package src.main.model;
import src.main.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RideService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RideService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertRide(Ride ride) {
        jdbcTemplate.update("INSERT INTO rides (driver_name, driver_phone_number, cab_number, in_progress) VALUES (?, ?, ?, ?)",
                ride.getDriverName(), ride.getDriverPhoneNumber(), ride.getCabNumber(), ride.isInProgress());
    }
    public void insertUser(User user) {
        jdbcTemplate.update("INSERT INTO users (username, email, password) VALUES (?, ?, ?)",
                user.getUsername(), user.getEmail(), user.getPassword());
    }

    // Other methods to interact with the database could be also added similarly
}
