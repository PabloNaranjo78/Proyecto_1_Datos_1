package cr.ac.tec.MonsTEC.MainWindow;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new MenuWindow(primaryStage);

        Scene scene = new Scene(root, 1000, 600);

        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MonsTEC");
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch();
    }
}
