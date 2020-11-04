package cr.ac.tec.MonsTEC2.DeckCartas;

import com.google.gson.Gson;
import cr.ac.tec.MonsTEC2.DeckCartas.CardTypes.TypeCarta;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Deckplayer {

    private Stack deck = new Stack();
    int randomCardsID;


    public Deckplayer() {

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

        TypeCarta[] tc = c.getTcarta();


        while (deck.getCardCounter() <= 20) {
            randomCardsID = (int) (Math.random() * 40);
            for (int e = 0; e < 40; e++) {
                if (tc[e].getID() == randomCardsID) {
                    System.out.println(tc[e].getName());
                    deck.push(tc[e]);
                }
            }

        }

        deck.pop(); //Este pop es porque por alguna razón crea una carta extra con la última duplicada

    }

    public Stack getDeck() {
        return deck;
    }
}


