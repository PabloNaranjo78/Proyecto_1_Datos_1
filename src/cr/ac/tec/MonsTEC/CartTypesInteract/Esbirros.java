package cr.ac.tec.MonsTEC.CartTypesInteract;

import cr.ac.tec.MonsTEC.DeckCartas.CardTypes.TypeCarta;

/**
 * Se ejecutara los efectos que tengan las cartas tipo esbirro al ser utilizadas en el juego
 */
public class Esbirros {
    TypeCarta c;
    int vidaEnemigo;

    /**
     * Constructores de c y vida enemigo, junto a la ejecucion del daño de que provocaria el
     * esbirro a la vida enemiga
     * @param c Carta Esbirro que se estaria usando en el juego
     */
    public Esbirros(TypeCarta c) {
        this.c = c;
    }

    /**
     * Devuelve el daño que hace la carta
     */
    public int DmgEsbirro() {
        return this.c.getDmg_fct();
    }

}
