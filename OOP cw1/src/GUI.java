import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/* This is a demo of a basic JavaFX interface scripted without use of additional development tools.*/
public class GUI extends Application {
    Stage page;
    Scene scene1, scene2,scene3,scene4;
    TableView<Db> table;

    public static void main(String[] args){
        //launch() will call start() for the JavaFX application
        launch(args);
    }

    private Connection con;
    @Override
    public void start(Stage primaryStage) {
        page = primaryStage;

        page.setOnCloseRequest(e ->{
            e.consume();
            closeProgram();

        });

        //Button 1
        Label label1 = new Label("Welcome to Westminster Rental vehicle manager!");
        Button button1 = new Button("Get Started!");
        button1.setOnAction(e -> page.setScene(scene2));

        //Layout 1
        VBox layout1 = new VBox(150);
        layout1.getChildren().addAll(label1, button1);
        layout1.setAlignment(Pos.CENTER);
        scene1 = new Scene(layout1, 700, 500);


        //Button 2
        Button button2 = new Button("view table");
        button2.setOnAction(e -> page.setScene(scene3));

        //button 3
        Button button3=new Button("Book a vehicle");
        button3.setOnAction(e -> page.setScene(scene4));

        //button4
        Button button4=new Button("Exit");
        button4.setOnAction(e ->closeProgram());



        //Layout 2
        VBox layout2= new VBox(20);
        layout2.setAlignment(Pos.CENTER);
        layout2.getChildren().add(button2);
        layout2.getChildren().add(button3);
        layout2.getChildren().add(button4);
        scene2 = new Scene(layout2, 600, 300);

        //Creating table..

        //Plate number column
        TableColumn<Db, String> plateNumColumn = new TableColumn<>("Plate Number");
        plateNumColumn.setMinWidth(100);
        plateNumColumn.setCellValueFactory(new PropertyValueFactory<>("plateNumber"));

        //Vehicle column
        TableColumn<Db, String> vehicleColumn = new TableColumn<>("Vehicle type");
        vehicleColumn.setMinWidth(100);
        vehicleColumn.setCellValueFactory(new PropertyValueFactory<>("typeOfVehicle"));

        //make column
        TableColumn<Db, String> makeColumn = new TableColumn<>("Make");
        makeColumn.setMinWidth(100);
        makeColumn.setCellValueFactory(new PropertyValueFactory<>("Make"));

        //rate column
        TableColumn<Db, String> rateColumn = new TableColumn<>("Rate");
        rateColumn.setMinWidth(100);
        rateColumn.setCellValueFactory(new PropertyValueFactory<>("Rate"));

        //mileage column
        TableColumn<Db, String> mileageColumn = new TableColumn<>("Mileage");
        mileageColumn.setMinWidth(100);
        mileageColumn.setCellValueFactory(new PropertyValueFactory<>("Mileage"));

        //transmission column
        TableColumn<Db, String> transmissionColumn = new TableColumn<>("transmission");
        transmissionColumn.setMinWidth(100);
        transmissionColumn.setCellValueFactory(new PropertyValueFactory<>("transmission"));

        //passenger capacity column
        TableColumn<Db, String> passengerColumn = new TableColumn<>("passenger Capacity");
        passengerColumn.setMinWidth(100);
        passengerColumn.setCellValueFactory(new PropertyValueFactory<>("passengerCapacity"));

        //autonomous driving column
        TableColumn<Db, String> autonomousColumn = new TableColumn<>("Autonomous driving");
        autonomousColumn.setMinWidth(100);
        autonomousColumn.setCellValueFactory(new PropertyValueFactory<>("autonomousDriving"));


        table = new TableView<>();
        final ObservableList<Db> database=FXCollections.observableArrayList();


        Button button7 = new Button("Load table");
        button7.setOnAction(e ->{
            try {  // Get connection to database
                Class.forName("com.mysql.jdbc.Driver");

                con = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/vehicle_rental_manager", "root", "");

                java.sql.Statement s= con.createStatement();
                ResultSet rset = s.executeQuery("SELECT * FROM vehicle_rental");


                while ( rset.next() ) {
                    database.add(new Db(
                            rset.getString("plateNumber"),
                            rset.getString("typeOfVehicle"),
                            rset.getString("make"),
                            rset.getString("rate"),
                            rset.getString("mileage"),
                            rset.getString("transmission"),
                            rset.getString("passengerCapacity"),
                            rset.getString("autonomousDriving")

                    ));
                    table.setItems(database);
                }
                con.close();
            } catch (Exception e1) {
                System.err.println(e1);
            }
        });
        table.getColumns().addAll(plateNumColumn,vehicleColumn,makeColumn,rateColumn,mileageColumn,transmissionColumn,passengerColumn,autonomousColumn);

        //Button 6
        Button button6 = new Button("Go back");
        button6.setOnAction(e -> page.setScene(scene2));

        VBox layout3 = new VBox();
        layout3.getChildren().addAll(table);
        layout3.setAlignment(Pos.CENTER);
        layout3.getChildren().add(button6);
        layout3.getChildren().add(button7);

        scene3 = new Scene(layout3,1300,700);


        //creating booking page with grid pane..
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Fisrt Name Label
        Label fnameLabel = new Label("First name:");
        GridPane.setConstraints(fnameLabel, 0, 0);

        //First Name Input
        TextField fnameInput = new TextField("");
        GridPane.setConstraints(fnameInput, 1, 0);

        //Last name label
        Label lnameLabel = new Label("Last name:");
        GridPane.setConstraints(lnameLabel, 0, 1);

        //last name Input
        TextField lnameInput = new TextField("");
        GridPane.setConstraints(lnameInput, 1, 1);

        //vehicle label
        Label vLabel = new Label("Plate no:");
        GridPane.setConstraints(vLabel, 0, 2);

        //vehicle Input
        TextField vInput = new TextField("");
        GridPane.setConstraints(vInput, 1, 2);

        //pickup Date label
        Label pdLabel = new Label("Pick-up date:");
        GridPane.setConstraints(pdLabel, 0, 3);

        //pickup date input
        TextField pdInput = new TextField("");
        GridPane.setConstraints(pdInput, 1, 3);

        //drop-off date label
        Label doLabel = new Label("Drop-off date:");
        GridPane.setConstraints(doLabel, 0, 4);

        //drop-off date input
        TextField doInput = new TextField("");
        GridPane.setConstraints(doInput, 1, 4);

        Button submitButton = new Button("Submit");
        GridPane.setConstraints(submitButton, 1, 5);

        //Button 5
        Button button5 = new Button("Go back");
        GridPane.setConstraints(button5, 2, 5);
        button5.setOnAction(e -> page.setScene(scene2));

        grid.getChildren().addAll(fnameLabel, fnameInput, lnameLabel, lnameInput, vLabel,vInput,pdLabel,pdInput,doLabel,doInput,submitButton,button5);

        VBox layout4 = new VBox();
        layout4.getChildren().addAll(grid);
        layout4.setAlignment(Pos.CENTER);
        scene4 = new Scene(layout4,500,600);

        //Display scene 1 at first
        page.setScene(scene1);
        page.show();

    }
    private void closeProgram(){
        Boolean answer= Confirm.display("GUI","Are you sure you want to exit?");
        if(answer)
            page.close();
    }

}