package cr.ac.tec.MonsTEC.MainWindow;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CreateGame extends Pane {

    public int port = (int) ((Math.random() * ((60000 - 5000) + 1)) + 5000);

    public CreateGame(Stage stage) {

        System.out.println(port);
        btnBack.setLayoutX(10);
        btnBack.setLayoutY(555);
        btnBack.setPrefSize(100,35);

        lblPort.setStyle("-fx-font-family: Consolas; " +
                "-fx-font-size: 30px; -fx-text-fill: white");
        lblPort.setLayoutX(615);
        lblPort.setLayoutY(380);

        lblIp.setStyle("-fx-font-family: Consolas; " +
                "-fx-font-size: 30px; -fx-text-fill: white");
        lblIp.setLayoutX(275);
        lblIp.setLayoutY(380);

        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(Main.getScene());
            }
        });

        getChildren().addAll(btnBack,lblPort,lblIp);
    }

    Label lblPort = new Label(port+"");
    Label lblIp = new Label("127.0.0.1");
    Button btnBack = new Button("Atrás");

}
