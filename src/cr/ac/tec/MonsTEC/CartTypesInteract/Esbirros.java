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
     * @param vidaEnemigo Vida del enemigo, al cual se le restara el daño que hizo el esbirro
     */
    public Esbirros(TypeCarta c, int vidaEnemigo) {
        this.c = c;
        this.vidaEnemigo = vidaEnemigo;
        DmgEsbirro();
    }

    /**
     * Resta el daño que crea el esbirro a la vida del enemigo
     */
    private void DmgEsbirro() {
        vidaEnemigo -= c.getDmg_fct();
    }

}
