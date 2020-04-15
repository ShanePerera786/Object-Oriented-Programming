import java.sql.PreparedStatement;
import java.sql.*;
import java.util.*;
import java.util.List;

public class WestminsterRentalVehicleManager implements RentalVehicleManager {

    private List<Vehicle> rentalVehicle = new ArrayList<Vehicle>();
    private static final int MAX_COUNT = 50;
    private static Scanner input = new Scanner(System.in);

    private Connection con;
    public void database(){
        try {
            // Get connection to database
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/vehicle_rental_manager", "root", "");


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void menu() {
        int option;

        do {
            System.out.println("********************************************************************");
            System.out.println("Welcome to Westminster Rental vehicle manager\n");
            System.out.println("Option:");
            System.out.println(
                    "         1)  Add vehicle \n" +
                    "         2)  Delete vehicle \n" +
                    "         3)  Print list of vehicle \n" +
                    "         4)  Edit vehicle \n" +
                    "         5)  Sort  \n" +
                    "         6)  Exit from the vehicle rental Store \n");

            System.out.print("Please enter your option : \n");            //get the input  from the user

            while (!input.hasNextInt()) {
                System.out.print("Please enter an integer ");
                input.next();
            }
            option = input.nextInt();   //Check if the user input a non integer
            input.nextLine();

            switch (option) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    deleteVehicle();
                    break;
                case 3:
                    printList();
                    break;
                case 4:
                    editVehicle();
                case 5:
                    sort();
                    break;
            }
        } while (option != 6);
        {
            System.out.println("You have exited..!!Thank you for using our vehicle rental manager!");
            System.exit(0);
        }
    }

    public void checkStringValidation(){
        while (input.hasNextInt()){    //check whether user enters an integer
            System.out.println("You have entered a integer.Please re-enter your name");
            input.nextLine();
        }
    }
    public void checkIntValidation(){
        while (!input.hasNextInt()) {   //check whether user inputs a non integer
            System.out.println("Invalid input..please re-enter.."); //display this message when user inputs a non integer
            input.next();
        }
    }

    public void addVehicle() {
        try {
            // Get connection to database
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/vehicle_rental_manager", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (rentalVehicle.size() < MAX_COUNT) { }
        else {
            System.out.println("No space available in the list");
        }


        System.out.println("Enter the type of vehicle");
        checkStringValidation();
        String typeOfVehicle=input.nextLine();

        if (typeOfVehicle.equals("car")) {

            System.out.print("Enter the vehicle plate number:");
            String plateNumber = input.nextLine();

            System.out.print("Enter the brand of the vehicle:");
            checkStringValidation();
            String make = input.nextLine();

            System.out.print("Enter the rate of the vehicle:");
            String rate = input.nextLine();

            System.out.print("Enter the mileage:");
            String mileage = input.nextLine();

            System.out.print("Enter the transmission type:");
            checkStringValidation();
            String transmission = input.next();

            System.out.print("Enter the passenger capacity:");
            String passengerCapacity=input.next();

            System.out.print("Does car has autonomous driving:");
            checkStringValidation();
            String autonomousDriving=input.nextLine();

            Car vh = new Car(plateNumber,typeOfVehicle,make,rate,mileage,transmission,passengerCapacity,autonomousDriving); // create an object.

            //Insert values to database
            try {
                PreparedStatement connect = con.prepareStatement("insert into vehicle_rental"
                        + "(plateNumber,typeOfVehicle,make,rate,mileage,transmission,passengerCapacity,autonomousDriving)"
                        + "values(?,?,?,?,?,?,?,?)");
                connect.setString(1, vh.getPlateNumber());
                connect.setString(2,vh.getTypeOfVehicle());
                connect.setString(3, vh.getMake());
                connect.setString(4, vh.getRate());
                connect.setString(5, vh.getMileage());
                connect.setString(6, vh.getTransmission());
                connect.setString(7,vh.getPassengerCapacity());
                connect.setString(8,vh.getAutonomousDriving());
                connect.execute();

                System.out.println("********************************************************************");
                System.out.println("Inserted Successfully");
            } catch (SQLException exce) {
                exce.printStackTrace();
            }
        }
        else if(typeOfVehicle.equals("motorbike")) {
            System.out.print("Enter the vehicle plate number:");
            String plateNumber = input.nextLine();

            System.out.print("Enter the brand of the vehicle:");
            checkStringValidation();
            String make = input.nextLine();

            System.out.print("Enter the rate of the vehicle:");
            String rate = input.next();

            System.out.print("Enter the mileage:");
            String mileage = input.next();

            System.out.print("Enter the transmission type:");
            checkStringValidation();
            String transmission = input.next();

            System.out.print("Does bike has a radiator:");
            checkStringValidation();
            String hasRadiator=input.nextLine();

            Motorbike vh = new Motorbike(plateNumber,typeOfVehicle,make,rate,mileage,transmission,hasRadiator); // create an object.

            //Insert values to database
            try {
                PreparedStatement connect = con.prepareStatement("insert into vehicle_rental"
                        + "(plateNumber,typeOfVehicle,make,rate,mileage,transmission,hasRadiator)"
                        + "values(?,?,?,?,?,?,?)");
                connect.setString(1, vh.getPlateNumber());
                connect.setString(2, vh.getTypeOfVehicle());
                connect.setString(3, vh.getMake());
                connect.setString(4, vh.getRate());
                connect.setString(5, vh.getMileage());
                connect.setString(6, vh.getTransmission());
                connect.setString(7, vh.getHasRadiator());
                connect.execute();

                System.out.println("********************************************************************");
                System.out.println("Inserted Successfully");
            } catch (SQLException exce) {
                exce.printStackTrace();
            }
        }
    }

    public void deleteVehicle() {
        try {
            // Get connection to database
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/vehicle_rental_manager", "root", "");

            //create delete vehicle method..
            System.out.println("Enter the plate number of the vehicle:");
            String deleteItem = input.next();

            //sql query to delete a recode from the database..
            String deleteSql = "delete from vehicle_rental where plateNumber = '" + deleteItem+"'";

            //creating the database statement..
            PreparedStatement stat = con.prepareStatement(deleteSql);

            //Execute the stat..
            stat.execute();
            System.out.println("Successfully deleted vehicle of" + "plate number:" + deleteSql);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
        //create print list method..
        public void printList() {
              try {  // Get connection to database
                  Class.forName("com.mysql.jdbc.Driver");

                  con = DriverManager.getConnection
                          ("jdbc:mysql://localhost:3306/vehicle_rental_manager", "root", "");

                  java.sql.Statement s= con.createStatement();
                  //sql query for select all the records in the table and print vehicle list..
                    ResultSet printLi = s.executeQuery("SELECT * FROM vehicle_rental");

                    System.out.println("List of vehicles..");

                  System.out.println("Plate number\tVehicle Type\tBrand\tRate\tMileage\t\tTransmission\tPassenger Capacity");
                  System.out.println("============\t============\t=====\t=====\t=======\t\t============\t==================");
                    while ( printLi.next() ) {
                        String coloumn1 = printLi.getString("plateNumber");
                        String coloumn2 = printLi.getString("typeOfVehicle");
                        String coloumn3 = printLi.getString("make");
                        String coloumn4 = printLi.getString("rate");
                        String coloumn5 = printLi.getString("mileage");
                        String coloumn6 = printLi.getString("transmission");
                        String coloumn7 = printLi.getString("passengerCapacity");

                        System.out.println(coloumn1 +"\t\t\t"+coloumn2+"\t\t\t\t"+coloumn3+"\t"+coloumn4+"\t\t"+coloumn5+"\t\t\t"+coloumn6+"\t\t\t"+coloumn7);

                    }
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

    public void editVehicle() {
        try {  // Get connection to database
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/vehicle_rental_manager", "root", "");

            System.out.println("Enter the plate number that you want to edit:");
            String editSql=input.next();

            System.out.println("Enter the new plate number :");
            String newPlateNum =input.next();

            //sql query for edit plate number
            String updateItem="UPDATE vehicle_rental SET plateNumber = '"+newPlateNum+"' WHERE plateNumber ='"+editSql+"'";

            //create preparedStatement..
            PreparedStatement stat = con.prepareStatement(updateItem);


            int resultSql=stat.executeUpdate();

            System.out.println( resultSql+
                    " update successfully");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sort() {
        // variables
        ResultSet resultSet;
        try {
            // Get connection to database
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/vehicle_rental_manager", "root", "");
            java.sql.Statement s= con.createStatement();

            //sql query for sort plate number to ascending order..
            String sortItem="SELECT * FROM vehicle_rental ORDER BY plateNumber ASC";
            PreparedStatement stat = con.prepareStatement(sortItem);
            resultSet = s.executeQuery(sortItem);

            //Printing the sort table..
            System.out.println("Plate Number\tVehicle Type\tMake\tRate");
            System.out.println("============\t============ \t=====\t======");
            while(resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t\t\t" +
                        resultSet.getString(2) + "\t\t\t\t" +
                        resultSet.getString(3) + "\t" +
                        resultSet.getString(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        }
}
