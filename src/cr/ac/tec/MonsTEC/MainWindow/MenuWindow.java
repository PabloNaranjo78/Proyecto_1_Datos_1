package cr.ac.tec.MonsTEC.MainWindow;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MenuWindow extends Pane {
    Stage primaryStage;

    public MenuWindow(Stage scene){
        this.primaryStage = scene;




        btnStartGame.setLayoutX(170);
        btnStartGame.setLayoutY(380);

        btnJoinGame.setLayoutX(510);
        btnJoinGame.setLayoutY(380);
        btnJoinGame.setStyle("-fx-background-color: rgba(243,236,250,0.63)");

        getChildren().addAll(btnJoinGame,btnStartGame);

    }

    Button btnStartGame = new Button("Iniciar Partida");
    Button btnJoinGame = new Button ("Unirse a una Partida");

}
