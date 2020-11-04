package cr.ac.tec.MonsTEC.DeckCartas;

import com.google.gson.Gson;
import cr.ac.tec.MonsTEC.DeckCartas.CardTypes.TypeCarta;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Deckplayer {

    private Stack deck = new Stack();
    int randomCardsID;


    public Deckplayer() {
        TypeCarta[] tc = genAllCards(genListCards());

        while (deck.getCardCounter() <= 19) {
            randomCardsID = (int) (Math.random() * 40);
            for (int e = 0; e < 40; e++) {
                if (tc[e].getID() == randomCardsID) {
                    System.out.println(tc[e].getName());
                    deck.push(tc[e]);
                }
            }

        }

    }
    public Cartas genListCards(){
        String json = "";
        BufferedReader br;
        {
            try {
                br = new BufferedReader(new FileReader("AllCarts.json"));

                String linea = "";
                while ((linea = br.readLine()) != null) {
                    json += linea;
                }
                br.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Gson gson = new Gson();
        Cartas c = gson.fromJson(json, Cartas.class);
        return c;
    }

    public TypeCarta[] genAllCards(Cartas c){
        TypeCarta[] tc = c.getTcarta();
        return tc;
    }

    public Stack getDeck() {
        return deck;
    }

    /***
     * Agrega una cantidad X de cartas a un mazo
     * @param deck tiene que ser un objetivo tipo deck, ejemplo:
     *             si el nombre del deck es deckCartas, se tiene que pedirle
     *             el objeto que contiene las cartas mediante el método getDeck().
     *             Entonces quedaría deckCartas.getDeck().
     * @param cant Un número entero de la cantida de cartas que se desean agregar.
     *             Tome en cuenta que el conteo inica en 0, por lo que si desea
     *             agregar 3 cartas, deberá entrar ingresar un 2 o si quiere agregar
     *             9 cartas, ingresa un 8
     */
    public void addXCards(Stack deck, int cant){
        TypeCarta[] tc = genAllCards(genListCards());
        while(cant!=-1){
            randomCardsID = (int) (Math.random() * 40);
            System.out.println("Agregando:"+tc[randomCardsID].getName());
            deck.push(tc[randomCardsID]);
            cant--;
        }
    }
}


