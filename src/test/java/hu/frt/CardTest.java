package hu.frt;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {

    @Test
    public void testSuitOfCardGetSuit(){
        assertEquals(SuitOfCard.HEARTS, new Card(SuitOfCard.HEARTS).getSuit());
        assertEquals(SuitOfCard.BELLS, new Card(SuitOfCard.BELLS).getSuit());
        assertEquals(SuitOfCard.ACORNS, new Card(SuitOfCard.ACORNS).getSuit());
        assertEquals(SuitOfCard.LEAVES, new Card(SuitOfCard.LEAVES).getSuit());
    }

    @Test
    public void testNotEqualsCards(){
        Card card1 = new Card(SuitOfCard.ACORNS, ValueOfCard.KING);
        Card card2 = new Card(SuitOfCard.HEARTS, ValueOfCard.ACE);
        assertNotEquals(card1,card2);
    }

    @Test
    public void  testEqualsCards(){
        Card card1 = new Card(SuitOfCard.ACORNS, ValueOfCard.KING);
        Card card2 = new Card(SuitOfCard.ACORNS, ValueOfCard.KING);

        assertEquals(card1,card2);
    }

}
