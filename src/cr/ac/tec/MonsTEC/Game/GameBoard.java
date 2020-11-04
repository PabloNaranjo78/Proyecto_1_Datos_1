package cr.ac.tec.MonsTEC.Game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GameBoard extends BorderPane {

    VBox cardHistoryBox = new VBox();
    Pane bottomPane = new Pane();
    Pane topPane = new Pane();
    ScrollPane cardHistoryScrollPane = new ScrollPane();
    int lifePoint = 1000;
    int enemyLifePoints = 1000;
    Label lifePointsLabel = new Label(""+lifePoint);
    Label enemyLifePointsLabel  = new Label(""+enemyLifePoints);


    public GameBoard(Stage stage){

        Button sendButton = new Button("Ceder turno");
        sendButton.setLayoutX(900);


        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addElementToVBox("GolpeSuerte");
            }
        });


        //Top Pane
        Label cardsHistoryTitle = new Label("Historial de cartas");

        topPane.getChildren().addAll(cardsHistoryTitle);

        //Bottom Pane
        bottomPane.getChildren().addAll(sendButton);

        //Scroll Pane
        cardHistoryScrollPane.setContent(cardHistoryBox);
        cardHistoryScrollPane.setPrefSize(80,80);
        cardHistoryBox.heightProperty().addListener(observable -> cardHistoryScrollPane.setVvalue(1D)); //Hace que siempre esté abajo la barra

        //Border Pane
        setTop(topPane);
        setLeft(cardHistoryScrollPane);
        setBottom(bottomPane);
    }
    public void addElementToVBox(String nameCard){
        Image cardImage =  new Image("/cr/ac/tec/MonsTEC/Resources/CardsImg/"+nameCard+".png",90,90,true,true);
        ImageView card = new ImageView(cardImage);
        cardHistoryBox.getChildren().add(card);
    }

    public void setImage(){

    }
}
