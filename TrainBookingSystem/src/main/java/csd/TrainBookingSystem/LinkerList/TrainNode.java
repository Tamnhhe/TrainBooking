/**
 * 
 */
package csd.TrainBookingSystem.LinkerList;

/**
 * @author QUANG TRUNG
 *
 */
public class TrainNode {
private Train data;
    private TrainNode next;
    
    // Constructor
    public TrainNode(Train data) {
        this.data = data;
        this.next = null;
    }
    
}
