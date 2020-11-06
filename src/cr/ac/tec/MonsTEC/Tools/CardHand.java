package cr.ac.tec.MonsTEC.Tools;

import cr.ac.tec.MonsTEC.DeckCartas.CardTypes.TypeCarta;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardHand extends ImageView {

    TypeCarta card;
    Image cardImgPath;
    ImageView cardImg;

    public CardHand(TypeCarta card, int size){
        this.card = card;
        this.cardImgPath = new Image("/cr/ac/tec/MonsTEC/Resources/CardsImg/"+card.getName()+".png",size,size,true,true);
        this.cardImg = new ImageView(this.cardImgPath);
    }

    public ImageView getCardImg(){
        return this.cardImg;
    }

}
