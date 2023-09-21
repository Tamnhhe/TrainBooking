package csd.TrainBookingSystem;

import csd.TrainBookingSystem.Entity.Train;
import csd.TrainBookingSystem.LinkerList.BookingNode;
import csd.TrainBookingSystem.LinkerList.CustomerNode;
import csd.TrainBookingSystem.LinkerList.TrainNode;
import csd.TrainBookingSystem.Method.CustomerMethod;
import csd.TrainBookingSystem.Method.TrainMethod;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
    public void menu(TrainNode trainhead, CustomerNode customerhead, BookingNode bookinghead) throws FileNotFoundException {
        boolean menucheck = true;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("TRAIN BOOKING SYSTEM\n" +
                    "1. Train list\n" +
                    "2. Customer list\n" +
                    "3. Booking list");
            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        trainmenu(trainhead);
                        break;
                    case 2:
                        customermenu(customerhead);
                        break;
                    case 3:
                    case 4:
                    default:
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter the number!");
            }


        } while (menucheck);
    }

    public void trainmenu(TrainNode trainhead) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        boolean trainmenucheck = true;
        do {
            System.out.println("TRAIN LIST:\n" +
                    "1. Load data from file\n" +
                    "2. Input and add to the end\n" +
                    "3. Display data\n" +
                    "4. Save train list to file\n" +
                    "5. Search by tcode\n" +
                    "6. Delete by tcode\n" +
                    "7. Sort by tcode\n" +
                    "8. Add after position k\n" +
                    "9. Delete the node before the node having tcode = xCode\t");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                TrainMethod trainMethod = new TrainMethod();
                switch (choice) {
                    case 1:
                        trainMethod.loadDataFromFile("train.txt", trainhead);
                        break;
                    case 2:

                    case 3:
                        trainMethod.displayData(trainhead);
                        break;
                    case 4:
                        trainMethod.saveDataToFile("train.txt", trainhead);
                        break;
                    case 5:
                        System.out.println("Enter the tcode:");
                        String tcode = sc.nextLine();
                        if (trainMethod.searchByTcode(trainhead, tcode) != null) {
                            System.out.println(trainMethod.searchByTcode(trainhead, tcode).toString());
                        } else {
                            System.out.println("Cant found!");
                        }
                        break;
                    case 6:
                        System.out.println("Enter the tcode:");
                        tcode = sc.nextLine();
                        if (trainMethod.searchByTcode(trainhead, tcode) != null) {
                            trainMethod.deleteByTcode(trainhead, tcode);
                        } else {
                            System.out.println("Cant found!");
                        }
                        break;
                    case 7:
                        trainMethod.sortByTcode(trainhead);
                        trainMethod.displayData(trainhead);
                        break;
                    case 8:
                        Train train = trainMethod.inputTrain();
                        System.out.println("Enter the k:");
                        int k = Integer.parseInt(sc.nextLine());
                        trainMethod.addAfter(trainhead, new TrainNode(train), k);
                        break;
                    case 9:
                    default:
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter the number!");
            }
        } while (trainmenucheck);

    }

    public void customermenu(CustomerNode customerhead) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        boolean customermenucheck = true;
        do {
            System.out.println("CUSTOMER LIST:\n" +
                    "1. Load data from file \n" +
                    "2. Input & add to the end \n" +
                    "3. Display data \n" +
                    "4. Save customer list to file \n" +
                    "5. Search by ccode \n" +
                    "6. Delete by ccode ");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                CustomerMethod customerMethod = new CustomerMethod();
                switch (choice) {
                    case 1:
                        customerhead = customerMethod.loadDataFromFile("customer.txt", customerhead);
                        customermenucheck = false;
                        break;
                    case 2:
                        customerhead = customerMethod.addCustomer(customerMethod.inputCustomer(), customerhead);
                        customermenucheck = false;
                        break;
                    case 3:
                        customerMethod.displayCustomers(customerhead);
                        customermenucheck = false;
                        break;
                    case 4:
                        customerMethod.saveDataToFile("customer.txt", customerhead);
                        customermenucheck = false;
                        break;
                    case 5:
                        System.out.println("Enter the ccode:");
                        String ccode = sc.nextLine();
                        if (customerMethod.searchCustomerByCcode(ccode, customerhead) != null) {
                            System.out.println(customerMethod.searchCustomerByCcode(ccode, customerhead).toString());
                        } else {
                            System.out.println("Cant found!");
                        }
                        customermenucheck = false;
                        break;
                    case 6:
                        System.out.println("Enter the ccode:");
                        ccode = sc.nextLine();
                        if (customerMethod.searchCustomerByCcode(ccode, customerhead) != null) {
                           customerhead = customerMethod.deleteCustomerByCcode(ccode, customerhead);
                        } else {
                            System.out.println("Cant found!");
                        }
                        customermenucheck = false;
                        break;
                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter the number!");
            }
        } while (customermenucheck);

    }
}
