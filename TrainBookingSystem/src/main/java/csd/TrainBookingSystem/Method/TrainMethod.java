/**
 * 
 */
package csd.TrainBookingSystem.Method;

import csd.TrainBookingSystem.Entity.Train;
import csd.TrainBookingSystem.LinkerList.*;

/**
 * @author QUANG TRUNG
 *
 */
public class TrainMethod {
    TrainNode head;
    TrainNode tail;

    public TrainMethod() {
        head = null;
        tail = null;
    }
    public void displayTrainListmenu() {
    	
    }
    // 1.1. Load data from file
    public void loadDataFromFile(String filename) {
        // Implement code to read data from a file and populate the linked list
    }

    // 1.2. Input & add to the end
    public void addTrainToEnd(Train train) {
        TrainNode q = new TrainNode(train);
        if(head==null) {head=tail=q;return;}
        tail.next = q;
        tail = q;      
    }

    // 1.3. Display data
    public void displayData() {
        TrainNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

   
    public void saveDataToFile(String filename) {
       
    }

    
    public Train searchByTcode(String tcode) {
        TrainNode current = head;
        while (current != null) {
            if (current.data.getTcode().equals(tcode)) {
                return current.data;
            }
            current = current.next;
        }
        return null; 
    }

    
    public void deleteByTcode(String tcode) {
        TrainNode p = head;
        TrainNode prev = null;

        while (p != null && !p.data.getTcode().equals(tcode)) {
            prev = p;
            p = p.next;
        }
        if (p == null) {
            return;
        }
        if (p == head) {
            head = head.next;
            if (head == null) {
                tail = null; 
            }
        } else {
            prev.next = p.next;
            if (p == tail) {
                tail = prev; 
            }
        }
    }
    
    public void sortByTcode() {
    	TrainNode current = head, index = null;
        Train temp;

        if (head == null) {
            return;
        }
        else {
            while (current != null) {

                index = current.next;

                while (index != null) {

                    if (current.data.getTcode().compareTo(index.data.getTcode())>1) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }

                    index = index.next;
                }
                current = current.next;
            }
        }	
    }    
    public void addAfter(TrainNode q, int k)    {
    	TrainNode current=head, newNode=new TrainNode();
    	int i=0;
    	while (current != null) {    		
    		if(i==k) {
    			newNode=current;
    			break;
    		}
    		i++;
    		current=current.next;
    	}
    	{if (q == null) {
            return; // Make sure q is not null
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
    }
    
    public void deleteBefore(int xcode) {
    	TrainNode current=head;
    }
}

