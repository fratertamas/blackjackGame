package hu.frt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValueOfCardTest {
    @Test
    public void testGetValue(){
        assertEquals(9, ValueOfCard.NINE.getValue());
        assertEquals(10, ValueOfCard.TEN.getValue());
    }
}
