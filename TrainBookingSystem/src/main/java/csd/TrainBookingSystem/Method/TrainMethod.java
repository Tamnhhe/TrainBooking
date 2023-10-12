/**
 *
 */
package csd.TrainBookingSystem.Method;

import csd.TrainBookingSystem.Entity.Train;
import csd.TrainBookingSystem.LinkerList.*;

import java.io.*;
import java.util.Scanner;

import static Validate.Validate.getDouble;
import static Validate.Validate.getInteger;

/**
 * @author QUANG TRUNG
 */
public class TrainMethod {

    Scanner sc = new Scanner(System.in);
<<<<<<< HEAD
    
    public boolean checktcode(TrainNode head,String tcode) {
    	boolean check=true;
    	while(head!=null) {
    		if(head.data.getTcode()==tcode) return false;
    		head=head.next;
    	}
    	return check;
    }
    public String inputTcode(TrainNode head) {
    	String tcode;
    	while(true) {    		
    			tcode=sc.nextLine().trim();
    			if(tcode.isEmpty()) System.out.println("Please not enter an empty train code.");
    			else if(checktcode(head, tcode)) return tcode;    		
    			else System.out.println("Train code already existed.");
    	}
    }
    
    public String inputString() {
    	String s;
    	while(true) {    		
    			s=sc.nextLine().trim();
    			if(s.isEmpty()) System.out.println("Please not enter an empty train code.");
    			else return s;    		  			
    	}
    }
    
    public int inputSeat() {
    	int seat;
    	while(true) {
    		try {
    			seat=Integer.parseInt(sc.nextLine().trim());
    			if(seat<0) System.out.println("Please enter number of seats larger then 0");
    			else return seat;    		  			
    	        }catch(NumberFormatException e) {
    	        	System.out.println("Please enter a integer number that larger then 0");
    	        }
    	}
    }
    
    public int inputSeatBooked(int seat) {
    	int seatbooked;
    	while(true) {
    		try {
    			seatbooked=Integer.parseInt(sc.nextLine().trim());
    			if(seatbooked<=0) System.out.println("Please enter number of seats larger or equal to 0");
    			else if(seatbooked>seat) System.out.println("Number of seat had been booked can't larger then number of seat."); 
    			else return seatbooked;    		  			
    	        }catch(NumberFormatException e) {
    	        	System.out.println("Please enter a integer number that larger or equal to 0");
    	        }
    	}
    }
    
    public double inputDepartTime() {
    	double time;
    	while(true) {
    		try {
    			time=Double.parseDouble(sc.nextLine());
    			if(time<=0) System.out.println("Please enter number of seats larger or equal to 0");
    			else return time;    		  			
    	        }catch(NumberFormatException e) {
    	        	System.out.println("Please enter a double number that larger or equal to 0");
    	        }
    	}
    }
    
    public Train inputTrain(TrainNode head) {
=======



    public Train inputTrain() {
>>>>>>> origin/main
        System.out.println("Input train code:");
        String tcode = inputTcode(head);
        System.out.println("Input train name:");
        String trainName = inputString();
        System.out.println("Input number of seat:");
<<<<<<< HEAD
        int seat = inputSeat();
        System.out.println("Input number of seat has been booked:");
        int booked = inputSeatBooked(seat);
        System.out.println("Input train depart time:");
        double departTime = inputDepartTime();
=======
        int seat = getInteger();
        System.out.println("Input number of seat has been booked:");
        int booked = getInteger();
        System.out.println("Input train depart time:");
        double departTime = getDouble();
>>>>>>> origin/main
        System.out.println("Input train depart place:");
        String departPlace = inputString();
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
                    head = addTrainToEnd(head, train);
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
            while (p.next != null) {
                p = p.next;
            }
            p.next = q;
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

    public TrainNode updateBookedSeats(String tcode, int seatsToBook,TrainNode head) {
        TrainNode current = head;
        while (current != null) {
            if (current.data.getTcode().equals(tcode)) {
                int currentBooked = current.data.getBooked();
                current.data.setBooked(currentBooked + seatsToBook);
                return head; // Exit the loop after updating the booked seats
            }
            current = current.next;
        }
        return head;
    }
}
