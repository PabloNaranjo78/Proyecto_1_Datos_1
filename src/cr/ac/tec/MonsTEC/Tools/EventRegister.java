package cr.ac.tec.MonsTEC.Tools;

/**
 * Aqui se registran y obtienen los eventos que suceden en el juego
 */
public class EventRegister {

    String card = null;
    int life;
    int damage;
    //Falta uno para controlar eventos especiales

    /**
     * Constructor vacio
     */
    public EventRegister() {
    }

    /**
     * Agrega daño a damage
     * @param dmg int
     */
    public void addDamage(int dmg){
        this.damage+=dmg;
    }

    /**
     * Getter de card
     * @return String card
     */
    public String getCard() {
        return card;
    }

    /**
     * Setter de card
     * @param card string
     */
    public void setCard(String card) {
        this.card = card;
    }

    /**
     * Getter de life (puntos de vida)
     * @return int life
     */
    public int getLife() {
        return life;
    }

    /**
     * Setter de life
     * @param life int
     */
    public void setLife(int life) {
        this.life = life;
    }

    /**
     * Getter de Damage
     * @return int damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Setter de damage
     * @param damage int
     */
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
