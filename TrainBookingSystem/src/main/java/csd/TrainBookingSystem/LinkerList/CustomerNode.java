/**
 * 
 */
package csd.TrainBookingSystem.LinkerList;

import csd.TrainBookingSystem.Entity.Customer;


/**
 * @author QUANG TRUNG
 *
 */
public class CustomerNode {

Customer info;

CustomerNode next;

CustomerNode() {};

CustomerNode(Customer x;CustomerNode q){info = x;next=q};

CustomerNode(Customer x){this(x,null);}




}
