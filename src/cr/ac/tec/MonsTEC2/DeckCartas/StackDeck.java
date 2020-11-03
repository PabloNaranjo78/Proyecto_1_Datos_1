package cr.ac.tec.MonsTEC2.DeckCartas;

import com.google.gson.Gson;
import cr.ac.tec.MonsTEC2.DeckCartas.CardTypes.TypeCarta;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StackDeck {

    private int maxSize = 17;
    private TypeCarta stackdeck[] = new TypeCarta[17];
    //    Stack<Cartas> deck;
    private int top;
//    private Image cardimg;


    //   JSON ------------------------------------------------------------------------------


    public StackDeck() {
    }

    public StackDeck(TypeCarta[] stackdeck) {
        this.stackdeck = stackdeck;
    }

    public void push(TypeCarta data) {
        if (top < maxSize){
            this.stackdeck[++top] = data;
        } else {
            try {
                throw new Exception("Stack full");
            } catch (Exception e) {
                e.printStackTrace();
                }
            }

//        stackdeck[top] = data;
//        top++;

    }

    public Object pop() {
        return this.stackdeck[top--];
    }

    public Object peek() {
        return this.stackdeck[top];
    }


}
