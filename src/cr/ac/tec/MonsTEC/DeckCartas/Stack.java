package cr.ac.tec.MonsTEC.DeckCartas;

import cr.ac.tec.MonsTEC.Tools.Node;
import cr.ac.tec.MonsTEC.DeckCartas.CardTypes.TypeCarta;


/**
 * Objeto Stack a partir del cual se crearan los deck que contendrán las cartas de cada jugador
 */
public class Stack {

    private Node node;
    private int cardCounter = 1;

    /**
     * Constructor del objeto nodo a partir del cual se ira a ir construyendo la stack
     */
    public Stack(){
        this.node = null;
    }

    /**
     * Metodo que agrega un elemento a la cima del stack, se consulta si el nodo que esta en la
     * cima del stack esta vacio, si este esta vacio, signfica que la pila estará vacia, por lo
     * que hara que el nodo vacio sea el elemento que se quiere agregar, pero si el nodo consultado
     * no esta vacio, entonces creará otro nodo y lo agregara encima de este.
     * @param element Elemento que irá a agregarse a la cima del stack
     */
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

    /**
     * Metodo que quita el elemento que esta en la parte superior del stack
     */
    public void pop(){
        restCard();
        this.node = this.node.getPrevCard();
    }

    /**
     * Metodo que retorna el elemento que esta en la parte superior del stack, sin quitar el mismo
     * @return Elemento que esta en la parte superior de la lista
     */
    public TypeCarta peek(){
        return this.node.getThisCard();
    }

    private void addCard(){
        this.cardCounter++;
    }

    private void restCard(){
        this.cardCounter--;
    }

    /**
     * Retorna la cantidad de catras que hay en el stack
     * @return Cantidad de cartas que hay en el stack
     */
    public int getCardCounter(){
        return cardCounter;
    }
}
