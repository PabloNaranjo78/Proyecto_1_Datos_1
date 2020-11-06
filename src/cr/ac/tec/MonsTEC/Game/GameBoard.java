package cr.ac.tec.MonsTEC.Game;

import cr.ac.tec.MonsTEC.CartTypesInteract.Esbirros;
import cr.ac.tec.MonsTEC.DeckCartas.CardTypes.TypeCarta;
import cr.ac.tec.MonsTEC.DeckCartas.Deckplayer;
import cr.ac.tec.MonsTEC.DeckCartas.Stack;
import cr.ac.tec.MonsTEC.Tools.CardHand;
import cr.ac.tec.MonsTEC.Tools.EventRegister;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameBoard extends BorderPane {

    EventRegister eventRegister = new EventRegister();

    Pane bottomPane = new Pane();
    Pane topPane = new Pane();
    Pane centerPane = new Pane();

    int lifePoint = 1000;
    int enemyLifePoints = 1000;
    int cardsInHand = 0;
    int cardsInDeck = 16;
    int totalMana = 1000;
    int usableMana = 100000000;

    boolean isUsableCardSlot1 = true;
    boolean isUsableCardSlot2 = true;
    boolean isUsableCardSlot3 = true;
    boolean isUsableCardSlot4 = true;
    boolean isUsableCardSlot5 = true;

    Pane cardSlot1Pane = new Pane();
    Pane cardSlot2Pane = new Pane();
    Pane cardSlot3Pane = new Pane();
    Pane cardSlot4Pane = new Pane();
    Pane cardSlot5Pane = new Pane();

    Label lifePointsLabel = new Label("Su vida: "+lifePoint);
    Label cardsCounterLabel = new Label("Quedan "+cardsInDeck +" cartas");
    Label enemyLifePointsLabel  = new Label("Vida Enemiga: "+enemyLifePoints);
    Label manaPointsLabel = new Label("Mana: "+usableMana);
    Label cardsHistoryTitle = new Label("Historial de cartas");

    VBox cardHistoryBox = new VBox();
    ScrollPane cardHistoryScrollPane = new ScrollPane();

    HBox cardsHand = new HBox();
    ScrollPane cardHandScrollPane = new ScrollPane();

    HBox cardsInTable = new HBox();
    ScrollPane cardsInTableScrollPane = new ScrollPane();

    Deckplayer myDeckGen;
    Stack myDeck;


    public GameBoard(Stage stage){
        this.myDeckGen = new Deckplayer();
        this.myDeck = myDeckGen.getDeck();

        Button sendButton = new Button("Ceder turno");
        Button takeCardFromDeckButton = new Button("Tomar una carta");
        sendButton.setLayoutX(900);
        takeCardFromDeckButton.setLayoutX(800);

        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            //    addElementToVBox();
                card1Slot(myDeck.peek());
                card2Slot(myDeck.peek());
                card3Slot(myDeck.peek());
                card4Slot(myDeck.peek());
                card5Slot(myDeck.peek());
                //manda el registro al socket
                //Limpia el registro
            }
        });

        takeCardFromDeckButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                executeCard(myDeck.peek());
                System.out.println("ejecutando");
                System.out.println(eventRegister.getDamage());
                System.out.println(isUsableCardSlot1);
            }
        });


        //Top Pane
        enemyLifePointsLabel.setLayoutX(200);
        lifePointsLabel.setLayoutX(800);
        manaPointsLabel.setLayoutX(600);
        cardsCounterLabel.setLayoutX(400);

        topPane.getChildren().addAll(cardsHistoryTitle,lifePointsLabel,enemyLifePointsLabel,manaPointsLabel,cardsCounterLabel);


        //Bottom Pane
        cardHandScrollPane.setContent(cardsHand);
        cardHandScrollPane.setPrefSize(80,80);
        cardSlot1Pane.setPrefSize(100,100);
        bottomPane.setPrefSize(150,150);
        cardSlot1Pane.setLayoutX(50);
        cardSlot2Pane.setLayoutX(200);
        cardSlot3Pane.setLayoutX(350);
        cardSlot4Pane.setLayoutX(500);
        cardSlot5Pane.setLayoutX(650);
        bottomPane.getChildren().addAll(sendButton,takeCardFromDeckButton,cardSlot1Pane,cardSlot2Pane,
                cardSlot3Pane,cardSlot4Pane,cardSlot5Pane);

        //Scroll Pane History
        cardHistoryScrollPane.setContent(cardHistoryBox);
        cardHistoryScrollPane.setPrefSize(85,80);

        cardHistoryBox.heightProperty().addListener(observable -> cardHistoryScrollPane.setVvalue(1D)); //Hace que siempre esté abajo la barra

        //Center Pane

        cardsInTableScrollPane.setContent(cardsInTable);
        cardsInTableScrollPane.setPrefSize(80,100);


        //Border Pane
        setTop(topPane);
        setLeft(cardHistoryScrollPane);
        setBottom(bottomPane);
        setCenter(cardsInTableScrollPane);
