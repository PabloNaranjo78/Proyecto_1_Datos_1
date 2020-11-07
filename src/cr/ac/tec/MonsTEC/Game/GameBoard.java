package cr.ac.tec.MonsTEC.Game;

import com.google.gson.Gson;
import cr.ac.tec.MonsTEC.CartTypesInteract.Esbirros;
import cr.ac.tec.MonsTEC.CartTypesInteract.Hechizos;
import cr.ac.tec.MonsTEC.CartTypesInteract.Secretos;
import cr.ac.tec.MonsTEC.DeckCartas.CardTypes.TypeCarta;
import cr.ac.tec.MonsTEC.DeckCartas.Deckplayer;
import cr.ac.tec.MonsTEC.DeckCartas.Stack;
import cr.ac.tec.MonsTEC.LinkedList.LinkedListHistory;
import cr.ac.tec.MonsTEC.ServerSockets.ServerController;
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
    int totalMana = 500;
    int usableMana = 500;

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
    public Label enemyLifePointsLabel  = new Label("Vida Enemiga: "+enemyLifePoints);
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

    Gson gson = new Gson();

    static EventRegister inEventRegister;

    LinkedListHistory linkedListHistory = new LinkedListHistory();

    /***
     * Game Board es el tablero de juego donde se muestran e interactúa con las cartas del juego
     * @param stage stage de java fx para controlar ventanas.
     * @param serverController controlador del servidor hecho a partir de sockets
     */
    public GameBoard(Stage stage, ServerController serverController){
        this.myDeckGen = new Deckplayer();
        this.myDeck = myDeckGen.getDeck();
        checkInData();

        Button sendButton = new Button("Ceder turno");
        Button takeCardFromDeckButton = new Button("Tomar una carta");
        Button actDataButton = new Button("Actualizar");
        actDataButton.setLayoutX(850);
        actDataButton.setLayoutY(70);
        sendButton.setLayoutX(900);
        takeCardFromDeckButton.setLayoutX(800);

        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            /***
             * Ejecutado por el botón de envíar, envía la información al enemigo para que sea interpretada
             * por medio de un string en formato Json.
             * También limpia el tablero.
             */
            public void handle(ActionEvent actionEvent) {
                String outData = gson.toJson(eventRegister);
                System.out.println(outData);
                serverController.sendData(outData);
                eventRegister.cleanEventRegister();
                cardsInTable.getChildren().clear();
            }
        });

        takeCardFromDeckButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            /***
             * Toma una carta del Stack de cartas, revisa que no esté vacía también.
             */
            public void handle(ActionEvent actionEvent) {
                if (cardsInDeck > 0){
                    addCartToSlot(myDeck.peek());
                }
            }
        });

        actDataButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            /***
             * Refresca la información enviada por el enemigo.
             */
            public void handle(ActionEvent actionEvent) {
                actGameBoard();
            }
        });

        //Añade 4 cartas iniciales.
        card1Slot(myDeck.peek());
        card2Slot(myDeck.peek());
        card3Slot(myDeck.peek());
        card4Slot(myDeck.peek());

    /*Elementos gráficos*/
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
                cardSlot3Pane,cardSlot4Pane,cardSlot5Pane,actDataButton);

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

    /***
     * Añade una carta al tablero central
     * @param card objeto tipo carta que se desea poner en el tablero
     */
    public void addToTable(TypeCarta card){
        CardHand card1 = new CardHand(card,90);
        cardsInTable.getChildren().add(card1.getCardImg());
    }

    /***
     * Añade una carta al historial y a la lista enlazada de Historial de cartas.
     * @param card objeto tipo carta que se desea añador
     */
    private void addToHistory(TypeCarta card){
        linkedListHistory.addNewCard(card);
        CardHand card1 = new CardHand(card,90);
        cardHistoryBox.getChildren().add(card1.getCardImg());
    }

    /***
     * Actualiza los elementos del panel superior.
     * @param enemyLifePoints   Puntos de vida enemigos
     * @param usableMana    mana utilizable
     * @param lifePoint puntos de vida
     * @param cardsInDeck número de cartas restantes en el deck
     */
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

    /***
     * Actualiza el mamá del jugador
     * @param mana entero con el valor que se desea actualizar el maná.
     */
    public void actMana(int mana){
        this.usableMana-=mana;
        this.usableMana += eventRegister.getMana();
        eventRegister.setMana(0);
        setTopElements(this.enemyLifePoints,this.usableMana,this.lifePoint,this.cardsInDeck);
    }

    /***
     * Actualiza la vida enemiga
     * @param life vida enemiga
     */
    public void actEnemyLife(int life){
        System.out.println(life+"   " +enemyLifePoints);
        this.enemyLifePoints-=life;
        System.out.println(life+"   " +enemyLifePoints);
        setTopElements(this.enemyLifePoints,this.usableMana,this.lifePoint,this.cardsInDeck);
    }

    /***
     * Actualiza la vida del jugador
     * @param life vida del jugador
     */
    public void actMyLife(int life){
        this.lifePoint += eventRegister.getHealLife();
        this.lifePoint-=life;
        eventRegister.setHealLife();
        setTopElements(this.enemyLifePoints,this.usableMana,this.lifePoint,this.cardsInDeck);
    }

    /***
     * Actualiza la cantidad de cartas en el deck
     */
    public void actCardInDeck(){
        this.cardsInDeck--;
        setTopElements(this.enemyLifePoints,this.usableMana,this.lifePoint,this.cardsInDeck);
    }

    /***
     * Actualiza el mamá total a cada inicio de partida, aumentándolo un 25% en cada partida.
     */
    public void actTotalMana(){
        this.usableMana = this.totalMana;
        if (totalMana < 1500){
            this.usableMana+= this.totalMana*0.25f;}
        this.totalMana = this.usableMana;
        actMana(0);
    }
