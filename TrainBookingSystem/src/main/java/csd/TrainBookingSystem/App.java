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

        boolean menucheck = true;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("TRAIN BOOKING SYSTEM\n" +
                    "1. Train list\n" +
                    "2. Customer list\n" +
                    "3. Booking list\n"+
                    "4. Exit\n");
            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        trainHead = m.trainmenu(trainHead);
                        break;
                    case 2:
                        customerHead = m.customermenu(customerHead);
                        break;
                    case 3:
                        bookingHead =m.bookingmenu(trainHead,customerHead,bookingHead);
                        break;
                    case 4:
                        menucheck = false;
                    default:
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter the number!");
            }


        } while (menucheck);


    }


}


