package cr.ac.tec.MonsTEC.CartTypesInteract;

import cr.ac.tec.MonsTEC.DeckCartas.Cartas;
import cr.ac.tec.MonsTEC.DeckCartas.Deckplayer;

/**
 * Se ejecutara los efectos que tengan las cartas tipo hechizos al ser utilizados en el juego
 */
public class Hechizos {

    String name;
    int vidaJugador, vidaEnemigo, cantidadCartas, manaPlayer, manaEnemy;
    Deckplayer deckPlayer1, deckEnemy;

    /**
     * Constructores de los objetos que se recibirian, junto a la ejecucion de las acciones de que provocaria el
     * hechizo en la partida
     * @param name nombre de la carta que se usa en el juego
     * @param vidaJugador vida actual que tiene el jugador
     * @param vidaEnemigo vida actual que tiene el oponente
     * @param cantidadCartas cantidad de cartas del deck del jugador
     * @param manaPlayer cantidad de mana que tiene el jugador
     * @param manaEnemy cantidad de mana que tiene el oponente
     * @param deckPlayer1 deck del jugador
     * @param deckEnemy deck del oponente
     */
    public Hechizos(String name, int vidaJugador, int vidaEnemigo, int cantidadCartas, int manaPlayer, int manaEnemy, Deckplayer deckPlayer1, Deckplayer deckEnemy) {
        this.name = name;
        this.vidaJugador = vidaJugador;
        this.vidaEnemigo = vidaEnemigo;
        this.cantidadCartas = cantidadCartas;
        this.manaPlayer = manaPlayer;
        this.manaEnemy = manaEnemy;
        this.deckPlayer1 = deckPlayer1;
        this.deckEnemy = deckEnemy;

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

    private void DañoInstantaneo() {
        vidaEnemigo -= 30;
    }

    private void Congelar() {
        /*Imposibilita al enemigo de usar cartas por un turno*/
    }

    private void Curar() {
        vidaJugador += 30;
    }

    private void PoderSupremo() {
        /*Puede tirar 3 cartas seguidas en el siguiente turno, sin importar el maná*/
    }

    private void RobarCarta() {/*Roba una carta del deck enemigo*/
         deckPlayer1.getDeck().push(deckEnemy.getDeck().peek());
         deckEnemy.getDeck().pop();
    }

    private void Quemar() {

        /*Hace 10 de daño por turno al enemigo en 3 rondas.*/
    }

    private void Electrificar() {

        vidaEnemigo -= 20;
    }

    private void Veneno() {

        /*En las siguientes partidas, hará 5 de daño cada que el enemigo lance una carta*/
    }

    private void FuegoSalvaje() {

        vidaEnemigo -= 100;
        vidaJugador -= 100;
    }

    private void DobleHoja() {
        vidaJugador += 50;
        vidaEnemigo -= 50;
    }

    private void RoboMana() {
        int prcnt = (int) (manaEnemy * 0.10);
        manaEnemy -= prcnt;
        manaPlayer += prcnt;
    }

    private void MultiplicacionDaño() {

        /*Aumenta el daño que cada carta efectúa a la vida del oponente por dos turnos*/
    }

    private void MaldicionOscura() {

        /*Reduce el porcentaje de recuperación de maná del oponente por 2 turnos*/
    }
}
