package cr.ac.tec.MonsTEC.Tools;

import cr.ac.tec.MonsTEC.DeckCartas.CardTypes.TypeCarta;

public class Node {
    private TypeCarta thisCard;
    private Node prevCard;



    public Node (TypeCarta element){
        this.thisCard = element;
        this.prevCard = null;
    }

    public TypeCarta getThisCard() {
        return thisCard;
    }

    public Node getPrevCard() {
        return prevCard;
    }

    public void setPrevCard(Node prevCard) {
        this.prevCard = prevCard;
    }

}

