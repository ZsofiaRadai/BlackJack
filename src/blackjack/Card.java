package blackjack;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.HashMap;
import java.util.Map;

public class Card extends ImageView{
    private Suit suit;
    private Rank rank;
    private int rankNumber;
    private Image frontFace;
    private static final Map<String, Image> cardFaceImages = new HashMap<>();

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.rankNumber = rank.getRankNumber();
    }

    public Rank getRank() {
        return rank;
    }

    public int getRankNumber() {
        return rankNumber;
    }

    public static void loadCardImages() {
        for (Suit suit : Suit.values()) {
            String suitName = suit.toString().toLowerCase();
            for (Rank rank : Rank.values()) {
                String cardName = suitName + rank.getRankNumber();
                String cardId = rank + " of " + suit;
                String imageFileName = "card_images/" + cardName + ".png";
                cardFaceImages.put(cardId, new Image(imageFileName));
            }
        }
    }

    public String toString(){
        return "Card[" + suit + ", " + rank + "]";
    }
}
