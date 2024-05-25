import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Room {
    private int roomNumber;
    public String roomType;
    public boolean isAvailable;

    public Room(int roomNumber, String roomType, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isAvailable = isAvailable;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}

class Reservation {
    private int reservationId;
    private Room bookedRoom;
    private String guestName;
    private String mobileNumber;

    public Reservation(int reservationId, Room bookedRoom, String guestName, String mobileNumber) {
        this.reservationId = reservationId;
        this.bookedRoom = bookedRoom;
        this.guestName = guestName;
        this.mobileNumber = mobileNumber;
    }

    public int getReservationId() {
        return reservationId;
    }

    public Room getBookedRoom() {
        return bookedRoom;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
}

public class HotelReservationSystem {
    private List<Room> rooms;
    private List<Reservation> reservations;
    private int nextReservationId;

    public HotelReservationSystem() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        nextReservationId = 1;
        rooms.add(new Room(101, "Single", true));
        rooms.add(new Room(102, "Double", true));
        rooms.add(new Room(103, "Suite", true));
    }

    public void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println("Room " + room.getRoomNumber() + " (" + room.roomType + ")");
            }
        }
    }

    public void makeReservation(String guestName, String mobileNumber, int roomNumber) {
        Room selectedRoom = rooms.get(roomNumber - 101);
        if (selectedRoom.isAvailable()) {
            Reservation reservation = new Reservation(nextReservationId++, selectedRoom, guestName, mobileNumber);
            reservations.add(reservation);
            selectedRoom.isAvailable = false; // Mark room as booked
            System.out.println("Reservation successful! Reservation ID: " + reservation.getReservationId());
        } else {
            System.out.println("Room not available.");
        }
    }

    public static void main(String[] args) {
        HotelReservationSystem hotel = new HotelReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. View available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hotel.displayAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    scanner.nextLine(); // Consume newline
                    String guestName = scanner.nextLine();
                    System.out.print("Enter your mobile number: ");
                    String mobileNumber = scanner.next();
                    System.out.print("Enter room number (101, 102, 103): ");
                    int roomNumber = scanner.nextInt();
                    hotel.makeReservation(guestName, mobileNumber, roomNumber);
                    break;
                case 3:
                    System.out.println("Thank you for using our reservation system!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}