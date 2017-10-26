package blackjack;


public class Human extends Player{
    private double playerMoney = 100;

    public double getPlayerMoney() {
        return playerMoney;
    }

    @Override
    public String toString() {
        return "Human: " + super.toString();
    }
}
