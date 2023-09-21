/**
 * 
 */
package csd.TrainBookingSystem.Method;

/**
 * @author QUANG TRUNG
 *
 */
public class TrainMethod {
 private TrainNode head;

    public TrainMethod() {
        head = null;
    }

    // 1.1. Load data from file
    public void loadDataFromFile(String filename) {
        // Implement code to read data from a file and populate the linked list
    }

    // 1.2. Input & add to the end
    public void addTrainToEnd(Train train) {
        TrainNode newNode = new TrainNode(train);
        if (head == null) {
            head = newNode;
        } else {
            TrainNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // 1.3. Display data
    public void displayData() {
        TrainNode current = head;
        while (current != null) {
            System.out.println(current.data.toString());
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
        if (head == null) {
            return;
        }
        if (head.data.getTcode().equals(tcode)) {
            head = head.next;
            return;
        }
        TrainNode current = head;
        while (current.next != null) {
            if (current.next.data.getTcode().equals(tcode)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

  
}

