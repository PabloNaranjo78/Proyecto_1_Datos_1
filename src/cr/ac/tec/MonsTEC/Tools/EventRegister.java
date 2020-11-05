package cr.ac.tec.MonsTEC.Tools;

public class EventRegister {

    String card = null;
    int life;
    int damage;
    //Falta uno para controlar eventos especiales


    public EventRegister() {
    }

    public void addDamage(int dmg){
        this.damage+=dmg;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "EventRegister{" +
                "card='" + card + '\'' +
                ", life=" + life +
                ", damage=" + damage +
                '}';
    }
}
