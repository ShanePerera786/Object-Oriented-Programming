public class Car extends Vehicle { //car inherits from the vehicle class..
    private String passengerCapacity;
    private String autonomousDriving;

    public Car(String plateNumber,String typeOfVehicle, String make, String rate, String mileage,String transmission,String passengerCapacity,String autonomousDriving) {
        super(plateNumber,typeOfVehicle,make, rate, mileage,transmission); //calling super class constructor..
        this.passengerCapacity = passengerCapacity;
        this.autonomousDriving=autonomousDriving;
    }
    //Getter methods and the setter methods..

    public String getPassengerCapacity() {

        return passengerCapacity;
    }

    public void setPassengerCapacity(String passengerCapacity) {

        this.passengerCapacity = passengerCapacity;
    }

    public String getAutonomousDriving() {
        return autonomousDriving;
    }

    public void setAutonomousDriving(String autonomousDriving) {
        this.autonomousDriving = autonomousDriving;
    }
}
