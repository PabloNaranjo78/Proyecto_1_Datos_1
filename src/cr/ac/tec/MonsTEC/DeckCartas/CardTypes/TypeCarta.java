package cr.ac.tec.MonsTEC.DeckCartas.CardTypes;

public class TypeCarta {

    private int ID;
    private String name;
    private int cost;
    private int dmg_fct;
    private String type;

    public TypeCarta(int ID, String name, int cost, int dmg_fct, String type) {
        this.ID = ID;
        this.name = name;
        this.cost = cost;
        this.dmg_fct = dmg_fct;
        this.type = type;
    }

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

    public int getDmg_fct() {
        return dmg_fct;
    }

    public void setDmg_fct(int dmg_fct) {
        this.dmg_fct = dmg_fct;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
