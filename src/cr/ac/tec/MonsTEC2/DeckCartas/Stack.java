package cr.ac.tec.MonsTEC2.DeckCartas;

import com.google.gson.Gson;
import cr.ac.tec.MonsTEC.Tools.Node;
import cr.ac.tec.MonsTEC2.DeckCartas.CardTypes.TypeCarta;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Stack {

    private Node node;
    private int cardCounter = 1;

    public Stack(){
        this.node = null;
    }

    public void push (TypeCarta element){
        if (this.node == null){
            node = new Node(element);
            addCard();

        }
        else{
            Node newNode = new Node(element);
            newNode.setPrevCard(this.node);
            this.node = newNode;
            addCard();
        }
    }

    public void pop(){
        restCard();
        this.node = this.node.getPrevCard();
    }

    public TypeCarta peek(){
        return this.node.getThisCard();
    }

    public void addCard(){
        this.cardCounter++;
    }
    public void restCard(){
        this.cardCounter--;
    }
    public int getCardCounter(){
        return cardCounter;
    }
}
