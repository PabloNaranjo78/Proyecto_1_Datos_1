package cr.ac.tec.MonsTEC2.DeckCartas;

import cr.ac.tec.MonsTEC2.DeckCartas.CardTypes.TypeCarta;

import java.util.Arrays;

public class Cartas {

    private TypeCarta[] tcarta;

    public Cartas() {
    }

    public Cartas(TypeCarta[] tcarta) {
        this.tcarta = tcarta;
    }

    public TypeCarta[] getTcarta() {
        return tcarta;
    }

    public void setTcarta(TypeCarta[] tcarta) {
        this.tcarta = tcarta;
    }

    @Override
    public String toString() {
        return "Cartas{" +
                "Carta=" + Arrays.toString(tcarta) +
                '}';
    }

}
