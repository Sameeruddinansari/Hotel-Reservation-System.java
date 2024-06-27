package CodeAlpha_Tasks;

import java.util.ArrayList;
import java.util.Scanner;

// Main class to run the hotel reservation system

public class HotelRoomReservation_Task_3 {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.addRoom(101, "Single", true);
        hotel.addRoom(102, "Double", true);
        hotel.addRoom(103, "Triple", true);
        hotel.addRoom(104, "Suite", true);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Hotel Reservation System");
            System.out.println("1. Show available rooms");
            System.out.println("2. Book a room");
            System.out.println("3. View bookings");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            sc.nextLine(); // for newline

            switch (option) {
                case 1:
                    hotel.showAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter room number: ");
                    int roomNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter customer name: ");
                    String customerName = sc.nextLine();
                    hotel.bookRoom(roomNumber, customerName);
                    break;
                case 3:
                    hotel.showBookings();
                    break;
                case 4:
                    System.out.println("Exiting system.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}


// Class representing a hotel room
    class Room {
        int roomNumber;
        String roomType;
        boolean isAvailable;

        // Constructor to initialize room properties
        public Room(int roomNumber, String roomType, boolean isAvailable) {
            this.roomNumber = roomNumber;
            this.roomType = roomType;
            this.isAvailable = isAvailable;
        }

        // Method to display room details
        public void displayRoom() {
            System.out.println("Room Number: " + roomNumber + ", Type: " + roomType + ", Available: " + isAvailable);
        }
    }

    // Class representing a booking made by a customer
    class Booking {
        int roomNumber;
        String customerName;

        // Constructor to initialize booking properties
        public Booking(int roomNumber, String customerName) {
            this.roomNumber = roomNumber;
            this.customerName = customerName;
        }

        // Method to display booking details
        public void displayBooking() {
            System.out.println("Room Number: " + roomNumber + ", Customer Name: " + customerName);
        }
    }

    // Class representing the hotel which contains rooms and manages bookings
    class Hotel {
        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        // Method to add a new room to the hotel
        public void addRoom(int roomNumber, String roomType, boolean isAvailable) {
            rooms.add(new Room(roomNumber, roomType, isAvailable));
        }

        // Method to show all available rooms
        public void showAvailableRooms() {
            for (Room room : rooms) {
                if (room.isAvailable) {
                    room.displayRoom();
                }
            }
        }

        // Method to book a room
        public void bookRoom(int roomNumber, String customerName) {
            for (Room room : rooms) {
                if (room.roomNumber == roomNumber && room.isAvailable) {
                    room.isAvailable = false;  // Set room to not available
                    bookings.add(new Booking(roomNumber, customerName)); // Add booking
                    System.out.println(customerName + " Your " +"Room are booked successfully!");
                    return;
                }
            }
            System.out.println("Room not available! This Room Are Already Book For : " + customerName);
        }

        // Method to show all bookings
        public void showBookings() {
            for (Booking booking : bookings) {
                booking.displayBooking();
            }
        }
    }


