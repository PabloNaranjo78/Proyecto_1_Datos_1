package cr.ac.tec.MonsTEC.MainWindow;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JoinGame extends Pane {

    public JoinGame(Stage stage) {
        btnBack.setLayoutX(10);
        btnBack.setLayoutY(555);
        btnBack.setPrefSize(100,35);

        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(Main.getScene());
            }
        });

        getChildren().addAll(btnBack,txfIp,txfPort,btnStartGame);

    }

    TextField txfPort = new TextField();
    TextField txfIp = new TextField();
    Button btnStartGame = new Button("Iniciar juego");
    Button btnBack = new Button("Atrás");
}
