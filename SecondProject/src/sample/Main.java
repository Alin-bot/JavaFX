package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        //primaryStage.setScene(new Scene(root, 300, 275));
        Group root = new Group();
        Scene scene = new Scene(root, 350, 300);
        primaryStage.setTitle("Dots");
        primaryStage.setScene(scene);

        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
            if(me.getButton().equals(MouseButton.PRIMARY)) {
                Circle circle = new Circle(me.getX(), me.getY(), 10, Color.BLUE);
                addEventHandler(root, circle);
                root.getChildren().add(circle);
            }
        });
        primaryStage.show();
    }
    public void addEventHandler(Group parent, Node node) {
        node.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
            if(me.getButton().equals(MouseButton.SECONDARY)) {
                parent.getChildren().remove(node);
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
