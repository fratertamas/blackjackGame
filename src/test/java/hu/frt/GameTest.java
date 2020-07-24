package hu.frt;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    Game game;


    @Before
    public void init(){
        game = new Game();
    }

    @Test
    public void gameNotNull(){
        assertNotNull(game);
    }

    @Test
    public void getWinnerPlayerWithTwoAces() throws Exception{
        Player testPlayer = new Player("Gyula", 2000);
        Player testDealer = new Player("Dealer", 100000);

        Card card1 = new Card(SuitOfCard.HEARTS, ValueOfCard.ACE);
        Card card2 = new Card(SuitOfCard.BELLS, ValueOfCard.ACE);
        Card card3 = new Card(SuitOfCard.LEAVES, ValueOfCard.ACE);
        Card card4 = new Card(SuitOfCard.ACORNS, ValueOfCard.KING);

        testPlayer.addCard(card1);
        testPlayer.addCard(card2);
        testDealer.addCard(card3);
        testDealer.addCard(card4);

        assertEquals(testPlayer, game.calcWinner(testPlayer, testDealer));
    }

    @Test
    public void testMoneyAndPlayerBet() throws Exception{
        Player testPlayer = new Player("Gyula", 2000);
        Player testDealer = new Player("Dealer", 100000);
        int bet = 100;
        assertEquals(true, game.checkPlayerBet(testPlayer, bet)>=0);
    }

    @Test
    public void getWinnerNameAndMoneyWithTwoAces() throws Exception{
        Player testPlayer = new Player("Gyula", 2000);
        Player testDealer = new Player("Dealer", 100000);
        int bet = 1000;

        Card card1 = new Card(SuitOfCard.HEARTS, ValueOfCard.ACE);
        Card card2 = new Card(SuitOfCard.BELLS, ValueOfCard.ACE);
        Card card3 = new Card(SuitOfCard.LEAVES, ValueOfCard.ACE);
        Card card4 = new Card(SuitOfCard.ACORNS, ValueOfCard.ACE);

        testPlayer.addCard(card1);
        testPlayer.addCard(card2);
        testDealer.addCard(card3);
        testDealer.addCard(card4);

        assertEquals(testPlayer, game.getWinner(testPlayer, testDealer, bet));
        assertEquals(3000,testPlayer.getMoney());
    }

    @Test
    public void testPlayerScoreMoreThen21() throws Exception{
        Player testPlayer = new Player("Gyula", 2000);
        Player testDealer = new Player("Dealer", 100000);
        int bet = 1000;

        Card card1 = new Card(SuitOfCard.HEARTS, ValueOfCard.ACE);
        Card card2 = new Card(SuitOfCard.BELLS, ValueOfCard.OBER);
        Card card3 = new Card(SuitOfCard.LEAVES, ValueOfCard.ACE);
        Card card4 = new Card(SuitOfCard.ACORNS, ValueOfCard.SEVEN);
        Card card5 = new Card(SuitOfCard.LEAVES, ValueOfCard.NINE);

        testPlayer.addCard(card1);
        testPlayer.addCard(card2);
        testDealer.addCard(card3);
        testDealer.addCard(card4);
        testPlayer.addCard(card5);

        assertEquals(testDealer, game.getWinner(testPlayer, testDealer, bet));

    }
    @Test
    public void testPlayerHandSizeMoreThenFive() throws Exception{
        Player testPlayer = new Player("Gyula", 2000);
        Player testDealer = new Player("Dealer", 100000);
        int bet = 1000;

        Card card1 = new Card(SuitOfCard.HEARTS, ValueOfCard.UNTER);
        Card card2 = new Card(SuitOfCard.BELLS, ValueOfCard.OBER);
        Card card3 = new Card(SuitOfCard.LEAVES, ValueOfCard.ACE);
        Card card4 = new Card(SuitOfCard.ACORNS, ValueOfCard.SEVEN);
        Card card5 = new Card(SuitOfCard.LEAVES, ValueOfCard.UNTER);
        Card card6 = new Card(SuitOfCard.LEAVES, ValueOfCard.KING);
        Card card7 = new Card(SuitOfCard.ACORNS, ValueOfCard.UNTER);
        Card card8 = new Card(SuitOfCard.LEAVES, ValueOfCard.OBER);

        testPlayer.addCard(card1);
        testPlayer.addCard(card2);
        testDealer.addCard(card3);
        testDealer.addCard(card4);
        testPlayer.addCard(card5);
        testPlayer.addCard(card8);
        testPlayer.addCard(card7);
        testPlayer.addCard(card6);

        assertEquals(testDealer, game.getWinner(testPlayer, testDealer, bet));

    }


    @Test
    public void getTest(){
        Player tp = new Player("Marci",1000);
        Player dl = new Player("Dealer",11000);
        int bet = 100;
        game.getWinner(tp,dl,bet);

    }
}
