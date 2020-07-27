package hu.frt;

import static org.junit.Assert.*;
import org.junit.Test;

public class CardTest {

    @Test
    public void testValueOfCardGetValue(){
        Card card = new Card((ValueOfCard.NINE));
        assertEquals(9, card.getValue().getValue());
        assertEquals(10, new Card(ValueOfCard.TEN).getValue().getValue());

    }

    @Test
    public void testSuitOfCardGetSuit(){
        assertEquals(SuitOfCard.HEARTS, new Card(SuitOfCard.HEARTS).getSuit());
        assertEquals(SuitOfCard.BELLS, new Card(SuitOfCard.BELLS).getSuit());
        assertEquals(SuitOfCard.ACORNS, new Card(SuitOfCard.ACORNS).getSuit());
        assertEquals(SuitOfCard.LEAVES, new Card(SuitOfCard.LEAVES).getSuit());
    }

    @Test
    public void testCard(){
        Card card = new Card(SuitOfCard.ACORNS, ValueOfCard.KING);
        assertEquals(SuitOfCard.ACORNS, card.getSuit());
        assertEquals(4, card.getValue().getValue());
    }


}
