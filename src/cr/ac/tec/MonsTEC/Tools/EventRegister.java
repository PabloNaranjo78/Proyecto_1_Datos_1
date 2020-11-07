package cr.ac.tec.MonsTEC.Tools;

/**
 * Aqui se registran y obtienen los eventos que suceden en el juego
 */
public class EventRegister {

    String card = null;
    int healLife;
    int damage;
    int mana;
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
    public int getHealLife(){
        return this.healLife;
    }

    public void setHealLife(){
        this.healLife = 0;
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

    public void cleanEventRegister(){
        this.damage = 0;
        this.mana = 0;
        this.healLife = 0;
    }

    /***
     * Añana una cantidad X de mamá al jugador
     * @param addmana cantidad de maná a agregar
     */
    public void addXMana(int addmana){
        this.mana+=addmana;
    }

    /***
     * Retorna el maná que se ha añadido
     * @return entero con el mamá añadido
     */
    public int getMana(){
        return this.mana;
    }

    /***
     * Setter para el valor de mamá
     * @param mana entero con el valor de mamá a asignar
     */
    public void setMana(int mana){
        this.mana = mana;
    }

    /***
     * Registro de curaciones hechas
     * @param heal valor de curación a registrar
     */
    public void heal(int heal){
        this.healLife = heal;
    }

}
