package cr.ac.tec.MonsTEC.DeckCartas;

import cr.ac.tec.MonsTEC.DeckCartas.CardTypes.TypeCarta;

import java.util.Arrays;

public class Cartas {

    private TypeCarta[] tcarta;

//    Constructors

    public Cartas() {
    }

    public Cartas(TypeCarta[] tcarta) {
        this.tcarta = tcarta;
    }

//    Get & Set

    public TypeCarta[] getTcarta() {
        return tcarta;
    }

    public void setTcarta(TypeCarta[] tcarta) {
        this.tcarta = tcarta;
    }

    @Override
    public String toString() {
        return "Cartas{" +
                "tcarta=" + Arrays.toString(tcarta) +
                '}';
    }



}
