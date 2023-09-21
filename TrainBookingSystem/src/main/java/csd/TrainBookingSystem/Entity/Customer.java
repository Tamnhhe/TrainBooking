/**
 * 
 */
package csd.TrainBookingSystem.Entity;

/**
 * @author QUANG TRUNG
 *
 */
public class Customer {
String ccode;
String name;
String phone;

public Customer(){};

public Customer(String ccode,String name,String phone){
        this.ccode = ccode;
        this.name = name;
        this.phone = phone;
    };

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "" + ccode + " | " +name+" | "+phone;

    }
}
