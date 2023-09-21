package csd.TrainBookingSystem.Method;

import csd.TrainBookingSystem.Entity.Customer;
import csd.TrainBookingSystem.LinkerList.CustomerNode;

import java.io.*;
import java.util.Scanner;

public class CustomerMethod {
    ;
    CustomerNode tail;

    // Method to input customer information from a file
    public void loadDataFromFile(String fileName,CustomerNode head) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                // Parse the line to extract customer information
                String[] parts = line.split("-");
                if (parts.length >= 3) {
                    String ccode = parts[0].trim();
                    String name = parts[1].trim();
                    String phone = parts[2].trim();
                    // Create a new Customer object and add it to the list
                    Customer customer = new Customer(ccode, name, phone);
                    addCustomer(customer, head);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void inputAndAddCustomer() {
        Scanner scanner = new Scanner(System.in);

<<<<<<< HEAD
    // Method to add a customer to the end of the list
    public void addCustomer(Customer customer,CustomerNode head) {
=======
        System.out.print("Enter ccode: ");
        String ccode = scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(ccode, name, phone);
        addCustomer(customer);

        System.out.println("Customer added successfully.");
    }

    // ...






// Method to add a customer to the end of the list
    public void addCustomer(Customer customer) {
>>>>>>> e96fd5595bd06cc0a59fb131557f9554ccf76db8
        CustomerNode newNode = new CustomerNode(customer);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Method to display customer data
    public void displayCustomers(CustomerNode head) {
        CustomerNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Method to save the customer list to a file
    public void saveCustomersToFile(String fileName,CustomerNode head) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            CustomerNode current = head;
            while (current != null) {
                writer.write(current.data.toString());
                writer.newLine();
                current = current.next;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to search for a customer by ccode
    public Customer searchCustomerByCcode(String ccode,CustomerNode head) {
        CustomerNode current = head;
        while (current != null) {
            if (current.data.getCcode().equals(ccode)) {
                return current.data;
            }
            current = current.next;
        }
        return null; // Customer not found
    }

    // Method to delete a customer by ccode
    public void deleteCustomerByCcode(String ccode,CustomerNode head) {
        if (head == null) {
            return; // No customers in the list
        }

        if (head.data.getCcode().equals(ccode)) {
            // If the customer to delete is the first node
            head = head.next;
            if (head == null) {
                tail = null; // If the list becomes empty, update the tail
            }
            return;
        }

        CustomerNode current = head;
        while (current.next != null) {
            if (current.next.data.getCcode().equals(ccode)) {
                current.next = current.next.next;
                if (current.next == null) {
                    tail = current; // If the last customer is deleted, update the tail
                }
                return;
            }
            current = current.next;
        }
    }
}
