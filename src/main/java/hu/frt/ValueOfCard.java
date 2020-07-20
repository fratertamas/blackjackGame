package hu.frt;

public enum ValueOfCard {
    UNTER(2), OBER(3), KING(4), SEVEN(7), EIGHT(8), NINE(9), TEN(10), ACE(11);


    private final int value;

    ValueOfCard(int value) {
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
}
