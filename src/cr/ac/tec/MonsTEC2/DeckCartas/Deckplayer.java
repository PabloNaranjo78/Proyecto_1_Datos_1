package cr.ac.tec.MonsTEC2.DeckCartas;

import com.google.gson.Gson;
import cr.ac.tec.MonsTEC2.DeckCartas.CardTypes.TypeCarta;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Deckplayer {

    private StackDeck deck = new StackDeck();

//    public Deckplayer(StackDeck deck) {
//        this.deck = deck;
//    }

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

//        StackDeck deck = new StackDeck();
//        deck.push(tc[5]);
//        System.out.println(deck);

//        for (int i = 0; i < 10; i++) {

//            deck.push(tc[i]);
            deck.push(tc[0]);
            deck.push(tc[1]);
            deck.push(tc[2]);
            System.out.println(deck);

//            System.out.println("yep"+ i);
//        }
    }

}

