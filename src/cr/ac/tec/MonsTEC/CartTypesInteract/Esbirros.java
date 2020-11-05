package cr.ac.tec.MonsTEC.CartTypesInteract;

import cr.ac.tec.MonsTEC.DeckCartas.CardTypes.TypeCarta;


public class Esbirros {
    TypeCarta c;

    public Esbirros(TypeCarta c) {
        this.c = c;

        DmgEsbirro();
    }
    public int DmgEsbirro() {
        return c.getDmg_fct();
    }

}
