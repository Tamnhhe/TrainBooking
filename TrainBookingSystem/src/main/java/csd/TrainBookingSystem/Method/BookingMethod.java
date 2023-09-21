package csd.TrainBookingSystem.Method;

import csd.TrainBookingSystem.Entity.Booking;
import csd.TrainBookingSystem.LinkerList.BookingNode;
import csd.TrainBookingSystem.Entity.Customer;
import csd.TrainBookingSystem.Entity.Train;
import csd.TrainBookingSystem.LinkerList.CustomerNode;
import csd.TrainBookingSystem.LinkerList.TrainNode;
import csd.TrainBookingSystem.Method.CustomerMethod;
import csd.TrainBookingSystem.Method.TrainMethod;

import java.util.Scanner;

public class BookingMethod {
    BookingNode head;
    BookingNode tail;

    TrainMethod trainMethod;
    CustomerMethod customerMethod;
    Scanner scanner;

    public BookingMethod(TrainMethod trainMethod, CustomerMethod customerMethod) {
        this.trainMethod = trainMethod;
        this.customerMethod = customerMethod;
        this.scanner = new Scanner(System.in);
    }

    public BookingNode inputBookingData(TrainNode trainhead, CustomerNode customerHead, BookingNode bookingHead) {
        boolean checktcode = false;
        String tcode = "";
        String ccode = "";
        do {
            System.out.println("Enter train code:");
            tcode = scanner.nextLine().toUpperCase();
            TrainNode p = trainhead;

            while (p != null) {
                if (p.data.getTcode().equals(tcode)) ;
                checktcode = false;
                p = p.next;
            }
            if (checktcode) {
                System.out.println("Cant find this Tcode!");
            }
        } while (checktcode);
        boolean checkccode = false;
        do {
            System.out.println("Enter customer code:");
            ccode = scanner.nextLine().toUpperCase();
            CustomerNode q = customerHead;

            while (q != null) {
                if (q.data.getCcode().equals(tcode)) ;
                checkccode = false;
                q = q.next;
            }
            if (checkccode) {
                System.out.println("Cant find this Tcode!");
            }
        } while (checkccode);
        System.out.println("Enter number of seats to be booked:");
        int seatsToBook = Integer.parseInt(scanner.nextLine());

        Train train = trainMethod.searchByTcode(trainhead, tcode);
        Customer customer = customerMethod.searchCustomerByCcode(ccode, customerHead);

        if (train == null || customer == null) {
            System.out.println("Train code or customer code not found. Data not accepted.");
            return bookingHead;
        }

        if (isBookingExists(tcode, ccode)) {
            System.out.println("Booking already exists for this train and customer. Data not accepted.");
            return bookingHead;
        }

        int availableSeats = train.getSeat() - train.getBooked();
        if (seatsToBook > availableSeats) {
            System.out.println("Train is exhausted. Data not accepted.");
            return bookingHead;
        }

        if (seatsToBook <= availableSeats) {
            Booking booking = new Booking(tcode, ccode, seatsToBook);
            bookingHead = addBooking(booking);

            trainMethod.updateBookedSeats(tcode, seatsToBook, trainhead);

            System.out.println("Booking added successfully.");
        }
        return bookingHead;
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

    public BookingNode addBooking(Booking booking) {
        BookingNode newNode = new BookingNode(booking);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        return head;
    }

    public void displayBookingData() {
        BookingNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public BookingNode sortByTcodeAndCcode(BookingNode head) {
        if (head == null || head.next == null) {
            return head;
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
        return head;
    }
}
