package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Deck {
    private static List<Card> deck = new ArrayList<>();

    public Deck() {
        for (Suit suit: Suit.values()) {
            for (Rank rank: Rank.values()){
                Card card = new Card(suit, rank);
                deck.add(card);
            }
        }
    }

    public List<Card> getDeck() {
        return deck;
    }

    public static List<Card> deal(Player target){
        Random rand = new Random();
        List<Card> hand = new ArrayList<>();
        if (target instanceof Human) {
            for (int i = 0; i < 2; i++) {
                int cardIndex = rand.nextInt(deck.size());
                hand.add(deck.get(cardIndex));
                deck.remove(cardIndex);
            }
        }if (target instanceof Dealer){
            int cardIndex = rand.nextInt(deck.size());
            hand.add(deck.get(cardIndex));
            deck.remove(cardIndex);
        }
        return hand;
    }
}
