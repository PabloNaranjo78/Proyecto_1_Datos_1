package cr.ac.tec.MonsTEC2.DeckCartas.CardTypes;

public class TypeSecretos {

    private int ID;
    private String name;
    private int cost;
    private String dmg_fct;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDmg_fct() {
        return dmg_fct;
    }

    public void setDmg_fct(String dmg_fct) {
        this.dmg_fct = dmg_fct;
    }
}