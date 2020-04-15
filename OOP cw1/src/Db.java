public class Db {
    private String plateNumber;// declare variables
    private String typeOfVehicle;
    private String make;
    private String rate;
    private String mileage;
    private String transmission;
    private String passengerCapacity;
    private String autonomousDriving;

    public Db(){}
    public Db(String plateNumber, String typeOfVehicle, String make, String rate, String mileage, String transmission, String passengerCapacity, String autonomousDriving) {
        this.plateNumber = plateNumber;
        this.typeOfVehicle = typeOfVehicle;
        this.make = make;
        this.rate = rate;
        this.mileage = mileage;
        this.transmission = transmission;
        this.passengerCapacity = passengerCapacity;
        this.autonomousDriving = autonomousDriving;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

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
