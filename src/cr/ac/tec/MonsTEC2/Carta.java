package cr.ac.tec.MonsTEC2;

public class Carta {

    private String name;
    private String type;
    private int cost;
    private int dmg;

    public Carta() {
    }

    public Carta(String name, String type, int cost, int dmg) {
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.dmg = dmg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", cost=" + cost +
                ", dmg=" + dmg +
                '}';
    }

}
