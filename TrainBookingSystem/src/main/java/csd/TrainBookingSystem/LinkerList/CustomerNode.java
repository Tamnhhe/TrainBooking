/**
 * 
 */
package csd.TrainBookingSystem.LinkerList;

import csd.TrainBookingSystem.Entity.Customer;
import org.w3c.dom.Node;

/**
 * @author QUANG TRUNG
 *
 */
public class CustomerNode {

Customer info;

Node next;

CustomerNode() {};

CustomerNode(Customer x;Node q){info = x;next=q};

CustomerNode(Customer x){this(x,null);}




}
