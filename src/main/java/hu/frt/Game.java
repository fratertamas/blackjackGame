package hu.frt;

public class Game {

    public Player getWinner (Player player, Player player2, int bet) {
        Player winner = calcWinner(player, player2);

        if (winner.equals(player)){
            player.setMoney(player.getMoney()+bet);
            player2.setMoney(player2.getMoney()-bet);
        }else{
            player.setMoney(player.getMoney()-bet);
            player2.setMoney(player2.getMoney()+bet);
        }

        return winner;
    }

    public Player calcWinner(Player player, Player player2) {

        Player winner = null;
        DeckOfCards deck = new DeckOfCards();
        deck.shuffleDeck();
        int cardIndex = 0;

        while ((player.getPlayerHand().size() <= 5) && (player2.getPlayerHand().size() <= 5)
                && (player.getScore() <= 21)
                && (player2.getScore() <= 21)){
            player.addCard(deck.getDeck()[cardIndex]);
            player2.addCard(deck.getDeck()[cardIndex+1]);
            cardIndex += 2;
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


    public int checkPlayerBet(Player testPlayer, int bet) {
        int money = 0;
        if (testPlayer.getMoney()-bet >= 0){
            money = testPlayer.getMoney()-bet;
        }

        return money;
    }
}
