package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private List<Card> playerCards = new ArrayList<>();

    public Player() {
    }

    public void setPlayerCards(List<Card> playerCards) {
        this.playerCards = playerCards;
    }

    public List<Card> getPlayerCards() {
        return playerCards;
    }

    public String toString(){
        StringBuilder cards = new StringBuilder();
        for (int i = 0; i < playerCards.size() ; i++) {
            cards.append(playerCards.get(i));
            if (i < playerCards.size() -1){
                cards.append(", ");
            }
        }
        return String.valueOf(cards);
    }
}
