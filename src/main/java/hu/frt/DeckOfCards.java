package hu.frt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    private Card[] deck;
    private int numberOfCards = 32;

    public DeckOfCards(){
        deck = new Card[numberOfCards];
        createDeck();
    }

    private void createDeck() {
        int indexOfDeck = 0;
        for (SuitOfCard suit : SuitOfCard.values()){
            for (ValueOfCard value : ValueOfCard.values()){
                deck[indexOfDeck] = new Card(suit, value);
                indexOfDeck ++;
            }
        }
    }

    public int sizeOfDeck() {
        return deck.length;
    }

    public Card[] getDeck() {
        return deck;
    }

    public void shuffleDeck() {
        List<Card> tmpList = Arrays.asList(deck);
        Collections.shuffle(tmpList);
    }
}
