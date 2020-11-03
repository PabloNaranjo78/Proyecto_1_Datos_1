//package cr.ac.tec.MonsTEC.MainWindow;
//
//import cr.ac.tec.MonsTEC.Game.GameWindow;
//import cr.ac.tec.MonsTEC.ServerSockets.Server;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//
//import java.util.Observable;
//import java.util.Observer;
//
//public class CreateGame extends Pane implements Observer {
//
//    public int port = (int) ((Math.random() * ((60000 - 5000) + 1)) + 5000);
//
//    public static Thread xxx;
//
//    public CreateGame(Stage stage) {
//
//
//        System.out.println(port);
//        btnBack.setLayoutX(10);
//        btnBack.setLayoutY(555);
//        btnBack.setPrefSize(100,35);
//
//        lblPort.setStyle("-fx-font-family: Consolas; " +
//                "-fx-font-size: 30px; -fx-text-fill: white");
//        lblPort.setLayoutX(615);
//        lblPort.setLayoutY(380);
//
//        lblIp.setStyle("-fx-font-family: Consolas; " +
//                "-fx-font-size: 30px; -fx-text-fill: white");
//        lblIp.setLayoutX(275);
//        lblIp.setLayoutY(380);
//
//        btnBack.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                stage.setScene(Main.getScene());
//
//
//            }
//        });
//
//        startServer(port,lblIp.getText());
//
//        getChildren().addAll(btnBack,lblPort,lblIp);
//    //    Thread waitConnexion = new Thread(()-> {
//    //        nexWindow(stage);
//     //   });
//      //  waitConnexion.start();
//
//        xxx = new Thread(()->{
//            GridPane gameWindow = new GameWindow(stage);
//            Scene scene = new Scene(gameWindow,1000,600);
//            System.out.println("2222222");
//            while (true){
//                boolean a = Server.getIsStarted();
//                if (a){
//                    System.out.println("Cambiando");
//                    stage.setScene(scene);
//
//                    break;
//                }
//            }
//            System.out.println("salido");
//        });
//        xxx.start();
//
//    }
//
//    private void startServer(int port, String ip) {
//        Server server = new Server(port,ip);
//        Thread serverThread = new Thread(server);
//        serverThread.start();
//
//
//    }
//
//    Label lblPort = new Label(port+"");
//    Label lblIp = new Label("127.0.0.1");
//    Button btnBack = new Button("Atrás");
//
//    public void nexWindow(Stage stage){
//        GridPane gameWindow = new GameWindow(stage);
//        Scene scene = new Scene(gameWindow,1000,600);
//        System.out.println("2222222");
//        while (true){
//            boolean a = Server.getIsStarted();
//            if (a){
//                System.out.println("Cambiando");
//                stage.setScene(scene);
//
//                break;
//            }
//        }
//        System.out.println("salido");
//      //
//
//    }
//
//
//    /**
//     * This method is called whenever the observed object is changed. An
//     * application calls an {@code Observable} object's
//     * {@code notifyObservers} method to have all the object's
//     * observers notified of the change.
//     *
//     * @param o   the observable object.
//     * @param arg an argument passed to the {@code notifyObservers}
//     */
//    @Override
//    public void update(Observable o, Object arg) {
//
//    }
//}
