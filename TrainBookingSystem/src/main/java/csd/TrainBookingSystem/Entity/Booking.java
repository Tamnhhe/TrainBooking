/**
 * 
 */
package csd.TrainBookingSystem.Entity;

/**
 * @author QUANG TRUNG
 *
 */
public class Booking {
    String tcode;
    String ccode;
    int seat;

    public Booking() {
    }

    public Booking(String tcode, String ccode,int seat) {
        this.ccode = ccode;
        this.tcode=tcode;
        this.seat = seat;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getTcode() {
        return tcode;
    }

    public void setTcode(String tcode) {
        this.tcode = tcode;
    }
}
