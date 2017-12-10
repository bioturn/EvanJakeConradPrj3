package display;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GuiDisplay extends Application {

    private static TemperatureDisplay display;

    public static TemperatureDisplay getInstance() {
        return display;
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/tempControlUnit.fxml"));
        primaryStage.setTitle("Temperature Control Unit");
        primaryStage.setScene(new Scene(root, 800,200));
        primaryStage.show();
        primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent window) {
                System.exit(0);
            }
        });

    }
}
