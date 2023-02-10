package entitties;

public class Card {

    private int value;

    private char suit;

    public Card(char value,char suit){

        this.suit=suit;

        switch (value) {

            case 'T': this.value=10;
                break;

            case 'J': this.value=11;
                break;

            case 'Q': this.value=12;
                break;

            case 'K': this.value=13;
                break;

            case 'A':this.value=14;
                break;

            default: this.value=Character.getNumericValue(value);
                break;

        }

    }

    public String toString(){

        return ""+ value+suit;
    }
}
