package cr.ac.tec.MonsTEC.DeckCartas;

import cr.ac.tec.MonsTEC.DeckCartas.CardTypes.TypeCarta;

import java.util.Arrays;

/**
 * Objeto Cartas, a partir del cual se van a construir todas las cartas que se van a utilizar en el juego
 */
public class Cartas {

    private TypeCarta[] tcarta;

    /**
     * Constructor vacio, necesario para que el objeto sea un Plain Old Java Object(POJO)
     */
    public Cartas() {
    }

    /**
     * Costructor del objeto TypeCarta[]
     * @param tcarta Objeto tipo TypeCarta[]
     */
    public Cartas(TypeCarta[] tcarta) {
        this.tcarta = tcarta;
    }

    /**
     * Retorna al objeto tipo TypeCarta[], es necesario para cuando se quiera poder acceder a algun metodo
     * de TypeCarta[]
     * @return Objeto TypeCarta[]
     */
    public TypeCarta[] getTcarta() {
        return tcarta;
    }

    /**
     *Se crea una estructura para poder representar al los objetos TypeCarta[] para cuando se requiera
     * @return Representacion de como esta estructurado el array de objetos TypeCarta[]
     */
    @Override
    public String toString() {
        return "Cartas{" +
                "tcarta=" + Arrays.toString(tcarta) +
                '}';
    }
}
