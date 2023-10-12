package csd.TrainBookingSystem;

import csd.TrainBookingSystem.Entity.Train;
import csd.TrainBookingSystem.LinkerList.BookingNode;
import csd.TrainBookingSystem.LinkerList.CustomerNode;
import csd.TrainBookingSystem.LinkerList.TrainNode;
import csd.TrainBookingSystem.Method.BookingMethod;
import csd.TrainBookingSystem.Method.CustomerMethod;
import csd.TrainBookingSystem.Method.TrainMethod;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {

    TrainMethod trainMethod = new TrainMethod();
    CustomerMethod customerMethod = new CustomerMethod();
    BookingMethod bookingMethod = new BookingMethod(trainMethod, customerMethod);


    public TrainNode trainmenu(TrainNode trainHead) throws FileNotFoundException {
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

                switch (choice) {
                    case 1:
                        trainHead = trainMethod.loadDataFromFile("train.txt", trainHead);
                        trainmenucheck = false;
                        break;
                    case 2:
                        trainHead = trainMethod.addTrainToEnd(trainHead, trainMethod.inputTrain(trainHead));
                        trainmenucheck = false;
                        break;
                    case 3:
                        trainMethod.displayData(trainHead);
                        trainmenucheck = false;
                        break;
                    case 4:
                        trainMethod.saveDataToFile("train.txt", trainHead);
                        trainmenucheck = false;
                        break;
                    case 5:
                        System.out.println("Enter the tcode:");
                        String tcode = sc.nextLine();
                        if (trainMethod.searchByTcode(trainHead, tcode) != null) {
                            System.out.println(trainMethod.searchByTcode(trainHead, tcode).toString());
                        } else {
                            System.out.println("Cant found!");
                        }
                        trainmenucheck = false;
                        break;
                    case 6:
                        System.out.println("Enter the tcode:");
                        tcode = sc.nextLine();
                        if (trainMethod.searchByTcode(trainHead, tcode) != null) {
                            trainHead = trainMethod.deleteByTcode(trainHead, tcode);
                        } else {
                            System.out.println("Cant found!");
                        }
                        trainmenucheck = false;
                        break;
                    case 7:
                        trainHead = trainMethod.sortByTcode(trainHead);
                        trainMethod.displayData(trainHead);
                        trainmenucheck = false;
                        break;
                    case 8:
                        Train train = trainMethod.inputTrain(trainHead);
                        System.out.println("Enter the k:");
                        int k = Integer.parseInt(sc.nextLine());
                        trainHead = trainMethod.addAfter(trainHead, new TrainNode(train), k);
                        trainmenucheck = false;
                        break;
                    case 9:
                        System.out.println("Enter the xcode:");
                        String xcode = sc.nextLine();
                        trainHead = trainMethod.deleteBefore(trainHead, xcode);
                        trainmenucheck = false;
                    default:
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter the number!");
            }
        } while (trainmenucheck);
        return trainHead;
    }

    public CustomerNode customermenu(CustomerNode customerHead) throws FileNotFoundException {
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

                switch (choice) {
                    case 1:
                        customerHead = customerMethod.loadDataFromFile("customer.txt", customerHead);
                        customermenucheck = false;
                        break;
                    case 2:
                        customerHead = customerMethod.addCustomer(customerMethod.inputCustomer(), customerHead);
                        customermenucheck = false;
                        break;
                    case 3:
                        customerMethod.displayCustomers(customerHead);
                        customermenucheck = false;
                        break;
                    case 4:
                        customerMethod.saveDataToFile("customer.txt", customerHead);
                        customermenucheck = false;
                        break;
                    case 5:
                        System.out.println("Enter the ccode:");
                        String ccode = sc.nextLine();
                        if (customerMethod.searchCustomerByCcode(ccode, customerHead) != null) {
                            System.out.println(customerMethod.searchCustomerByCcode(ccode, customerHead).toString());
                        } else {
                            System.out.println("Cant found!");
                        }
                        customermenucheck = false;
                        break;
                    case 6:
                        System.out.println("Enter the ccode:");
                        ccode = sc.nextLine();
                        if (customerMethod.searchCustomerByCcode(ccode, customerHead) != null) {
                            customerHead = customerMethod.deleteCustomerByCcode(ccode, customerHead);
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
        return customerHead;
    }

    public BookingNode bookingmenu(TrainNode trainHead, CustomerNode customerHead, BookingNode bookingHead) {
        Scanner sc = new Scanner(System.in);
        boolean bookingmenucheck = true;

        do {
            System.out.println("BOOKING LIST:\n" +
                    "1. Input data \n" +
                    "2. Display booking data \n" +
                    "3. Sort by tcode + code ");
            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        bookingHead = bookingMethod.inputBookingData(trainHead, customerHead, bookingHead);
                        bookingmenucheck = false;
                        break;
                    case 2:
                        bookingMethod.displayBookingData();
                        bookingmenucheck = false;
                        break;
                    case 3:
                        bookingHead = bookingMethod.sortByTcodeAndCcode(bookingHead);
                        bookingmenucheck = false;
                        break;
                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter the number!");
            }
        } while (bookingmenucheck);
        return bookingHead;
    }

}
