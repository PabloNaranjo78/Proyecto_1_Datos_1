package cr.ac.tec.MonsTEC.Tools;

import cr.ac.tec.MonsTEC.DeckCartas.CardTypes.TypeCarta;

/**
 * Creacion de Nodos
 */
public class Node {
    private TypeCarta thisCard;
    private Node prevCard;


    /**
     * Constructores
     * @param element TypeCarta
     */
    public Node (TypeCarta element){
        this.thisCard = element;
        this.prevCard = null;
    }

    /**
     * Getter de thisCard
     * @return TypeCarta thiscartd
     */
    public TypeCarta getThisCard() {
        return thisCard;
    }

    /**
     * Getter de prevCard
     * @return Node prevCard
     */
    public Node getPrevCard() {
        return prevCard;
    }

    /**
     * Setter de prevCard
     * @param prevCard Node
     */
    public void setPrevCard(Node prevCard) {
        this.prevCard = prevCard;
    }

}

