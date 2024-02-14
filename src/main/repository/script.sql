--SQL Script to store the required data of the system
/* Syntax for scripting remains same even if use GCP Cloud SQL, Amazon RDS or on-premise MySQL server, till the time SQL version and vendor are same in all places.*/
--Creating the main database:
CREATE DATABASE rideshare_db;
USE rideshare_db;
-- Create table to store rides
CREATE TABLE rides (
    trip_id INT AUTO_INCREMENT PRIMARY KEY,
    driver_name VARCHAR(100),
    driver_phone_number VARCHAR(20),
    cab_number VARCHAR(20),
    in_progress BOOLEAN
);
-- Create table to store users
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100),
    role ENUM('Traveler', 'TravelerCompanion', 'Admin')
);
-- Create table to store ride-user relationships
CREATE TABLE ride_users (
    ride_id INT,
    user_id INT,
    FOREIGN KEY (ride_id) REFERENCES rides(trip_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
-- Create table to store feedback
CREATE TABLE feedback (
    feedback_id INT AUTO_INCREMENT PRIMARY KEY,
    ride_id INT,
    user_id INT,
    feedback_text TEXT,
    FOREIGN KEY (ride_id) REFERENCES rides(trip_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
-- Create table to store notifications
CREATE TABLE notifications (
    notification_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    notification_text TEXT,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);