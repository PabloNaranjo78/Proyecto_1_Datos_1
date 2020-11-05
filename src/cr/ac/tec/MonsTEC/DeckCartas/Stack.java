package cr.ac.tec.MonsTEC.DeckCartas;

import cr.ac.tec.MonsTEC.Tools.Node;
import cr.ac.tec.MonsTEC.DeckCartas.CardTypes.TypeCarta;

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

    private void addCard(){
        this.cardCounter++;
    }
    private void restCard(){
        this.cardCounter--;
    }
    public int getCardCounter(){ return cardCounter;}
}
