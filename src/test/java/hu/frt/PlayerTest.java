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
    public void testGetName() {
        assertEquals("Gyula", testPlayer.getPlayerName());
    }

    @Test
    public void  testGetMoney(){
        assertEquals(2000, testPlayer.getMoney());
    }

    @Test
    public void testSetMoney(){
        testPlayer.setMoney(2500);
        assertEquals(2500, testPlayer.getMoney());
    }

    @Test
    public void testAddCardToPlayerHand()  {
        Card card1 = new Card(SuitOfCard.BELLS, ValueOfCard.KING);

        testPlayer.addCard(card1);

        assertEquals(card1, testPlayer.getPlayerHand().get(0));
    }

    @Test
    public void testGetCard(){
        Card card = new Card(SuitOfCard.ACORNS, ValueOfCard.SEVEN);
        testPlayer.addCard(card);
        assertEquals(card, testPlayer.getCard(0));
    }

    @Test
    public void testGetPlayerHand(){
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
    public void testPlayerGetScore(){
        Card card1 = new Card(SuitOfCard.LEAVES, ValueOfCard.SEVEN);
        Card card2 = new Card(SuitOfCard.BELLS, ValueOfCard.KING);
        testPlayer.addCard(card1);
        testPlayer.addCard(card2);
        assertEquals(11, testPlayer.getScore());

    }

    @Test
    public void testCheckNextCardAndPlayerHand(){
        Card card1 = new Card(SuitOfCard.HEARTS, ValueOfCard.ACE);
        Card card2 = new Card(SuitOfCard.ACORNS, ValueOfCard.SEVEN);
        Card card3 = new Card(SuitOfCard.HEARTS, ValueOfCard.ACE);
        Card card4 = new Card(SuitOfCard.LEAVES, ValueOfCard.NINE);

        testPlayer.addCard(card1);
        testPlayer.addCard(card2);
        testPlayer.addCard(card3);
        testPlayer.addCard(card4);

        assertEquals(3, testPlayer.getPlayerHand().size());
    }
}
