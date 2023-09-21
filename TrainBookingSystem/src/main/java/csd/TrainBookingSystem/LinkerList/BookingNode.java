/**
 * 
 */
package csd.TrainBookingSystem.LinkerList;

import csd.TrainBookingSystem.Entity.Booking;
import csd.TrainBookingSystem.Entity.Customer;
import csd.TrainBookingSystem.Method.BookingMethod;

/**
 * @author QUANG TRUNG
 *
 */
public class BookingNode {

public Booking data;

public BookingNode next;

    public BookingNode() {
    }

    public BookingNode(Booking data, BookingNode next) {
        this.data = data;
        this.next = next;
    }

    public BookingNode(Booking x){this(x,null);};


}
