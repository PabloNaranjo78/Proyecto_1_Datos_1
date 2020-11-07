package cr.ac.tec.MonsTEC.LinkedList;

import cr.ac.tec.MonsTEC.DeckCartas.CardTypes.TypeCarta;
import cr.ac.tec.MonsTEC.Tools.Node;

public class LinkedListHistory {
    private Node node;

    /***
     * Crea la lista enlezada
     */
    public LinkedListHistory(){
        this.node = null;
    }

    /***
     * Añade una carta nueva
     * @param element Carta a añadir
     */
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

    /***
     * Retorna la carta previa
     * @return La carta previa
     */
    public TypeCarta getPrevCard(){
        return node.getPrevCard().getThisCard();
    }

    /***
     * Retorna la carta seleccionada
     * @return La carta en este estado
     */
    public TypeCarta getCard(){
        return this.node.getThisCard();
    }


}
