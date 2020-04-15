
public class Motorbike extends Vehicle{//Motorbike inherits from the vehicle class..
    //Declare variables...
    private String hasRadiator;


    public Motorbike(String plateNumber,String typeOfVehicle, String make, String rate, String mileage, String transmission,String hasRadiator) {
        super(plateNumber,typeOfVehicle, make, rate, mileage, transmission); //calling super class constructor..
        this.hasRadiator = hasRadiator;
    }

    //Getter methods and the setter methods..
    public String getHasRadiator() {
        return hasRadiator;
    }

    public void setHasRadiator(String hasRadiator) {
        this.hasRadiator = hasRadiator;
    }
}


