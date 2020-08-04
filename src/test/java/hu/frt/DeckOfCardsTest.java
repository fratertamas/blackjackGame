package hu.frt;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DeckOfCardsTest {

    private DeckOfCards deck = null;
    private Card[] testDeck;
    @Before
    public void init(){
        deck = new DeckOfCards();
        testDeck = createTestDeck();
    }

    private Card[] createTestDeck() {
        testDeck = new Card[32];
        //Hearts
        testDeck[0] = new Card(SuitOfCard.HEARTS, ValueOfCard.UNTER);
        testDeck[1] = new Card(SuitOfCard.HEARTS, ValueOfCard.OBER);
        testDeck[2] = new Card(SuitOfCard.HEARTS, ValueOfCard.KING);
        testDeck[3] = new Card(SuitOfCard.HEARTS, ValueOfCard.SEVEN);
        testDeck[4] = new Card(SuitOfCard.HEARTS, ValueOfCard.EIGHT);
        testDeck[5] = new Card(SuitOfCard.HEARTS, ValueOfCard.NINE);
        testDeck[6] = new Card(SuitOfCard.HEARTS, ValueOfCard.TEN);
        testDeck[7] = new Card(SuitOfCard.HEARTS, ValueOfCard.ACE);

        //Bells
        testDeck[8] = new Card(SuitOfCard.BELLS, ValueOfCard.UNTER);
        testDeck[9] = new Card(SuitOfCard.BELLS, ValueOfCard.OBER);
        testDeck[10] = new Card(SuitOfCard.BELLS, ValueOfCard.KING);
        testDeck[11] = new Card(SuitOfCard.BELLS, ValueOfCard.SEVEN);
        testDeck[12] = new Card(SuitOfCard.BELLS, ValueOfCard.EIGHT);
        testDeck[13] = new Card(SuitOfCard.BELLS, ValueOfCard.NINE);
        testDeck[14] = new Card(SuitOfCard.BELLS, ValueOfCard.TEN);
        testDeck[15] = new Card(SuitOfCard.BELLS, ValueOfCard.ACE);

        //Acorns
        testDeck[16] = new Card(SuitOfCard.ACORNS, ValueOfCard.UNTER);
        testDeck[17] = new Card(SuitOfCard.ACORNS, ValueOfCard.OBER);
        testDeck[18] = new Card(SuitOfCard.ACORNS, ValueOfCard.KING);
        testDeck[19] = new Card(SuitOfCard.ACORNS, ValueOfCard.SEVEN);
        testDeck[20] = new Card(SuitOfCard.ACORNS, ValueOfCard.EIGHT);
        testDeck[21] = new Card(SuitOfCard.ACORNS, ValueOfCard.NINE);
        testDeck[22] = new Card(SuitOfCard.ACORNS, ValueOfCard.TEN);
        testDeck[23] = new Card(SuitOfCard.ACORNS, ValueOfCard.ACE);

        //Leaves
        testDeck[24] = new Card(SuitOfCard.LEAVES, ValueOfCard.UNTER);
        testDeck[25] = new Card(SuitOfCard.LEAVES, ValueOfCard.OBER);
        testDeck[26] = new Card(SuitOfCard.LEAVES, ValueOfCard.KING);
        testDeck[27] = new Card(SuitOfCard.LEAVES, ValueOfCard.SEVEN);
        testDeck[28] = new Card(SuitOfCard.LEAVES, ValueOfCard.EIGHT);
        testDeck[29] = new Card(SuitOfCard.LEAVES, ValueOfCard.NINE);
        testDeck[30] = new Card(SuitOfCard.LEAVES, ValueOfCard.TEN);
        testDeck[31] = new Card(SuitOfCard.LEAVES, ValueOfCard.ACE);

        return testDeck;
    }

    @Test
    public void testSizeOfDeck() throws Exception {
        assertEquals(32, deck.sizeOfDeck());
    }

    @Test
    public void testGetDeck() throws  Exception{
        assertArrayEquals(testDeck,
                deck.getDeck());
    }

    @Test
    public void testShuffleDeck() throws Exception {
        deck.shuffleDeck();
        assertNotSame(testDeck, deck.getDeck());
    }

    @Test
    public void assertSameTest() throws Exception {
        List<String> firstList = Arrays.asList("alma","körte", "mogyoró");
        List<String> firstListReferenceWithOtherName = firstList;
        List<String> secondList = Arrays.asList("alma","körte", "mogyoró");

        assertSame(firstList,firstList);
        assertSame(firstList,firstListReferenceWithOtherName);
        assertNotSame(firstList,secondList);
    }


}
