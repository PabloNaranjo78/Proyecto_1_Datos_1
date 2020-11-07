package cr.ac.tec.MonsTEC.LinkedList;

import cr.ac.tec.MonsTEC.DeckCartas.CardTypes.TypeCarta;
import cr.ac.tec.MonsTEC.Tools.Node;

public class DoublyLinkedList {

    Node node;

    public DoublyLinkedList(){

    }

    public void addNewCard (TypeCarta element){
        if (this.node == null){
            node = new Node(element);
        }
        else{
            Node newNode = new Node(element);
            newNode.setPrevCard(this.node);
            this.node = newNode;
        }
    }

    public TypeCarta getPrevCard(){
        return node.getPrevCard().getThisCard();
    }

    public TypeCarta getCard(){
        return this.node.getThisCard();
    }

    public TypeCarta getNextCard(){
        return this.node.getNextCard();
    }
}
