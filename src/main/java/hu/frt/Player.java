package hu.frt;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int money;
    List<Card> cardList = new ArrayList<>();
    private int score;

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

    public void setMoney(int money){
        this.money = money;
    }

    public List<Card> getPlayerHand() {
        return cardList;
    }

    public void addCard(Card card1) {
        if (!checkCard(card1)) cardList.add(card1);
    }

    private boolean checkCard(Card card1) {
        boolean van = false;
        for (Card card: cardList) {
            if (card.equals(card1)) van = true;
        }
        return van;
    }

    public Card getCard(int i) {
        return cardList.get(i);
    }

    public int getScore() {
        int score = 0;
        for (Card card: cardList) {
            score += card.getValue().getValue();
        }
        return score;
    }
}
