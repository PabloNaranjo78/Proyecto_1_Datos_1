//package cr.ac.tec.MonsTEC.MainWindow;
//
//import cr.ac.tec.MonsTEC.ServerSockets.Client;
//import cr.ac.tec.MonsTEC.ServerSockets.Server;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.swing.event.CaretListener;
//
//public class JoinGame extends Pane {
//
//    public static Logger log = LoggerFactory.getLogger(JoinGame.class); //Logger
//
//    public JoinGame(Stage stage) {
//        btnBack.setLayoutX(10);
//        btnBack.setLayoutY(555);
//        btnBack.setPrefSize(100,35);
//
//        txfPort.setLayoutX(585);
//        txfPort.setLayoutY(380);
//
//        txfIp.setLayoutX(275);
//        txfIp.setLayoutY(380);
//        txfIp.setText("127.0.0.1");
//
//        btnBack.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                stage.setScene(Main.getScene());
//            }
//        });
//
//        btnStartGame.setPrefSize(125,50);
//        btnStartGame.setLayoutX(445);
//        btnStartGame.setLayoutY(460);
//        btnStartGame.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                Client client = new Client(Integer.parseInt(txfPort.getText()),txfIp.getText());
//                Thread clientThread = new Thread(client);
//                clientThread.start();
//                }//Se puede poner aquí una ventana de aviso en caso de los datos estén vacíos.
//        });
//
//        getChildren().addAll(btnBack,txfIp,txfPort,btnStartGame);
//
//    }
//
//    TextField txfPort = new TextField();
//    TextField txfIp = new TextField();
//    Button btnStartGame = new Button("Iniciar juego");
//    Button btnBack = new Button("Atrás");
//}
