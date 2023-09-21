package csd.TrainBookingSystem.Method;

import csd.TrainBookingSystem.Entity.Booking;
import csd.TrainBookingSystem.LinkerList.BookingNode;
import csd.TrainBookingSystem.Entity.Customer;
import csd.TrainBookingSystem.Entity.Train;
import csd.TrainBookingSystem.Method.CustomerMethod;
import csd.TrainBookingSystem.Method.TrainMethod;

import java.util.Scanner;

public class BookingMethod {
    BookingNode head;
    BookingNode tail;

    TrainMethod trainMethod;
    CustomerMethod customerMethod;

    public BookingMethod(TrainMethod trainMethod, CustomerMethod customerMethod) {
        this.trainMethod = trainMethod;
        this.customerMethod = customerMethod;
    }

    public void inputBookingData(Scanner scanner) {
        System.out.print("Enter train code: ");
        String tcode = scanner.nextLine();
        System.out.print("Enter customer code: ");
        String ccode = scanner.nextLine();
        System.out.print("Enter number of seats to be booked: ");
        int seatsToBook = Integer.parseInt(scanner.nextLine());

        Train train = trainMethod.searchTrainByTcode(tcode);
        Customer customer = customerMethod.searchCustomerByCcode(ccode);

        if (train == null || customer == null) {
            System.out.println("Train code or customer code not found. Data not accepted.");
            return;
        }

        if (isBookingExists(tcode, ccode)) {
            System.out.println("Booking already exists for this train and customer. Data not accepted.");
            return;
        }

        int availableSeats = train.getSeat() - train.getBooked();
        if (seatsToBook > availableSeats) {
            System.out.println("Train is exhausted. Data not accepted.");
            return;
        }

        if (seatsToBook <= availableSeats) {
            Booking booking = new Booking(tcode, ccode, seatsToBook);
            addBooking(booking);

            trainMethod.updateBookedSeats(tcode, seatsToBook);

            System.out.println("Booking added successfully.");
        }
    }

    private boolean isBookingExists(String tcode, String ccode) {
        BookingNode current = head;
        while (current != null) {
            if (current.data.getTcode().equals(tcode) && current.data.getCcode().equals(ccode)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void addBooking(Booking booking) {
        BookingNode newNode = new BookingNode(booking);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void displayBookingData() {
        BookingNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void sortByTcodeAndCcode() {
        if (head == null || head.next == null) {
            return;
        }

        BookingNode sortedHead = null;

        while (head != null) {
            BookingNode current = head;
            head = head.next;

            if (sortedHead == null || current.data.getTcode().compareTo(sortedHead.data.getTcode()) < 0 ||
                    (current.data.getTcode().equals(sortedHead.data.getTcode()) &&
                            current.data.getCcode().compareTo(sortedHead.data.getCcode()) < 0)) {
                current.next = sortedHead;
                sortedHead = current;
            } else {
                BookingNode temp = sortedHead;
                while (temp.next != null &&
                        (current.data.getTcode().compareTo(temp.next.data.getTcode()) > 0 ||
                                (current.data.getTcode().equals(temp.next.data.getTcode()) &&
                                        current.data.getCcode().compareTo(temp.next.data.getCcode()) > 0))) {
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }
        }

        head = sortedHead;
    }
}
