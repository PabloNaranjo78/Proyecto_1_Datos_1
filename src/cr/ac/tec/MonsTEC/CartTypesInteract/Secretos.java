package cr.ac.tec.MonsTEC.CartTypesInteract;

import cr.ac.tec.MonsTEC.DeckCartas.CardTypes.TypeCarta;
import cr.ac.tec.MonsTEC.DeckCartas.Deckplayer;
import cr.ac.tec.MonsTEC.DeckCartas.Stack;
import cr.ac.tec.MonsTEC.Tools.EventRegister;

/**
 * Se ejecutara los efectos que tengan las cartas tipo secretos al ser utilizados en el juego
 */
public class Secretos {
    String name;
    int vidaJugador, vidaEnemigo, cantidadCartas, i;
    Deckplayer deckplayer1, deckenemy;
    EventRegister eventRegister;
    Deckplayer deckplayer;
    Stack myDeck;

    /**
     * Constructores de los objetos que se recibirian, junto a la ejecucion de las acciones de que provocaria el
     * secreto en la partida
     * @param card la carta que se usa en el juego
     * @param vidaJugador vida actual que tiene el jugador
     * @param vidaEnemigo vida actual que tiene el oponente
     * @param cantidadCartas cantidad de cartas del deck del jugador
     * @param eventRegister registro de eventos
     * @param deckplayer deck de cartas.
     */
    public Secretos(TypeCarta card, int vidaJugador, int vidaEnemigo,
                    int cantidadCartas, Stack myDeck, EventRegister eventRegister, Deckplayer deckplayer) {
        this.name = card.getName();
        this.vidaJugador = vidaJugador;
        this.vidaEnemigo = vidaEnemigo;
        this.cantidadCartas = cantidadCartas;
        this.eventRegister = eventRegister;
        this. deckplayer = deckplayer;
        this.myDeck = myDeck;
    }

    public void ejetCard(){
        if (name == "Invocacion gemela"){
            Invocaciongemela();}
        if (name == "Golpe de suerte"){
            GolpeSuerte();}
        if (name == "Danza del mal"){
            DanzaMal();}
        if (name == "Destruccion imprevisible"){
            DestruccionImprevisible();}
        if (name == "Corrupcion"){
            Corrupcion();}
        if (name == "Triqueta"){
            Triqueta();}
        if (name == "Cataclismo"){
            Cataclismo();}
        if (name == "Ruleta rusa"){
            RuletaRusa();}
        if (name == "Sacrificio"){
            Sacrificio();}
        if (name ==  "Puñal de bolsillo"){
            PuñalBolsillo();}
        if (name ==  "Martillo de plata de Maxwell"){
            MartilloPlataMaxwell();}
        if (name ==  "Campana de la division"){
            CampanaDivision();}
        if (name ==  "Escalera al cielo"){
            EscaleraCielo();}

    }

/*Funciones de cartas Secreto*/
    private void Invocaciongemela() {
        /*invoca carta igual que la de la ronda anterior*/

    }

    private void GolpeSuerte() {
        if (cantidadCartas<10){
            deckplayer.pushXCards(myDeck,2);
        }
    }

    private void DanzaMal() {
        if (vidaEnemigo<200) {
            for (i = 0; i < 2; i++) {
                //Elimina dos cartas al enemigo
            }
        }

    }

    private void DestruccionImprevisible() {
        if (vidaJugador < 300) {
            eventRegister.addDamage(75);
        }
        else {
            for (i = 0; i < 2; i++) {
                //Elimina dos caras enemigas
            }
        }
    }

    private void Corrupcion() {

        /*El siguiente turno enemigo, el daño que haga, se hará solo hacia él mismo*/

    }

    private void Triqueta() {

        if (vidaJugador < 50) {
            deckplayer.pushXCards(myDeck,3);
            eventRegister.heal(300);
            eventRegister.addDamage(30);
        }
    }

    private void Cataclismo() {

        /*Si en el turno enemigo se hizo más de 100 de daño, hará este mismo daño hacia el enemigo.*/

    }

    private void RuletaRusa() {
        int randomNum = (int) (Math.random() * 10);
        if (randomNum < 5) {
            eventRegister.heal(-40);
        }
        else {
            eventRegister.addDamage(40);
        }
    }

    private void Sacrificio() {

        if (vidaJugador < 50) {
                deckplayer.popXCard(myDeck,2);
                eventRegister.heal(200);
        }
    }

    private void PuñalBolsillo() {

        if (vidaEnemigo < 200) {
            eventRegister.addDamage(80);
        }

    }

    private void MartilloPlataMaxwell() {

        if (deckplayer1.getDeck().getCardCounter() < 5 && vidaJugador < 300) {
            eventRegister.addDamage(50);
            for (i = 0; i < 2; i++) {
                //Elimina 2 cartas
            }
        }
    }

    private void CampanaDivision() {

        if (vidaEnemigo < 100) {
            while ((vidaEnemigo - eventRegister.getDamage())<10){
                eventRegister.addDamage(1);
            }
        }
    }

    private void EscaleraCielo() {

        if (vidaEnemigo < 150 && vidaJugador < 150) {
            while ((vidaEnemigo - eventRegister.getDamage())<5){
                eventRegister.addDamage(1);
        }

    }


}}
