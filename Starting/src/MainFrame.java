import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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

        /*
        Stage help = new Stage();
        help.setWidth(200);
        help.setHeight(400);
        help.setTitle("Help window");
        help.initStyle(StageStyle.UTILITY); //just closing option
        help.initModality(Modality.APPLICATION_MODAL); // Forcing the user to finish the panel
        */

        VBox vRoot = new VBox(); // layout on vertical

        Label label = new Label("This is a label!"); // text
        label.setTextFill(Color.web("#0ead8d")); // coloring a label
        label.setFont(new Font("Cambria", 40)); // font and size

        Label label2 = new Label("This is another label!");
        label2.setId("special-label");

        Hyperlink link = new Hyperlink("Click me!"); // link text
        link.setOnAction(e -> {
            link.setText("I was clicked!");
        });
        link.setTranslateX(400);
        link.setTranslateY(50);
        link.setStyle("-fx-rotate: 45"); // css commands

        Button button = new Button("I'm a button who can be wrapped"); // button
        button.setStyle("-fx-font-size: 20");
        button.setWrapText(true);
        button.setPrefSize(400, 30);
        button.setTranslateX(200);
        button.setTranslateY(300);
        button.setOnAction(e -> {
            System.out.println("Button clicked!");
        });

        // menu items
        MenuItem blue = new MenuItem("Blue");
        MenuItem red = new MenuItem("Red");
        MenuItem yellow = new MenuItem("Yellow");
        MenuItem green = new MenuItem("Green");

        MenuButton menu = new MenuButton("Colors", null, blue, red, yellow, green); // adding items to menu button
        Label color = new Label("Select Red!");
        color.setId("color-label");

        blue.setOnAction(e -> {
            color.setText("Now Select Yellow");
        });
        red.setOnAction(e -> {
            color.setText("Now Select Blue");
        });
        yellow.setOnAction(e -> {
            color.setText("Now select Green");
        });
        green.setOnAction(e -> {
            color.setText("Now select Red");
        });

        // radio buttons
        RadioButton r1 = new RadioButton("I'm not selected");
        RadioButton r2 = new RadioButton("I'm already selected");
        r1.setTranslateX(650);
        r1.setTranslateY(230);
        r2.setTranslateX(650);
        r2.setTranslateY(240);

        ToggleGroup buttonGroup = new ToggleGroup();
        r1.setToggleGroup(buttonGroup);
        r2.setToggleGroup(buttonGroup);

        if (!r1.isSelected()) {
            r2.setSelected(true);
        }

        HBox hRoot = new HBox();
        Button b1 = new Button("One");
        Button b2 = new Button("Two");
        Button b3 = new Button("Three");
        Button b4 = new Button("Four");

        hRoot.setSpacing(10);
        hRoot.setAlignment(Pos.BOTTOM_CENTER); // position of the buttons






      hRoot.getChildren().addAll(b1, b2, b3, b4);
        vRoot.getChildren().addAll(label, link, label2, button, color, menu, r1, r2); // adding to the scene

        VBox box = new VBox();
        box.getChildren().addAll(vRoot, hRoot);

        Scene scene = new Scene(box); // scene for displaying on the window
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
