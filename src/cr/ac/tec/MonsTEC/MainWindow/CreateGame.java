package cr.ac.tec.MonsTEC.MainWindow;

import cr.ac.tec.MonsTEC.Game.GameBoard;
import cr.ac.tec.MonsTEC.ServerSockets.Server;
import cr.ac.tec.MonsTEC.ServerSockets.ServerController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Se pasa a una ventana donde se muestra la ip y socket de la partida, para que el segundo jugador
 * utilice esos datos para ingresar al juego del que el usuario es host
 */
public class CreateGame extends Pane {

    final public int port = (int) ((Math.random() * ((60000 - 5000) + 1)) + 5000);
    Stage stage;
    ServerController serverController;
    String ip = "127.0.0.1";
    /**
     *Se definen valores de la interfaz, y la interfaz en si, junto con las acciones de los respectivos botones,
     *los cuales son el de atras y el de iniciar el juego
     * @param stage
     */
    public CreateGame(Stage stage) {

        this.stage = stage;
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

        startServer(port,ip);

        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(Main.getScene());


            }
        });

        btnStartGame.setPrefSize(125,50);
        btnStartGame.setLayoutX(445);
        btnStartGame.setLayoutY(460);
        btnStartGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                nexWindow(); //poner una forma para que no pase de ventana en caso de que no se inicie el server
            }
        });


        this.serverController = new ServerController(false,port,ip);
        getChildren().addAll(btnBack,lblPort,lblIp,btnStartGame);
        };


    /***
     * Inicia el servidor
     * @param port número de puerto
     * @param ip número de ip
     */
    private void startServer(int port, String ip) {
        Server server = new Server(port);
        Thread serverThread = new Thread(server);
        serverThread.start();

    }

    Label lblPort = new Label(port+"");
    Label lblIp = new Label("127.0.0.1");
    Button btnBack = new Button("Atrás");
    Button btnStartGame = new Button("Iniciar juego");

    /**
     *Hace que se pasa hacia la siguiente ventana
     */
    public void nexWindow(){
        BorderPane gameBoard = new GameBoard(stage,this.serverController);
        Scene scene = new Scene(gameBoard,1000,600);
        stage.setScene(scene);

    }


}
