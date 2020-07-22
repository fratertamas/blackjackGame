package hu.frt;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerTest {
    Player testPlayer = null;

    @Before
    public void init() {
        testPlayer = new Player("Gyula", 2000);
    }

    @Test
    public void testPlayerCreated() throws Exception {
        assertNotNull(testPlayer);
    }

    @Test
    public void testPlayerAndDealerCreated() throws Exception {
        Player testDealer = new Player("Dealer", 100000);
        assertNotSame(testDealer, testPlayer);
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Gyula", testPlayer.getPlayerName());
    }

    @Test
    public void  testGetMoney() throws Exception{
        assertEquals(2000, testPlayer.getMoney());
    }
    @Test
    public void testAddCardToPlayerHand() throws Exception {
        Card card1 = new Card(SuitOfCard.BELLS, ValueOfCard.KING);

        testPlayer.addCard(card1);

        assertEquals(card1, testPlayer.getPlayerHand().get(0));
    }

    @Test
    public void testGetCard() throws Exception{
        Card card = new Card(SuitOfCard.ACORNS, ValueOfCard.SEVEN);
        testPlayer.addCard(card);
        assertEquals(card, testPlayer.getCard(0));
    }

    @Test
    public void testGetPlayerHand() throws Exception {
        Card card1 = new Card(SuitOfCard.HEARTS, ValueOfCard.ACE);
        Card card2 = new Card(SuitOfCard.ACORNS, ValueOfCard.TEN);

        List<Card> testHand = new ArrayList<Card>();
        testHand.add(card1);
        testHand.add(card2);

        testPlayer.addCard(card1);
        testPlayer.addCard(card2);

        assertArrayEquals(testHand.toArray(), testPlayer.getPlayerHand().toArray());
    }

    @Test
    public void testPlayerHasHand() throws Exception {
        Card card1 = new Card(SuitOfCard.HEARTS, ValueOfCard.ACE);
        Card card2 = new Card(SuitOfCard.ACORNS, ValueOfCard.TEN);
        Card card3 = new Card(SuitOfCard.BELLS, ValueOfCard.OBER);
        Card card4 = new Card(SuitOfCard.LEAVES, ValueOfCard.NINE);

        testPlayer.addCard(card1);
        testPlayer.addCard(card2);
        testPlayer.addCard(card3);
        testPlayer.addCard(card4);

        assertEquals(4, testPlayer.getPlayerHand().size());
    }

    @Test
    public void testPlayerGetScore() throws Exception{
        Card card1 = new Card(SuitOfCard.LEAVES, ValueOfCard.SEVEN);
        Card card2 = new Card(SuitOfCard.BELLS, ValueOfCard.KING);
        testPlayer.addCard(card1);
        testPlayer.addCard(card2);
        assertEquals(11, testPlayer.getScore());

    }

    @Test
    public void testPlayersGetScore() throws Exception{
        Player testDealer = new Player("Dealer", 10000);

        Card card1 = new Card(SuitOfCard.HEARTS, ValueOfCard.ACE);
        Card card2 = new Card(SuitOfCard.ACORNS, ValueOfCard.TEN);
        Card card3 = new Card(SuitOfCard.BELLS, ValueOfCard.OBER);
        Card card4 = new Card(SuitOfCard.LEAVES, ValueOfCard.NINE);

        testPlayer.addCard(card1);
        testPlayer.addCard(card2);
        testDealer.addCard(card3);
        testDealer.addCard(card4);

        assertEquals(21, testPlayer.getScore());
        assertEquals(12, testDealer.getScore());
    }
}
