package hu.frt;

public class Card {

    private ValueOfCard value;

    public Card(){
        this.value = value;
    }
    public Card(ValueOfCard value){
        this.value = value;
    }
    public  void setValue(ValueOfCard value)
    {
        this.value = value;
    }

    public ValueOfCard getValue()
    {
        return value;
    }

    @Override
    public String toString() {
        return "Card{" +
                ", value=" + value +
                '}';
    }
}
