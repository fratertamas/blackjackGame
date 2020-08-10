package hu.frt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    DeckOfCards deck = new DeckOfCards();
    List<Card> listDeck = new ArrayList<Card>();
    public Game() {
        deck.shuffleDeck();
        uploadListDeck(deck);
    }

    private void uploadListDeck(DeckOfCards deck) {
        for (int i = 0; i<deck.sizeOfDeck(); i++) {
            listDeck.add(deck.getDeck()[i]);
        }
    }

    public Player getWinner (Player player, Player player2, int bet) {
        if (hasMoney(player, bet) && hasMoney(player2, bet)) {
            Player winner = calculateWinner(player, player2);
            setPlayersMoney(player, player2, bet, winner);
            return winner;
        }
        return null;
    }

    private void setPlayersMoney(Player player, Player player2, int bet, Player winner) {
        if (winner.equals(player)) {
            setPlayersMoney(player, player2,  bet);
        } else {
            setPlayersMoney(player2, player, bet);
        }
    }

    private void setPlayersMoney(Player winner, Player looser, int bet) {
        winner.setMoney(winner.getMoney()+bet);
        looser.setMoney(looser.getMoney()-bet);
    }

    protected Player calculateWinner(Player player, Player player2) {
        Player winner = null;
        /*int cardIndex = 0;
        while ((player.getPlayerHand().size() <= 5) && (player2.getPlayerHand().size() <= 5)
                && (player.getScore() <= 21)
                && (player2.getScore() <= 21)){

            player.addCard(deck.getDeck()[cardIndex]);
            player2.addCard(deck.getDeck()[cardIndex+1]);
            cardIndex += 2;
        }*/
        if ((player.getPlayerHand().size() <= 5) && (player2.getPlayerHand().size() <= 5)
                && (player.getScore() <= 21)
                && (player2.getScore() <= 21)){
            nextCard(player);
            nextCard(player2);
        }

        if (player.getPlayerHand().size() == 2) {
            if ((player.getCard(0).getValue() == ValueOfCard.ACE)
                    && (player.getCard(1).getValue() == ValueOfCard.ACE)) {
                winner = player;
            } else if ((player2.getCard(0).getValue() == ValueOfCard.ACE)
                    && (player2.getCard(1).getValue() == ValueOfCard.ACE)) {
                winner = player2;
            }
        }else if(player.getScore() > player2.getScore()){
            winner = player2;
        }else{
            winner = player;
        }
        if (player.getPlayerHand().size()>5){
            winner = player2;
        }else if(player2.getPlayerHand().size()>5){
            winner = player;
        }

        return winner;
    }

    public void nextCard(Player player) {
        player.addCard(listDeck.get(0));
        listDeck.remove(0);
    }

    public boolean hasMoney(Player testPlayer, int bet) {
        return testPlayer.getMoney()-bet >= 0;
    }
}
