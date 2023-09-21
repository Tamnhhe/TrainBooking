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

public Customer data;

public CustomerNode next;

public CustomerNode() {};

public CustomerNode(Customer data;CustomerNode next)
    {this.data = data;
    this.next = next};

public CustomerNode(Customer x){this(x,null);}




}
