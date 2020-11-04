package cr.ac.tec.MonsTEC.Tools;

import com.sun.javafx.scene.control.skin.FXVK;
import cr.ac.tec.MonsTEC2.DeckCartas.CardTypes.TypeCarta;

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

