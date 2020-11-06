package cr.ac.tec.MonsTEC.DeckCartas.CardTypes;

/**
 * Aqui se le dara forma a todos los atributtos que tendran las cada uno de las cartas, las cuales
 * vendran en un array
 */
public class TypeCarta {
    private int ID;
    private String name;
    private int cost;
    private int dmg_fct;
    private String type;

    /**
     *Construye los atributos que van a tener las cartas
     * @param ID Numero de identificacion de la carta
     * @param name Nombre de la carta
     * @param cost El costo de mana que vaya a necesitar la carta para poder ser implementada
     * @param dmg_fct Si la carta es tipo esbirro, es el valor del daño que vaya a ocasionar a
     *                la vida del enemigo, y si la carta es de algun otro tipo, este valor será null
     * @param type Es el tipo al cual va a pertenecer la carta (esbirro, secreto, hechizo)
     */
    public TypeCarta(int ID, String name, int cost, int dmg_fct, String type) {
        this.ID = ID;
        this.name = name;
        this.cost = cost;
        this.dmg_fct = dmg_fct;
        this.type = type;
    }

    /**
     *Retorna el valor de ID que tenga la carta
     * @return ID de la carta
     */
    public int getID() {
        return ID;
    }

    /**
     * Retorna el nombre que tenga la carta
     * @return Nombre de la carta
     */
    public String getName() {
        return name;
    }

    /**
     * Retorna el costo de mana que ocupa la carta
     * @return Cantidad de mana que necesita la carta para desplegarse
     */
    public int getCost() {
        return cost;
    }

    /**
     * Retorna el daño que hace la carta
     * @return Daño que provoca la carta
     */
    public int getDmg_fct() {
        return dmg_fct;
    }

    /**
     * Retorna el tipo de carta que es la carta
     * @return Tipo de la carta
     */
    public String getType() {
        return type;
    }
}
