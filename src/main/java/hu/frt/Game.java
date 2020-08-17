package hu.frt;

import java.util.ArrayList;
import java.util.List;

public class Game {
    protected DeckOfCards deck = new DeckOfCards();
    protected List<Card> listDeck = new ArrayList<>();
    private Player player1;
    private Player player2;
    private Player nextPlayer;
    private Player winner;

    public Game() {
        deck.shuffleDeck();
        uploadListDeck(deck);
    }

    private void uploadListDeck(DeckOfCards deck) {
        for (int i = 0; i<deck.sizeOfDeck(); i++) {
            listDeck.add(deck.getDeck()[i]);
        }
    }
/*
    public Player getWinner (Player player, Player player2, int bet) {
        if (hasMoney(player, bet) && hasMoney(player2, bet)) {
            Player winner = calculateWinner(player, player2);
            setPlayersMoney(player, player2, bet, winner);
            return winner;
        }
        return null;
    }
*/
/*
    private void setPlayersMoney(Player player, Player player2, int bet, Player winner) {
        if (winner.equals(player)) {
            setPlayersMoney(player, player2,  bet);
        } else {
            setPlayersMoney(player2, player, bet);
        }
    }
*/
/*
    private void setPlayersMoney(Player winner, Player looser, int bet) {
        winner.setMoney(winner.getMoney()+bet);
        looser.setMoney(looser.getMoney()-bet);
    }
*/
/*
    protected Player calculateWinner(Player player, Player player2) {
        Player winner = null;

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
*/

    protected void setPlayersMoney(Player winner, int bet){
        if (winner.equals(player1)) {
            player1.setMoney(player1.getMoney() + bet);
            player2.setMoney(player2.getMoney() - bet);
        }else{
            player1.setMoney(player1.getMoney() - bet);
            player2.setMoney(player2.getMoney() + bet);
        }
    }


    public void nextCard(Player player) {
        player.addCard(listDeck.get(0));
        listDeck.remove(0);
    }

    public boolean hasMoney(Player testPlayer, int bet) {
        return testPlayer.getMoney()-bet >= 0;
    }

    public void startGame(Player player1, Player player2, int bet) {
        if(!hasMoney(player1,bet) || !hasMoney(player2,bet)){
            throw new NotEnoughtMoneyException();
        }
        this.player1 = player1;
        this.player2 = player2;
        this.nextPlayer = player1;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    public void pullACard(Player player) {
        checkPlayer(player);
        nextCard(player);
        setNextPlayer(player);
        calculateWinner(player);
    }

    private void calculateWinner(Player player) {
        if (player1.isStopped() && player2.isStopped()){
            winner = (player1.getScore() > player2.getScore()) ? player1 : player2;
            nextPlayer = null;
        }else{
            if(player.getScore() == 22 && player.getPlayerHand().size() == 2){
                winner = player;
                nextPlayer = null;
            }else if ((player.getPlayerHand().size() > 5) || (player.getScore() > 21)){
                winner = getNextPlayer();
                nextPlayer = null;
            }
        }
    }

    private void setNextPlayer(Player player) {
        if (player1.isStopped()){
            nextPlayer = (player2.getPlayerHand().size() > 5) ? player1 : player2;
        }else if (player2.isStopped()){
            nextPlayer = (player1.getPlayerHand().size() > 5) ? player2 : player1;
        }
        if (!player1.isStopped() && !player2.isStopped()) {
            if (player.equals(player1)) {
                nextPlayer = player2;
            } else {
                nextPlayer = player1;
            }
        }
        /*if (player1.isStopped() && player2.isStopped()){
            nextPlayer = (player1.getScore() > player2.getScore()) ? player1 : player2;
        }*/
    }

    private void checkPlayer(Player player) {
        if(winner != null)
            throw new NoMorePullException();
        if(!player.equals(getNextPlayer()))
            throw new WrongPlayerPullACardException();
    }

    public Player getWinner() {
        return winner;
    }

    public void stopGame(Player player) {
        if(player.getScore() < 14)
            throw new PlayerCanNotStopUnderScore14Exception();

        player.stopGame();
        if (player1.isStopped() && player2.isStopped()){
            calculateWinner(player);
        }else {
            setNextPlayer(player);
        }
        /*player.stopGame();
        setNextPlayer(player);*/
    }

    public boolean isSopped(Player player) {
        return player.isStopped();
    }
}
