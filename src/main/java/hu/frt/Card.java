package hu.frt;

public class Card {

    private SuitOfCard suit;
    private ValueOfCard value;

    public Card(){
        this.value = value;
    }
    public Card(ValueOfCard value){
        this.value = value;
    }

    public Card(SuitOfCard suit) {
        this.suit = suit;
    }

    public  void setValue(ValueOfCard value)
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
    public String toString() {
        return "Card{" +
                "suit = " + suit +
                ", value = " + value +
                '}';
    }
}
