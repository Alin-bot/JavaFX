import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;

public class MainFrame extends Application {

    public final int W = 800, H = 600;

    @Override
    public void init() throws Exception {
        System.out.println("Before!");
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Main window");

        stage.setWidth(W);
        stage.setHeight(H);

        stage.setX(0);
        stage.setY(0);

        /*
        Stage help = new Stage();
        help.setWidth(200);
        help.setHeight(400);
        help.setTitle("Help window");
        help.initStyle(StageStyle.UTILITY); //just closing option
        help.initModality(Modality.APPLICATION_MODAL); // Forcing the user to finish the panel
        */

        VBox root = new VBox(); // vertical

        Label label = new Label("This is a label!"); // text
        label.setTextFill(Color.web("#0ead8d")); // coloring a label
        label.setFont(new Font("Cambria", 40)); // font and size

        Label label2 = new Label("This is another label!");
        label2.setId("special-label");

        Hyperlink link = new Hyperlink("Click me!"); // link text
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                link.setText("I was clicked!");
            }
        });

        root.getChildren().addAll(label, link, label2); // adding to the scene

        Scene scene = new Scene(root); // scene for displaying on the window
        scene.setCursor(Cursor.CROSSHAIR); // cross cursor on the scene
        scene.getStylesheets().add("stylesheets/styles.css"); // adding tha css sheet

        stage.setScene(scene); // adding scene to our window/stage

        stage.show(); // displaying the window
        //help.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("After!");
    }
}