//        setCenter(cardSlot1Pane);

    }
    public void addToTable(TypeCarta card){
        CardHand card1 = new CardHand(card,90);
    //    cardHistoryBox.getChildren().add(card1.getCardImg());
        cardsInTable.getChildren().add(card1.getCardImg());

 //       this.myDeck.pop();
    }

    public void setImage(){
    }

    private void addToHistory(TypeCarta card){
        CardHand card1 = new CardHand(card,90);
        cardHistoryBox.getChildren().add(card1.getCardImg());
    }

    private void setTopElements(int enemyLifePoints,int usableMana,int lifePoint,int cardsInDeck){
        topPane.getChildren().clear();
        Label enemyLifePointsLabel  = new Label("Vida Enemiga: "+enemyLifePoints);
        Label manaPointsLabel = new Label("Mana: "+usableMana);
        Label cardsHistoryTitle = new Label("Historial de cartas");
        Label lifePointsLabel = new Label("Su vida: "+lifePoint);
        Label cardsCounterLabel = new Label("Quedan "+cardsInDeck +" cartas");
        enemyLifePointsLabel.setLayoutX(200);
        lifePointsLabel.setLayoutX(800);
        manaPointsLabel.setLayoutX(600);
        cardsCounterLabel.setLayoutX(400);

        topPane.getChildren().addAll(cardsHistoryTitle,lifePointsLabel,enemyLifePointsLabel,manaPointsLabel,cardsCounterLabel);


        setTop(topPane);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////
    public void actMana(int mana){
        this.usableMana-=mana;
        setTopElements(this.enemyLifePoints,this.usableMana,this.lifePoint,this.cardsInDeck);
    }
    public void actEnemyLife(int life){
        this.enemyLifePoints-=life;
        setTopElements(this.enemyLifePoints,this.usableMana,this.lifePoint,this.cardsInDeck);
    }
    public void actMyLife(int life){
        this.lifePoint-=life;
        setTopElements(this.enemyLifePoints,this.usableMana,this.lifePoint,this.cardsInDeck);
    }
    public void actCardInDeck(){
        this.cardsInDeck--;
        setTopElements(this.enemyLifePoints,this.usableMana,this.lifePoint,this.cardsInDeck);
    }

    private int executeCard(TypeCarta card){
        System.out.println(card.getType());
        if (card.getType().equals("Esbirro")){
            Esbirros esbirroEvent = new Esbirros(card);
            System.out.println(esbirroEvent.DmgEsbirro());
            System.out.println(this.eventRegister.getDamage());
            this.eventRegister.addDamage(esbirroEvent.DmgEsbirro());
            System.out.println(this.eventRegister.getDamage());
            actEnemyLife(this.eventRegister.getDamage());
            return esbirroEvent.DmgEsbirro();
        }
        if (card.getType().equals("Hechizo")) {
            System.out.println("Es un hechizo xdxdxd");
            return 1;
        }
        if (card.getType().equals("Secreto")){
            System.out.println("Shh secreto :v");
            return 1;
        }
        return 0;
    }

    private void addCartToSlot(){
        //toma carta del deck y la mete en un slot
    }

    private void card1Slot(TypeCarta card){
        this.isUsableCardSlot1 = false;
        CardHand cardHand1 = new CardHand(card,150);
        cardSlot1Pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (usableMana >= card.getCost()) {
                    System.out.println("Carta1");
                    actMana(card.getCost());
                    eventRegister.addDamage(executeCard(card));
                    cardSlot1Pane.getChildren().clear();
                    addToHistory(card);
                    addToTable(card);
                    isUsableCardSlot1 = true;
                    //deshabilitar
                }
            }
        });
        cardSlot1Pane.getChildren().add(cardHand1.getCardImg());
        this.myDeck.pop();

    }

    private void card2Slot(TypeCarta card){
        this.isUsableCardSlot2 = false;
        CardHand cardHand2 = new CardHand(card,150);
        cardSlot2Pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (usableMana >= card.getCost()) {
                    System.out.println("Carta2");
                    actMana(card.getCost());
                    eventRegister.addDamage(card.getDmg_fct());
                    //deshabilitar
                }
            }
        });
        cardSlot2Pane.getChildren().add(cardHand2.getCardImg());
        this.myDeck.pop();
    }

    private void card3Slot(TypeCarta card){
        this.isUsableCardSlot3 = false;
        CardHand cardHand3 = new CardHand(card,150);
        cardSlot3Pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (usableMana >= card.getCost()) {
                    System.out.println("Carta3");
                    actMana(card.getCost());
                    eventRegister.addDamage(card.getDmg_fct());
                    //deshabilitar
                }
            }
        });
        cardSlot3Pane.getChildren().add(cardHand3.getCardImg());
        this.myDeck.pop();

    }

    private void card4Slot(TypeCarta card){
        this.isUsableCardSlot4 = false;
        CardHand cardHand4 = new CardHand(card,150);
        cardSlot4Pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (usableMana >= card.getCost()) {
                    System.out.println("Carta4");
                    actMana(card.getCost());
                    eventRegister.addDamage(card.getDmg_fct());
                    //deshabilitar
                }
            }
        });
        cardSlot4Pane.getChildren().add(cardHand4.getCardImg());
        this.myDeck.pop();

    }

    private void card5Slot(TypeCarta card){
        this.isUsableCardSlot5 = false;
        CardHand cardHand5 = new CardHand(card,150);
        cardSlot5Pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (usableMana >= card.getCost()) {
                    System.out.println("Carta5");
                    actMana(card.getCost());
                    eventRegister.addDamage(card.getDmg_fct());
                    //deshabilitar
                }
            }
        });
        cardSlot5Pane.getChildren().add(cardHand5.getCardImg());
        this.myDeck.pop();

    }

    }

