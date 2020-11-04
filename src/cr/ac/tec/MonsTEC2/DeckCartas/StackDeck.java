package cr.ac.tec.MonsTEC2.DeckCartas;

import com.google.gson.Gson;
import cr.ac.tec.MonsTEC2.DeckCartas.CardTypes.TypeCarta;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class StackDeck {

//    private int m = 17;
//    private int maxSize = m;
//    private TypeCarta stackdeck[] = new TypeCarta[m];
//    //    Stack<Cartas> deck;
//    private int top;
////    private Image cardimg;

//    private LinkedList stackList;



//    public StackDeck() {
//    }

//    public StackDeck(TypeCarta[] stackdeck) {
//        this.stackdeck = stackdeck;
//    }

//    public StackDeck(LinkedList stackList) {
//        this.stackList = stackList;
//    }

//    public void push(TypeCarta data) {
//        if (top < maxSize){
//            this.stackdeck[++top] = data;
//        } else {
//            try {
//                throw new Exception("Stack full");
//            } catch (Exception e) {
//                e.printStackTrace();
//                }
//            }
//
////        stackdeck[top] = data;
////        top++;
//
//    }
//
//    public Object pop() {
//        return this.stackdeck[top--];
//    }
//
//    public Object peek() {
//        return this.stackdeck[top];
//    }

    private class Node {
        TypeCarta data;
        Node link;
    }
    Node top;

    public StackDeck() {
        this.top = null;
    }

    public void push (TypeCarta x){
        Node temp = new Node();

        if (temp == null){
            System.out.println("\nHeap Overflow");
            return;
        }
        temp.data = x;
        temp.link = top;
        top = temp;
    }
}
