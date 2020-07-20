package hu.frt;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CardTest {

    Card card = null;
    @Before
    public void init(){
        card = new Card();
    }
    @Test
    public void testToCreateCardCreated() throws Exception {
        assertNotNull(new Card(ValueOfCard.SEVEN));
        assertNotNull(new Card(ValueOfCard.EIGHT));
        assertNotNull(new Card(ValueOfCard.NINE));
        assertNotNull(new Card(ValueOfCard.TEN));
        assertNotNull(new Card(ValueOfCard.UNTER));
        assertNotNull(new Card(ValueOfCard.OBER));
        assertNotNull(new Card(ValueOfCard.KING));
        assertNotNull(new Card(ValueOfCard.ACE));
    }
    @Test
    public void testValueOfCardGetValue(){
        Card card = new Card((ValueOfCard.NINE));
        assertEquals(9, card.getValue().getValue());
        assertEquals(9, ValueOfCard.NINE.getValue());
        assertEquals(10, new Card(ValueOfCard.TEN).getValue().getValue());
        assertEquals(10, ValueOfCard.TEN.getValue());
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
        card = new Card(SuitOfCard.ACORNS, ValueOfCard.KING);
        assertEquals(SuitOfCard.ACORNS, card.getSuit());
        assertEquals(4, card.getValue().getValue());
    }


}
