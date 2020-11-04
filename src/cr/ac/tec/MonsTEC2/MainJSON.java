package cr.ac.tec.MonsTEC2;

import com.google.gson.Gson;
import cr.ac.tec.MonsTEC2.DeckCartas.CardTypes.TypeCarta;
import cr.ac.tec.MonsTEC2.DeckCartas.Cartas;
import cr.ac.tec.MonsTEC2.DeckCartas.Deckplayer;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import cr.ac.tec.MonsTEC2.DeckCartas.Deckplayer;
import cr.ac.tec.MonsTEC2.DeckCartas.Stack;


public class MainJSON {

    public static void main(String[] args) {



        Deckplayer deckp1 =  new Deckplayer();
   //     System.out.println(deckp1.getDeck().peek().getName());
        System.out.println(deckp1.getDeck().getCardCounter());
    //    deckp1.getDeck().pop();
    //    System.out.println(deckp1.getDeck().peek().getName());

//        Deckplayer deckp2 = new Deckplayer();
//        System.out.println(deckp2);
    }

}
