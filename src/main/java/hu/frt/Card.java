package hu.frt;

import java.util.Objects;

public class Card {

    private SuitOfCard suit;
    private ValueOfCard value;


    public Card(ValueOfCard value){
        this.value = value;
    }

    public Card(SuitOfCard suit) {
        this.suit = suit;
    }

    public Card(SuitOfCard suit, ValueOfCard value) {
        this.value = value;
        this.suit = suit;
    }

    public void setValue(ValueOfCard value)
    {
        this.value = value;
    }

    public ValueOfCard getValue()
    {
        return value;
    }

    public SuitOfCard getSuit(){
        return suit;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        final Card other = (Card) obj;

        if (this.value != other.value) return false;
        if (!Objects.equals(this.suit, other.suit)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit = " + suit + ", value = " + value +
                '}';
    }
}
