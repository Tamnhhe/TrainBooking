package csd.TrainBookingSystem;

import csd.TrainBookingSystem.LinkerList.BookingNode;
import csd.TrainBookingSystem.LinkerList.CustomerNode;
import csd.TrainBookingSystem.LinkerList.TrainNode;
import csd.TrainBookingSystem.Method.TrainMethod;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Hello world!
 */

public class App {


    public static void main(String[] args) throws FileNotFoundException {
        TrainNode trainHead = null;
        CustomerNode customerHead = null;
        BookingNode bookingHead = null;
        Menu m = new Menu();
        m.menu(trainHead,customerHead,bookingHead);


    }


}


