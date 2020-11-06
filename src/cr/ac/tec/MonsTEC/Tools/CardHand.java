package cr.ac.tec.MonsTEC.Tools;

import cr.ac.tec.MonsTEC.DeckCartas.CardTypes.TypeCarta;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Aqui se vincula las cartas con sus respectivas imagenes
 */
public class CardHand extends ImageView {

    TypeCarta card;
    Image cardImgPath;
    ImageView cardImg;

    /**
     * Constructores de card y size
     * @param card Objeto TypeCarta
     * @param size Int que iran a ser los tamaños de la imagen de la carta
     */
    public CardHand(TypeCarta card, int size){
        this.card = card;
        this.cardImgPath = new Image("/cr/ac/tec/MonsTEC/Resources/CardsImg/"+card.getName()+".png",size,size,true,true);
        this.cardImg = new ImageView(this.cardImgPath);
    }

    /**
     * Getter de cardImg
     * @return cardImg
     */
    public ImageView getCardImg(){
        return this.cardImg;
    }

}
