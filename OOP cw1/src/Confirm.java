import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class Confirm {

    //Creating a boolean variable
    static boolean responseFromUser;

    public static boolean display(String title, String message) {
        Stage page = new Stage();
        page.initModality(Modality.APPLICATION_MODAL);
        page.setTitle(title);
        page.setMinWidth(250);
        Label label1 = new Label();
        label1.setText(message);

        //Creating the buttons
        Button yButton = new Button("Yes");
        Button nButton = new Button("No");

        yButton.setOnAction(e -> {
            responseFromUser = true;
            page.close();
        });
        nButton.setOnAction(e -> {
            responseFromUser = false;
            page.close();
        });

        VBox layout = new VBox(10);

        //Add buttons to the confirm box
        layout.getChildren().addAll(label1, yButton, nButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        page.setScene(scene);
        page.showAndWait();

        //return the response from the user..
        return responseFromUser;
    }

}