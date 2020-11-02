package cr.ac.tec.MonsTEC2.DeckCartas;

import com.google.gson.Gson;
import cr.ac.tec.MonsTEC2.DeckCartas.CardTypes.TypeEsbirros;
import cr.ac.tec.MonsTEC2.DeckCartas.CardTypes.TypeHechizos;
import cr.ac.tec.MonsTEC2.DeckCartas.CardTypes.TypeSecretos;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class DeckCartas {

    private int maxSize;
//    private Object[] deck;
    Stack<TypeEsbirros> deck;
    private int top;
    private Image cardimg;

    public DeckCartas(Stack<TypeEsbirros> deck) {
        this.deck = deck;
    }

    //   JSON ------------------------------------------------------------------------------

    public DeckCartas() {

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

        deck = new Stack<>();


        for (int i = 0 ; i < 4 ; i++) {
            deck.add(esb[i]);
        }
        System.out.println(deck.peek());
    }
    }

//    ------------------------------------------------------------------------------


//    public DeckCartas(Cartas[] deck) {
//        this.deck = deck;
//    }
//
//    public void push (Object newObject) {
//        if (top < maxSize){
//            this.deck[++top] = newObject;
//        } else {
//            try {
//                throw new Exception("Stack full");
//            } catch (Exception e) {
//                e.printStackTrace();
//                }
//            }
//        }
//    public Object pop() {
//        return this.deck[top--];
//    }
//    public Object peek() {
//        return this.deck[top];
//    }

//    public DeckCartas() {
//
//        Gson gson = new Gson();
//        Cartas c = gson.fromJson(json, Cartas.class);
//
//        TypeEsbirros[] esb = c.getEsbirro();
//        TypeSecretos[] secrt = c.getSecreto();
//        TypeHechizos[] hchiz = c.getHechizo();
//
//        for (int i = 0 ; i < 4 ; i++) {
//                deck.add(esb[i]);
//            }
//            System.out.println(deck.peek());


}
