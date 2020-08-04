package hu.frt;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    private Game game;

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

        testPlayer.addCard(new Card(SuitOfCard.HEARTS, ValueOfCard.ACE));
        testPlayer.addCard(new Card(SuitOfCard.BELLS, ValueOfCard.ACE));
        testDealer.addCard(new Card(SuitOfCard.LEAVES, ValueOfCard.ACE));
        testDealer.addCard(new Card(SuitOfCard.ACORNS, ValueOfCard.KING));

        assertEquals(testPlayer, game.calcWinner(testPlayer, testDealer));
    }

    @Test
    public void testBet() throws Exception{
        Player testPlayer = new Player("Gyula", 2000);
        int bet = 100;
        assertTrue(game.checkBet(testPlayer, bet));
    }

    @Test
    public void getWinnerNameAndMoneyWithTwoAces() throws Exception{
        Player testPlayer = new Player("Gyula", 2000);
        Player testDealer = new Player("Dealer", 100000);
        int bet = 1000;

        testPlayer.addCard(new Card(SuitOfCard.HEARTS, ValueOfCard.ACE));
        testPlayer.addCard(new Card(SuitOfCard.BELLS, ValueOfCard.ACE));
        testDealer.addCard(new Card(SuitOfCard.LEAVES, ValueOfCard.ACE));
        testDealer.addCard(new Card(SuitOfCard.ACORNS, ValueOfCard.ACE));

        assertEquals(testPlayer, game.getWinner(testPlayer, testDealer, bet));
        assertEquals(3000,testPlayer.getMoney());
    }

    @Test
    public void testPlayerScoreMoreThen21() throws Exception{
        Player testPlayer = new Player("Gyula", 2000);
        Player testDealer = new Player("Dealer", 100000);
        int bet = 1000;

        testPlayer.addCard(new Card(SuitOfCard.HEARTS, ValueOfCard.ACE));
        testPlayer.addCard(new Card(SuitOfCard.BELLS, ValueOfCard.OBER));
        testDealer.addCard(new Card(SuitOfCard.LEAVES, ValueOfCard.ACE));
        testDealer.addCard(new Card(SuitOfCard.ACORNS, ValueOfCard.SEVEN));
        testPlayer.addCard(new Card(SuitOfCard.LEAVES, ValueOfCard.NINE));

        assertEquals(testDealer, game.getWinner(testPlayer, testDealer, bet));
    }

    @Test
    public void testPlayerHandSizeMoreThenFive() throws Exception{
        Player testPlayer = new Player("Gyula", 2000);
        Player testDealer = new Player("Dealer", 100000);
        int bet = 1000;

        testPlayer.addCard(new Card(SuitOfCard.HEARTS, ValueOfCard.UNTER));
        testPlayer.addCard(new Card(SuitOfCard.BELLS, ValueOfCard.OBER));
        testDealer.addCard(new Card(SuitOfCard.LEAVES, ValueOfCard.ACE));
        testDealer.addCard(new Card(SuitOfCard.ACORNS, ValueOfCard.SEVEN));
        testPlayer.addCard(new Card(SuitOfCard.LEAVES, ValueOfCard.UNTER));
        testPlayer.addCard(new Card(SuitOfCard.LEAVES, ValueOfCard.KING));
        testPlayer.addCard(new Card(SuitOfCard.ACORNS, ValueOfCard.UNTER));
        testPlayer.addCard(new Card(SuitOfCard.LEAVES, ValueOfCard.OBER));

        assertEquals(testDealer, game.getWinner(testPlayer, testDealer, bet));
    }

    @Test
    public void testGame(){
        Player tp = new Player("Marci",1000);
        Player dl = new Player("Dealer",11000);
        int bet = 100;
        assertNotNull(game.getWinner(tp,dl,bet));
        bet = 12000;
        assertNull(game.getWinner(tp,dl,bet));
    }
}
