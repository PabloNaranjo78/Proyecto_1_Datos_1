package cr.ac.tec.MonsTEC.CartTypesInteract;

import cr.ac.tec.MonsTEC.DeckCartas.CardTypes.TypeCarta;
import cr.ac.tec.MonsTEC.DeckCartas.Deckplayer;
import cr.ac.tec.MonsTEC.DeckCartas.Stack;
import cr.ac.tec.MonsTEC.Tools.EventRegister;

/**
 * Se ejecutara los efectos que tengan las cartas tipo hechizos al ser utilizados en el juego
 */
public class Hechizos {

    String name;
    int vidaJugador, vidaEnemigo, cantidadCartas, manaPlayer, manaEnemy;
    Stack myDeck;
    Deckplayer deckplayer;
    EventRegister eventRegister;

    /**
     * Constructores de los objetos que se recibirian, junto a la ejecucion de las acciones de que provocaria el
     * hechizo en la partida
     * @param card Objeto de carta.
     * @param vidaJugador vida actual que tiene el jugador
     * @param vidaEnemigo vida actual que tiene el oponente
     * @param cantidadCartas cantidad de cartas del deck del jugador
     * @param manaPlayer cantidad de mana que tiene el jugador
     */
    public Hechizos(TypeCarta card, int vidaJugador, int vidaEnemigo, int cantidadCartas,
                    int manaPlayer, Stack myDeck, EventRegister eventRegister,Deckplayer deckplayer) {
        this.name = card.getName();
        this.vidaJugador = vidaJugador;
        this.vidaEnemigo = vidaEnemigo;
        this.cantidadCartas = cantidadCartas;
        this.manaPlayer = manaPlayer;
        this.myDeck = myDeck;
        this.eventRegister = eventRegister;
        this.deckplayer = deckplayer;

    }

    /***
     * Ejecuta las cartas
     */
    public void ejecCard(){
        if (name == "Daño instantaneo"){
            DañoInstantaneo();}
        if (name == "Congelar"){
            Congelar();}
        if (name == "Curar"){
            Curar();}
        if (name == "Poder supremo"){
            PoderSupremo();}
        if (name == "Robar carta"){
            RobarCarta();}
        if (name == "Quemar"){
            Quemar();}
        if (name == "Electrificar"){
            Electrificar();}
        if (name == "Veneno"){
            Veneno();}
        if (name == "Fuego salvaje"){
            FuegoSalvaje();}
        if (name == "Doble hoja"){
            DobleHoja();}
        if (name == "Robo de mana"){
            RoboMana();}
        if (name == "Multiplicacion de daño"){
            MultiplicacionDaño();}
        if (name == "Maldicion oscura"){
            MaldicionOscura();}
    }
/*Funciones de cartas*/
    private void DañoInstantaneo() {
        this.eventRegister.addDamage(30);
    }

    private void Congelar() {
        /*Imposibilita al enemigo de usar cartas por un turno*/
    }

    private void Curar() {
        eventRegister.heal(100);
    }

    private void PoderSupremo() {
        /*Puede tirar 3 cartas seguidas en el siguiente turno, sin importar el maná*/
    }

    private void RobarCarta() {
        deckplayer.popXCard(myDeck,1);
    }

    private void Quemar() {
        this.eventRegister.addDamage(10);
        /*Hace 10 de daño por turno al enemigo en 3 rondas.*/
    }

    private void Electrificar() {
        this.eventRegister.addDamage(20);
    }

    private void Veneno() {
        this.eventRegister.addDamage(15);
        /*En las siguientes partidas, hará 5 de daño cada que el enemigo lance una carta*/
    }

    private void FuegoSalvaje() {
        this.eventRegister.addDamage(100);
        this.eventRegister.heal(-100);
    }

    private void DobleHoja() {
        this.eventRegister.addDamage(50);
        this.eventRegister.heal(50);
    }

    private void RoboMana() {
        this.eventRegister.addXMana(100);
    }

    private void MultiplicacionDaño() {

        /*Aumenta el daño que cada carta efectúa a la vida del oponente por dos turnos*/
    }

    private void MaldicionOscura() {

        /*Reduce el porcentaje de recuperación de maná del oponente por 2 turnos*/
    }
}
