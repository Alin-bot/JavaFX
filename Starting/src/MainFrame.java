import javafx.application.Application;
import javafx.stage.Stage;

public class MainFrame extends Application {

    @Override
    public void init() throws Exception {
        System.out.println("Before!");
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello world!");
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("After!");
    }
}
