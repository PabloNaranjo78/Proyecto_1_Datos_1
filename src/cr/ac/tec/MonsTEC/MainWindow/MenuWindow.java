package cr.ac.tec.MonsTEC.MainWindow;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MenuWindow extends FlowPane {
    Stage primaryStage;

    public MenuWindow(Stage scene){
        this.primaryStage = scene;

        getChildren().add(iblTitle);
        getChildren().add(btnStart);
    }

    Label iblTitle = new Label("Bienvenido a MonsTEC");
    Button btnStart = new Button("Empezar");

}
