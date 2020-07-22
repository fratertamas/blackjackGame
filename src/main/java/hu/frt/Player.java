package hu.frt;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int money;
    List<Card> cardList = new ArrayList<>();

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
    }


    public String getPlayerName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public List<Card> getPlayerHand() {
        return cardList;
    }

    public void addCard(Card card1) {
        this.cardList.add(card1);
    }

    public Card getCard(int i) {
        return cardList.get(i);
    }
}
