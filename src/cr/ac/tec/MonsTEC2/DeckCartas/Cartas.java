package cr.ac.tec.MonsTEC2.DeckCartas;

import cr.ac.tec.MonsTEC2.DeckCartas.CardTypes.TypeEsbirros;
import cr.ac.tec.MonsTEC2.DeckCartas.CardTypes.TypeHechizos;
import cr.ac.tec.MonsTEC2.DeckCartas.CardTypes.TypeSecretos;

import java.util.Arrays;

public class Cartas {

    private TypeEsbirros[] Esbirro;
    private TypeSecretos[] Secreto;
    private TypeHechizos[] Hechizo;

    public Cartas() {
    }

    public Cartas(TypeEsbirros[] esbirro, TypeSecretos[] secreto, TypeHechizos[] hechizo) {
        Esbirro = esbirro;
        Secreto = secreto;
        Hechizo = hechizo;
    }

    public TypeEsbirros[] getEsbirro() {
        return Esbirro;
    }

    public void setEsbirro(TypeEsbirros[] esbirro) {
        Esbirro = esbirro;
    }

    public TypeSecretos[] getSecreto() {
        return Secreto;
    }

    public void setSecreto(TypeSecretos[] secreto) {
        Secreto = secreto;
    }

    public TypeHechizos[] getHechizo() {
        return Hechizo;
    }

    public void setHechizo(TypeHechizos[] hechizo) {
        Hechizo = hechizo;
    }

    @Override
    public String toString() {
        return "Cartas{" +
                "Esbirro=" + Arrays.toString(Esbirro) +
                ", Secreto=" + Arrays.toString(Secreto) +
                ", Hechizo=" + Arrays.toString(Hechizo) +
                '}';
    }

}
