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
        Card card1 = new Card((ValueOfCard.NINE));
        assertEquals(9, card1.getValue().getValue());
        assertEquals(10, ValueOfCard.TEN.getValue());
    }

}
