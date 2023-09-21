/**
 * 
 */
package csd.TrainBookingSystem.LinkerList;
/**
 * @author QUANG TRUNG
 *
 */
import csd.TrainBookingSystem.Entity.Train;
public class TrainNode {
    public Train data;
    public TrainNode next;

    public TrainNode() {
    	
    }
    // Constructor
    public TrainNode(Train data) {
    	this(data,null);
    }
    public TrainNode(Train data,TrainNode next) {
        this.data = data;
        this.next = next;
    }
    
}
