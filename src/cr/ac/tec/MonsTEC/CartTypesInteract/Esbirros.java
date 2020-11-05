package cr.ac.tec.MonsTEC.CartTypesInteract;

import com.google.gson.Gson;
import cr.ac.tec.MonsTEC.DeckCartas.CardTypes.TypeCarta;
import cr.ac.tec.MonsTEC.DeckCartas.Cartas;


public class Esbirros {
    int vidaEnemigo;
    TypeCarta c;

    public Esbirros(int vidaEnemigo, TypeCarta c) {
        this.vidaEnemigo = vidaEnemigo;
        this.c = c;

        DmgEsbirro();
    }
    private void DmgEsbirro() {
        vidaEnemigo = vidaEnemigo - c.getDmg_fct();
    }

}
