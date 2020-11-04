package cr.ac.tec.MonsTEC.DeckCartas;


public class MainJSON {

    public static void main(String[] args) {



        Deckplayer deckp1 =  new Deckplayer();
        System.out.println(deckp1.getDeck().getCardCounter());
        deckp1.addXCards(deckp1.getDeck(),9); //Ejemplo de agregado de 10 cartas
        System.out.println(deckp1.getDeck().getCardCounter());
    }

}
