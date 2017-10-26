package blackjack;

import java.util.List;
import java.util.Random;

public class Game {
    private static boolean isGameOn = true;
    private Player human = new Human();
    private Player dealer = new Dealer();
    private Deck deck = new Deck();

    public void startGame(){
        human.setPlayerCards(deck.deal(human));
        dealer.setPlayerCards(deck.deal(dealer));

        System.out.println(dealer.toString());
        System.out.println(human.toString());

        System.out.println(countCardValue(human.getPlayerCards()));
        checkIfBroke(human);
    }

    public Player getHuman() {
        return human;
    }

    public Deck getDeck() {
        return deck;
    }

    public void hit(Deck Deck, Player player){
        List<Card> deck = Deck.getDeck();
        Random rand = new Random();
        int index = rand.nextInt(deck.size());
        Card newCard = deck.get(index);
        deck.remove(index);
        System.out.println(newCard);
        player.getPlayerCards().add(newCard);
        System.out.println(countCardValue(player.getPlayerCards()));
        checkIfBroke(player);
    }

    public static int countCardValue(List<Card> playerCards){
        int count = 0;
        for (Card card: playerCards) {
            if (card.getRankNumber() <= 10) {
                count += card.getRankNumber();
            } else if (card.getRankNumber() > 10) {
                count += 10;
            }
        }
        return count;
    }

    public static void checkIfBroke(Player player){
        if (countCardValue(player.getPlayerCards()) >= 22){
            if (player instanceof Human) {
                System.out.println("Player breaks!");
            } else if (player instanceof Dealer) {
                System.out.println("Dealer breaks!");
            }
        }
    }

}
