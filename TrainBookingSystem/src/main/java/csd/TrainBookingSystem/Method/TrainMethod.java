/**
 * 
 */
package csd.TrainBookingSystem.Method;

import csd.TrainBookingSystem.Entity.Train;
import csd.TrainBookingSystem.LinkerList.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author QUANG TRUNG
 *
 */
public class TrainMethod {
    TrainNode tail;

    public TrainMethod() {
        tail = null;
    }
    public void displayTrainListmenu() {
    	
    }
    // 1.1. Load data from file
    public void loadDataFromFile(String filename, TrainNode head) throws FileNotFoundException {
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
                    addTrainToEnd(head,train);
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 1.2. Input & add to the end
    public void addTrainToEnd(TrainNode head,Train train) {
        TrainNode q = new TrainNode(train);
        if(head==null) {head=tail=q;return;}
        tail.next = q;
        tail = q;      
    }

    // 1.3. Display data
    public void displayData(TrainNode head) {
        TrainNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

   
    public void saveDataToFile(String filename) {
       
    }

    
    public Train searchByTcode(TrainNode head,String tcode) {
        TrainNode current = head;
        while (current != null) {
            if (current.data.getTcode().equals(tcode)) {
                return current.data;
            }
            current = current.next;
        }
        return null; 
    }

    
    public void deleteByTcode(TrainNode head,String tcode) {
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
    
    public void sortByTcode(TrainNode head) {
    	TrainNode current = head, index = null;
        Train temp;

        if (head == null) {
            return;
        }
        else {
            while (current != null) {

                index = current.next;

                while (index != null) {


                    if (current.data.getTcode().compareTo(index.data.getTcode())>0) {
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
    public void addAfter(TrainNode head,TrainNode q, int k)    {
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
    
    public void deleteBefore(TrainNode head,String xcode) {
    	TrainNode current=head,q=null;
        while (current.next != null) {    		
    		if(current.next.data.getTcode().compareTo(xcode)>0) {
    			q=current;
    			break;
    		}
    		current=current.next;
    	}
        if (q == null) {
         return; // Make sure q is not null
     }
         if (q == head) {
         head = head.next;
         if (head == null) {
             tail = null; // If list is empty after removal
         }
         } else {
         TrainNode p = head;
         while (p != null && p.next != q) {
             p = p.next;
         }
         if (p != null) {
             p.next = q.next;
             if (q == tail) {
                 tail = p; // Update tail if q is the last node
             }
         }
     }
    }
}

