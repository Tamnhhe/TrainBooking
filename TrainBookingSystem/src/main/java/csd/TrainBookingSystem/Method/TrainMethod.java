/**
 *
 */
package csd.TrainBookingSystem.Method;

import csd.TrainBookingSystem.Entity.Train;
import csd.TrainBookingSystem.LinkerList.*;

import java.io.*;
import java.util.Scanner;

/**
 * @author QUANG TRUNG
 */
public class TrainMethod {

    Scanner sc = new Scanner(System.in);


    public Train inputTrain() {
        System.out.println("Input train code:");
        String tcode = sc.nextLine();
        System.out.println("Input train name:");
        String trainName = sc.nextLine();
        System.out.println("Input number of seat:");
        int seat = Integer.parseInt(sc.nextLine());
        System.out.println("Input number of seat has been booked:");
        int booked = Integer.parseInt(sc.nextLine());
        System.out.println("Input train depart time:");
        double departTime = Double.parseDouble(sc.nextLine());
        System.out.println("Input train depart place:");
        String departPlace = sc.nextLine();
        return new Train(tcode, trainName, seat, booked, departTime, departPlace);
    }

    // 1.1. Load data from file
    public TrainNode loadDataFromFile(String filename, TrainNode head) {
        // Implement code to read data from a file and populate the linked list

        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length == 6) {
                    String tcode = parts[0].trim();
                    String train_name = parts[1].trim();
                    int seat = Integer.parseInt(parts[2].trim());
                    int booked = Integer.parseInt(parts[3].trim());
                    double depart_time = Double.parseDouble(parts[4].trim());
                    String depart_place = parts[5].trim();

                    Train train = new Train(tcode, train_name, seat, booked, depart_time, depart_place);
                    addTrainToEnd(head, train);
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return head;
    }

    // 1.2. Input & add to the end
    public TrainNode addTrainToEnd(TrainNode head, Train train) {
        TrainNode q = new TrainNode(train);
        TrainNode p = head;
        if (head == null) {

            head = q;
            return head;
        } else {
            while (p != null) {
                p = p.next;
            }
            p = q;
            return head;
        }


    }


    // 1.3. Display data
    public void displayData(TrainNode head) {
        TrainNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void saveDataToFile(String filename, TrainNode head) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            TrainNode current = head;
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

    public Train searchByTcode(TrainNode head, String tcode) {
        TrainNode current = head;
        while (current != null) {
            if (current.data.getTcode().equals(tcode)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public TrainNode deleteByTcode(TrainNode head, String tcode) {
        TrainNode p = head;
        TrainNode prev = null;

        while (p != null && !p.data.getTcode().equals(tcode)) {
            prev = p;
            p = p.next;
        }
        if (p == null) {
            return head;
        }
        if (p == head) {
            head = head.next;
        } else {
            prev.next = p.next;
        }
        return head;
    }

    public TrainNode sortByTcode(TrainNode head) {
        TrainNode current = head, index = null;
        Train temp;

        if (head == null) {
            return head;
        } else {
            while (current != null) {

                index = current.next;

                while (index != null) {

                    if (current.data.getTcode().compareTo(index.data.getTcode()) > 0) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }

                    index = index.next;
                }
                current = current.next;
            }
        }
        return head;
    }

    public TrainNode addAfter(TrainNode head, TrainNode q, int k) {
        TrainNode current = head, newNode = new TrainNode();
        int i = 0;
        while (current != null) {
            if (i == k) {
                newNode = current;
                break;
            }
            i++;
            current = current.next;
        }
        {
            if (q == null) {
                return head; // Make sure q is not null
            }

            if (q == head) {
                newNode.next = head;
                head = newNode;
            } else {
                TrainNode p = head;
                while (p != null && p.next != q) {
                    p = p.next;
                }
                if (p != null) {
                    newNode.next = q;
                    p.next = newNode;
                }
            }
        }
        return head;
    }

    public TrainNode deleteBefore(TrainNode head, String xcode) {
        TrainNode current = head, q = null;
        while (current.next != null) {
            if (current.next.data.getTcode().compareTo(xcode) > 0) {
                q = current;
                break;
            }
            current = current.next;
        }
        if (q == null) {
            return head; // Make sure q is not null
        }
        if (q == head) {
            head = head.next;
        } else {
            TrainNode p = head;
            while (p != null && p.next != q) {
                p = p.next;
            }
        }
        return head;
    }
   public void updateBookedSeats(String tcode, int seatsToBook) {
//        TrainNode current = head;
//        while (current != null) {
//            if (current.data.getTcode().equals(tcode)) {
//                int currentBooked = current.data.getBooked();
//                current.data.setBooked(currentBooked + seatsToBook);
//                return; // Exit the loop after updating the booked seats
//            }
//            current = current.next;
//        }
    }
}
