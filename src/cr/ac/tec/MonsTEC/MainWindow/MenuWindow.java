//package cr.ac.tec.MonsTEC.MainWindow;
//
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.FlowPane;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//
//public class MenuWindow extends Pane {
//    Stage primaryStage;
//    public Scene createGameScene;
//
//    public MenuWindow(Stage window){
//        this.primaryStage = window;
//
//        btnStartGame.setLayoutX(210);
//        btnStartGame.setLayoutY(380);
//        btnStartGame.setPrefSize(200,75);
//
//        btnJoinGame.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("Uniéndolse a juego");
//                Pane joinGame = new JoinGame(primaryStage);
//                joinGame.setStyle("-fx-background-image: url(/cr/ac/tec/MonsTEC/Resources/JoinGameBackground.png)");
//                Scene joinGameScene = new Scene(joinGame,1000,600);
//                primaryStage.setScene(joinGameScene);
//
//            }
//        });
//
//        btnJoinGame.setLayoutX(590);
//        btnJoinGame.setLayoutY(380);
//        btnJoinGame.setPrefSize(200,75);
//
//        btnStartGame.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("Pantalla creando juego");
//                Pane createGame = new CreateGame(primaryStage);
//                createGame.setStyle("-fx-background-image: url(/cr/ac/tec/MonsTEC/Resources/CreateGameBackground.png)");
//                createGameScene = new Scene(createGame,1000,600);
//                primaryStage.setScene(createGameScene);
//
//            }
//        });
//
//        getChildren().addAll(btnJoinGame,btnStartGame);
//
//    }
//
//    Button btnStartGame = new Button("Iniciar Partida");
//    Button btnJoinGame = new Button ("Unirse a una Partida");
//
//}
