package hu.frt;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    private Game game;
    private Player player1;
    private Player player2;

    @Before
    public void init(){
        game = new Game();

        player1 = new Player("Gyula", 2000);
        player2 = new Player("Dealer", 3000);
        int bet = 1000;
        game.startGame(player1,player2,bet);
    }
/*
    @Test
    public void testCalculateWinnerPlayerWithTwoAces() throws Exception{
        Player testPlayer = new Player("Gyula", 2000);
        Player testDealer = new Player("Dealer", 100000);

        testPlayer.addCard(new Card(SuitOfCard.HEARTS, ValueOfCard.ACE));
        testPlayer.addCard(new Card(SuitOfCard.BELLS, ValueOfCard.ACE));
        testDealer.addCard(new Card(SuitOfCard.LEAVES, ValueOfCard.ACE));
        testDealer.addCard(new Card(SuitOfCard.ACORNS, ValueOfCard.KING));

        assertEquals(testPlayer, game.calculateWinner(testPlayer, testDealer));
    }
*/

    @Test
    public void testBet(){
        Player testPlayer = new Player("Gyula", 2000);
        int bet = 100;
        assertTrue(game.hasMoney(testPlayer, bet));
    }
/*
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
*/
/*
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
*/
/*
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
*/
/*
    @Test
    public void testPlayerMoney() throws Exception{
        Player testPlayer = new Player("Gyula", 2000);
        Player testDealer = new Player("Dealer", 3000);
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
        assertEquals(4000, testDealer.getMoney());
        assertEquals(1000, testPlayer.getMoney());
    }
*/
    @Test(expected = NotEnoughtMoneyException.class)
    public void startGameWith2PlayerWithoutEnoughtMoneyTest(){
        Player player1 = new Player("Gyula", 200);
        Player player2 = new Player("Dealer", 3000);
        int bet = 1000;

        game.startGame(player1, player2,bet);
    }

    @Test
    public void startGameWith2PlayerTest(){
        assertTrue(player1.getPlayerHand().isEmpty());
        assertTrue(player2.getPlayerHand().isEmpty());
        assertEquals(player1, game.getNextPlayer());
    }

    @Test
    public void pullACardTest(){
        Card firstCardOfDeck = game.deck.getDeck()[0];

        game.pullACard(player1);

        assertTrue(player2.getPlayerHand().isEmpty());

        assertFalse(player1.getPlayerHand().isEmpty());
        assertEquals(1,player1.getPlayerHand().size());
        assertEquals(firstCardOfDeck,player1.getPlayerHand().get(0));
    }

    @Test(expected = WrongPlayerPullACardException.class)
    public void pullACardWithWrongPlayerTest(){
        game.pullACard(player2);
    }

    @Test
    public void pullACardWithPlayer2Test(){
        Card player1sCard = game.deck.getDeck()[0];
        Card player2sCard = game.deck.getDeck()[1];

        game.pullACard(player1);
        game.pullACard(player2);

        assertEquals(1,player1.getPlayerHand().size());
        assertEquals(player1sCard,player1.getPlayerHand().get(0));

        assertEquals(1,player2.getPlayerHand().size());
        assertEquals(player2sCard,player2.getPlayerHand().get(0));
    }

    @Test
    public void playerWinWith2AceTest(){
        game.listDeck.set(0, new Card(SuitOfCard.LEAVES,ValueOfCard.ACE));
        game.listDeck.set(1, new Card(SuitOfCard.LEAVES,ValueOfCard.UNTER));
        game.listDeck.set(2, new Card(SuitOfCard.HEARTS,ValueOfCard.ACE));

        game.pullACard(player1);
        game.pullACard(player2);

        game.pullACard(player1);

        assertNotNull(game.getWinner());
        assertEquals(player1,game.getWinner());
        assertNull(game.getNextPlayer());
    }

    @Test(expected = NoMorePullException.class)
    public void pullACardWhenHasWinnerTest(){
        game.listDeck.set(0, new Card(SuitOfCard.LEAVES,ValueOfCard.ACE));
        game.listDeck.set(1, new Card(SuitOfCard.LEAVES,ValueOfCard.UNTER));
        game.listDeck.set(2, new Card(SuitOfCard.HEARTS,ValueOfCard.ACE));

        game.pullACard(player1);
        game.pullACard(player2);

        game.pullACard(player1);
        game.pullACard(player2);
    }

    @Test(expected = PlayerCanNotStopUnderScore14Exception.class)
    public void playerCanNotStopUnderScore14Test(){

        game.listDeck.set(0, new Card(SuitOfCard.LEAVES,ValueOfCard.ACE));
        game.listDeck.set(1, new Card(SuitOfCard.LEAVES,ValueOfCard.UNTER));
        game.listDeck.set(2, new Card(SuitOfCard.HEARTS,ValueOfCard.UNTER));
        game.listDeck.set(3, new Card(SuitOfCard.ACORNS,ValueOfCard.UNTER));

        game.pullACard(player1);
        game.pullACard(player2);

        game.pullACard(player1);
        game.pullACard(player2);

        game.stopGame(player1);
    }

    @Test
    public void anyPlayerStopTest(){
        game.listDeck.set(0, new Card(SuitOfCard.LEAVES,ValueOfCard.ACE));
        game.listDeck.set(1, new Card(SuitOfCard.LEAVES,ValueOfCard.UNTER));
        game.listDeck.set(2, new Card(SuitOfCard.HEARTS,ValueOfCard.OBER));
        game.listDeck.set(3, new Card(SuitOfCard.ACORNS,ValueOfCard.UNTER));

        game.pullACard(player1);
        game.pullACard(player2);

        game.pullACard(player1);
        game.pullACard(player2);

        game.stopGame(player1);

        assertTrue(game.isSopped(player1));
        assertEquals(player2, game.getNextPlayer());
    }

    @Test
    public void player2WinWhenBothPlayerStopTest(){
        game.listDeck.set(0, new Card(SuitOfCard.LEAVES,ValueOfCard.ACE));
        game.listDeck.set(1, new Card(SuitOfCard.LEAVES,ValueOfCard.KING));
        game.listDeck.set(2, new Card(SuitOfCard.HEARTS,ValueOfCard.OBER));
        game.listDeck.set(3, new Card(SuitOfCard.ACORNS,ValueOfCard.ACE));

        game.pullACard(player1);
        game.pullACard(player2);

        game.pullACard(player1);
        game.pullACard(player2);

        game.stopGame(player1);
        game.stopGame(player2);

        assertTrue(game.isSopped(player1));
        assertTrue(game.isSopped(player2));
        assertNull(game.getNextPlayer());
        assertEquals(player2, game.getWinner());
    }

    @Test
    public void playerWinnerWhenPlayerScoreGreaterThan21Test(){
        game.listDeck.set(0, new Card(SuitOfCard.LEAVES,ValueOfCard.ACE));
        game.listDeck.set(1, new Card(SuitOfCard.LEAVES,ValueOfCard.UNTER));
        game.listDeck.set(2, new Card(SuitOfCard.HEARTS,ValueOfCard.UNTER));
        game.listDeck.set(3, new Card(SuitOfCard.ACORNS,ValueOfCard.UNTER));
        game.listDeck.set(4, new Card(SuitOfCard.BELLS, ValueOfCard.TEN));

        game.pullACard(player1);
        game.pullACard(player2);

        game.pullACard(player1);
        game.pullACard(player2);

        game.pullACard(player1);

        assertNotNull(game.getWinner());
        assertEquals(player2,game.getWinner());
        assertNull(game.getNextPlayer());
    }

    @Test
    public void player1WinnerANDCardInPlayer2HandHasMore5Cards(){
        game.listDeck.set(0, new Card(SuitOfCard.LEAVES,ValueOfCard.ACE));
        game.listDeck.set(1, new Card(SuitOfCard.LEAVES,ValueOfCard.UNTER));
        game.listDeck.set(2, new Card(SuitOfCard.HEARTS,ValueOfCard.KING));
        game.listDeck.set(3, new Card(SuitOfCard.ACORNS,ValueOfCard.UNTER));
        game.listDeck.set(4, new Card(SuitOfCard.BELLS, ValueOfCard.UNTER));
        game.listDeck.set(5, new Card(SuitOfCard.HEARTS, ValueOfCard.UNTER));
        game.listDeck.set(6, new Card(SuitOfCard.HEARTS, ValueOfCard.OBER));
        game.listDeck.set(7, new Card(SuitOfCard.BELLS, ValueOfCard.OBER));

        game.pullACard(player1);
        game.pullACard(player2);

        game.pullACard(player1);
        game.pullACard(player2);

        game.stopGame(player1);
        game.pullACard(player2);

        game.pullACard(player2);
        game.pullACard(player2);
        game.pullACard(player2);

        assertEquals(2, player1.getPlayerHand().size());
        assertEquals(6, player2.getPlayerHand().size());
        assertEquals(player1, game.getWinner());
    }

    @Test
    public void player2WinnerANDCardInPlayer1HandHasMore5Cards(){
        game.listDeck.set(0, new Card(SuitOfCard.LEAVES,ValueOfCard.UNTER));
        game.listDeck.set(1, new Card(SuitOfCard.LEAVES,ValueOfCard.ACE));
        game.listDeck.set(2, new Card(SuitOfCard.ACORNS,ValueOfCard.UNTER));
        game.listDeck.set(3, new Card(SuitOfCard.HEARTS,ValueOfCard.KING));
        game.listDeck.set(4, new Card(SuitOfCard.BELLS, ValueOfCard.UNTER));
        game.listDeck.set(5, new Card(SuitOfCard.HEARTS, ValueOfCard.UNTER));
        game.listDeck.set(6, new Card(SuitOfCard.HEARTS, ValueOfCard.OBER));
        game.listDeck.set(7, new Card(SuitOfCard.BELLS, ValueOfCard.OBER));

        game.pullACard(player1);
        game.pullACard(player2);

        game.pullACard(player1);
        game.pullACard(player2);

        game.pullACard(player1);
        game.stopGame(player2);

        game.pullACard(player1);
        game.pullACard(player1);
        game.pullACard(player1);

        assertEquals(2, player2.getPlayerHand().size());
        assertEquals(6, player1.getPlayerHand().size());
        assertEquals(player2, game.getWinner());
    }

    @Test
    public void playersMoneyWithBetTest(){
        game.setPlayersMoney(player1, 1000);
        assertEquals(3000, player1.getMoney());
        assertEquals(2000, player2.getMoney());
    }
}