///////////////////////////////////////////////////////////////////////////////////////

    /***
     * Ejecuta una carta
     * @param card Objeto tipo carta que se desea ejecutar
     * @return  Un entero en caso de que sea un esbirro.
     */
    private int executeCard(TypeCarta card){
        System.out.println(card.getType());
        if (card.getType().equals("Esbirro")){
            Esbirros esbirroEvent = new Esbirros(card);
            System.out.println(esbirroEvent.DmgEsbirro());
            System.out.println(this.eventRegister.getDamage());
            System.out.println(this.eventRegister.getDamage());
            actEnemyLife(card.getDmg_fct());
            return esbirroEvent.DmgEsbirro();
        }
        if (card.getType().equals("Hechizo")) {
            Hechizos hechizoEvent = new Hechizos(card,lifePoint,enemyLifePoints,cardsInDeck,usableMana,myDeck,eventRegister,myDeckGen);
            hechizoEvent.ejecCard();
            actMana(0);
            actMyLife(0);
            actEnemyLife(0);
            return 0;
        }
        if (card.getType().equals("Secreto")){
            Secretos secretoEvent = new Secretos(card,lifePoint,enemyLifePoints,cardsInDeck,myDeck,
                    eventRegister,myDeckGen);
            secretoEvent.ejetCard();
            actMana(0);
            actMyLife(0);
            actEnemyLife(0);
            return 0;
        }
        return 0;
    }

    /***
     * Busca un slot disponible en el tablero para agregar una carta nueva
     * @param card carda a añadir tipo TypeCard
     */
    private void addCartToSlot(TypeCarta card){
        if(cardsInDeck > 0){
            boolean isInHand = false;
        if (this.isUsableCardSlot1 && !(isInHand)){
            isInHand = true;
            actCardInDeck();
            card1Slot(card);
        }
        if(this.isUsableCardSlot2 && !(isInHand)){
            isInHand = true;
            actCardInDeck();
            card2Slot(card);
        }
        if(this.isUsableCardSlot3 && !(isInHand)){
            isInHand = true;
            actCardInDeck();
            card3Slot(card);
        }
        if(this.isUsableCardSlot4 && !(isInHand)){
            isInHand = true;
            actCardInDeck();
            card4Slot(card);
        }
        if (this.isUsableCardSlot5 && !(isInHand)){
            actCardInDeck();
            card5Slot(card);
        }
        else {
            System.out.println("Slot lleno");
        }}
    }

    /***
     * Slot 1 para cartas
     * @param card objeto tipo carta
     */
    private void card1Slot(TypeCarta card){
        this.isUsableCardSlot1 = false;
        CardHand cardHand1 = new CardHand(card,150);
        cardSlot1Pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (usableMana >= card.getCost() && !(isUsableCardSlot1)) {
                    System.out.println("Carta1");
                    actMana(card.getCost());
                    eventRegister.addDamage(executeCard(card));
                    cardSlot1Pane.getChildren().clear();
                    addToHistory(card);
                    addToTable(card);
                    isUsableCardSlot1 = true;
                }
            }
        });
        cardSlot1Pane.getChildren().add(cardHand1.getCardImg());
        this.myDeck.pop();

    }
    /***
     * Slot 2 para cartas
     * @param card objeto tipo carta
     */
    private void card2Slot(TypeCarta card){
        this.isUsableCardSlot2 = false;
        CardHand cardHand2 = new CardHand(card,150);
        cardSlot2Pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (usableMana >= card.getCost()) {
                    System.out.println("Carta2");
                    actMana(card.getCost());
                    eventRegister.addDamage(executeCard(card));
                    cardSlot2Pane.getChildren().clear();
                    addToHistory(card);
                    addToTable(card);
                    isUsableCardSlot2 = true;
                }
            }
        });
        cardSlot2Pane.getChildren().add(cardHand2.getCardImg());
        this.myDeck.pop();
    }
    /***
     * Slot 3 para cartas
     * @param card objeto tipo carta
     */
    private void card3Slot(TypeCarta card){
        this.isUsableCardSlot3 = false;
        CardHand cardHand3 = new CardHand(card,150);
        cardSlot3Pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (usableMana >= card.getCost()) {
                    System.out.println("Carta3");
                    actMana(card.getCost());
                    eventRegister.addDamage(executeCard(card));
                    cardSlot3Pane.getChildren().clear();
                    addToHistory(card);
                    addToTable(card);
                    isUsableCardSlot3 = true;
                }
            }
        });
        cardSlot3Pane.getChildren().add(cardHand3.getCardImg());
        this.myDeck.pop();
    }
    /***
     * Slot 4 para cartas
     * @param card objeto tipo carta
     */

    private void card4Slot(TypeCarta card){
        this.isUsableCardSlot4 = false;
        CardHand cardHand4 = new CardHand(card,150);
        cardSlot4Pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (usableMana >= card.getCost()) {
                    System.out.println("Carta4");
                    actMana(card.getCost());
                    eventRegister.addDamage(executeCard(card));
                    cardSlot4Pane.getChildren().clear();
                    addToHistory(card);
                    addToTable(card);
                    isUsableCardSlot4 = true;
                }
            }
        });
        cardSlot4Pane.getChildren().add(cardHand4.getCardImg());
        this.myDeck.pop();

    }
    /***
     * Slot 5 para cartas
     * @param card objeto tipo carta
     */

    private void card5Slot(TypeCarta card){
        this.isUsableCardSlot5 = false;
        CardHand cardHand5 = new CardHand(card,150);
        cardSlot5Pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (usableMana >= card.getCost()) {
                    System.out.println("Carta5");
                    actMana(card.getCost());
                    eventRegister.addDamage(executeCard(card));
                    cardSlot5Pane.getChildren().clear();
                    addToHistory(card);
                    addToTable(card);
                    isUsableCardSlot5 = true;
                }
            }
        });
        cardSlot5Pane.getChildren().add(cardHand5.getCardImg());
        this.myDeck.pop();

    }

    /***
     * Thread que está contantemente revisando si hay información entrante por los sockets
     */
    public void checkInData(){
        Thread actDataThread = new Thread(()->  {
            while(true){
                if (ServerController.getFlag()){
                    String inData = ServerController.getNewData();
                    ServerController.setFlagFalse();
                    this.inEventRegister = gson.fromJson(inData,EventRegister.class);
                    System.out.println("daño: "+inEventRegister.getDamage());
                }
                else{
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }}
                }

        });
        actDataThread.start();

    }

    /***
     * Actualiza los datos del juego cuando hay información entrante nueva
     */
    public void actGameBoard(){
        try {
            actMyLife(this.inEventRegister.getDamage());
            actTotalMana();
        }catch (Exception e){}

    }

}


