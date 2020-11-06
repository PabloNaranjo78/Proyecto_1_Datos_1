package cr.ac.tec.MonsTEC.CartTypesInteract;

import cr.ac.tec.MonsTEC.DeckCartas.Deckplayer;

/**
 * Se ejecutara los efectos que tengan las cartas tipo secretos al ser utilizados en el juego
 */
public class Secretos {
    String name;
    int vidaJugador, vidaEnemigo, cantidadCartas, i;
    Deckplayer deckplayer1, deckenemy;

    /**
     * Constructores de los objetos que se recibirian, junto a la ejecucion de las acciones de que provocaria el
     * secreto en la partida
     * @param name nombre de la carta que se usa en el juego
     * @param vidaJugador vida actual que tiene el jugador
     * @param vidaEnemigo vida actual que tiene el oponente
     * @param cantidadCartas cantidad de cartas del deck del jugador
     * @param deckplayer1 deck del jugador
     * @param deckenemy deck del oponente
     */
    public Secretos(String name, int vidaJugador, int vidaEnemigo, int cantidadCartas, Deckplayer deckplayer1, Deckplayer deckenemy) {
        this.name = name;
        this.vidaJugador = vidaJugador;
        this.vidaEnemigo = vidaEnemigo;
        this.cantidadCartas = cantidadCartas;
        this.deckplayer1 = deckplayer1;
        this.deckenemy = deckenemy;

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



    private void Invocaciongemela() {
        /*invoca carta igual que la de la ronda anterior*/

    }

    private void GolpeSuerte() {
        if (cantidadCartas<10){
            deckplayer1.pushXCards(deckplayer1.getDeck(),2);
        }
    }

    private void DanzaMal() {
        if (vidaEnemigo<200) {
            for (i = 0; i < 2; i++) {
                deckenemy.getDeck().pop();
            }
        }

    }

    private void DestruccionImprevisible() {
        if (vidaJugador < 300) {
        vidaEnemigo= vidaEnemigo -75;
        }
        else {
            for (i = 0; i < 2; i++) {
                deckenemy.getDeck().pop();
            }
        }
    }

    private void Corrupcion() {

        /*El siguiente turno enemigo, el daño que haga, se hará solo hacia él mismo*/

    }

    private void Triqueta() {

        if (vidaJugador < 50) {
            deckplayer1.pushXCards(deckplayer1.getDeck(),2);
            vidaJugador = vidaJugador +300;
            vidaEnemigo = vidaEnemigo - 30;
        }
    }

    private void Cataclismo() {

        /*Si en el turno enemigo se hizo más de 100 de daño, hará este mismo daño hacia el enemigo.*/

    }

    private void RuletaRusa() {
        int randomNum = (int) (Math.random() * 10);
        if (randomNum < 5) {
            vidaJugador = vidaJugador - 40;
        }
        else {
            vidaEnemigo = vidaEnemigo - 40;
        }
    }

    private void Sacrificio() {

        if (vidaJugador < 50) {
            for (i = 0; i < 2; i++) {
                deckenemy.getDeck().pop();
            }
            vidaJugador = vidaJugador + 200;
        }
    }

    private void PuñalBolsillo() {

        if (vidaEnemigo < 200) {
            vidaEnemigo=vidaEnemigo-80;
        }

    }

    private void MartilloPlataMaxwell() {

        if (deckplayer1.getDeck().getCardCounter() < 5 && vidaJugador < 300) {
            vidaEnemigo= vidaEnemigo - 50;
            for (i = 0; i < 2; i++) {
                deckenemy.getDeck().pop();
            }
        }
    }

    private void CampanaDivision() {

        if (vidaEnemigo < 100) {
            vidaEnemigo = 10;
        }

    }

    private void EscaleraCielo() {

        if (vidaEnemigo < 150 && vidaJugador < 150) {
            vidaEnemigo = 5;
        }

    }




}
