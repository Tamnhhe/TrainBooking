/**
 * 
 */
package csd.TrainBookingSystem.Entity;

/**
 * @author QUANG TRUNG
 *
 */
public class Train {
	String tcode;
    String trainName;
    int seat;
    int booked;
    double departTime;
    String departPlace;
    
    public Train() {   	
    }
    
    public Train(String tcode, String trainName, int seat, int booked, double departTime, String departPlace) {
        this.tcode = tcode;
        this.trainName = trainName;
        this.seat = seat;
        this.booked = booked;
        this.departTime = departTime;
        this.departPlace = departPlace;
    }

    public String getTcode() {
        return tcode;
    }

    public void setTcode(String tcode) {
        this.tcode = tcode;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        if (seat > 0) {
            this.seat = seat;
        } else {
            System.out.println("Seat count must be greater than 0.");
        }
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        if (booked >= 0 && booked < seat) {
            this.booked = booked;
        } else {
            System.out.println("Invalid number of booked seats.");
        }
    }

    public double getDepartTime() {
        return departTime;
    }

    public void setDepartTime(double departTime) {
        if (departTime >= 0) {
            this.departTime = departTime;
        } else {
            System.out.println("Departure time must be greater than or equal to 0.");
        }
    }

    public String getDepartPlace() {
        return departPlace;
    }

    public void setDepartPlace(String departPlace) {
        this.departPlace = departPlace;
    }
}
