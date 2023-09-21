package csd.TrainBookingSystem;

import csd.TrainBookingSystem.LinkerList.BookingNode;
import csd.TrainBookingSystem.LinkerList.CustomerNode;
import csd.TrainBookingSystem.LinkerList.TrainNode;

import java.util.Scanner;

/**
 * Hello world!
 *
 */

public class App 
{
        Scanner sc = new Scanner(System.in);
    public static void main( String[] args )
    {
        TrainNode trainHead = null;
        CustomerNode customerHead = null;
        BookingNode bookingHead = null;




    }

    public void menu(){
        boolean menucheck=true;
        do {
            System.out.println("TRAIN BOOKING SYSTEM\n" +
                    "1. Train list\n" +
                    "2. Customer list\n" +
                    "3. Booking list");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1: 
            }


        }while(menucheck);
    }

}
