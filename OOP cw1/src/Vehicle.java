import java.util.Objects;

public abstract class Vehicle {
    private String plateNumber;// declare variables
    private String typeOfVehicle;
    private String make;
    private String rate;
    private String mileage;
    private String transmission;

    public Vehicle(){} // default constructor..
    public Vehicle(String plateNumber,String typeOfVehicle,String make,String rate,String mileage,String transmission){
        super(); // calling super class default constructor..
        this.plateNumber=plateNumber;
        this.typeOfVehicle=typeOfVehicle;
        this.make=make;
        this.rate=rate;
        this.mileage=mileage;
        this.transmission=transmission;

    }
    //getter methods and setter methods

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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlateNumber(),getTypeOfVehicle(), getMake(), getRate(), getMileage(), getTransmission());
    }
    //returning the string representation of the object..
    @Override
    public String toString() {
        return "Vehicle{" +
                "plateNumber='" + plateNumber + '\'' +
                ", typeOfVehicle='" + typeOfVehicle + '\'' +
                ", make='" + make + '\'' +
                ", rate=" + rate +
                ", mileage=" + mileage +
                ", transmission='" + transmission + '\'' +
                '}';
    }



}
