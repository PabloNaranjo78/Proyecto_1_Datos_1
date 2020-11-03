package cr.ac.tec.MonsTEC2.DeckCartas;

import com.google.gson.Gson;
import cr.ac.tec.MonsTEC2.DeckCartas.CardTypes.TypeEsbirros;
import cr.ac.tec.MonsTEC2.DeckCartas.CardTypes.TypeHechizos;
import cr.ac.tec.MonsTEC2.DeckCartas.CardTypes.TypeSecretos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FromJSON {
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

        Gson gson = new Gson();
        Cartas c = gson.fromJson(json, Cartas.class);

        TypeEsbirros[] esb = c.getEsbirro();
        TypeSecretos[] secrt = c.getSecreto();
        TypeHechizos[] hchiz = c.getHechizo();

//        deck = new Stack<>();
        DeckCartas deck1 = new DeckCartas();

        for (int i = 0 ; i < 4 ; i++) {
//            deck.add(esb[i]);
//            deck.add(secrt[i]);
            deck1.push(515);
        }
        System.out.println("yep");
    }
}

