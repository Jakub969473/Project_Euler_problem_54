package entitties;

public class Suit {

    private Card[]cards;

    public Suit(){

    }

    public  int whichSuit(Card[] cards){

        this.cards = cards;

       /*One Pair: Two cards of the same value.
        Two Pairs: Two different pairs.
        Three of a Kind: Three cards of the same value.
        Straight: All cards are consecutive values.
        Flush: All cards of the same suit.
        Full House: Three of a kind and a pair.
        Four of a Kind: Four cards of the same value.
        Straight Flush: All cards are consecutive values of same suit.
        Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.*/

        if(containts(10) && containts(11) && containts(12) && containts(13) &&
                containts(14) && cards[0].getSuit()==cards[1].getSuit() &&
                cards[0].getSuit()==cards[2].getSuit() &&
                cards[0].getSuit()==cards[3].getSuit() &&
                cards[0].getSuit()==cards[4].getSuit()){

            return 23;

        }else if(cards[0].getValue()==cards[1].getValue()-1 &&
                cards[0].getValue()==cards[2].getValue()-2 &&
                cards[0].getValue()==cards[3].getValue()-3 &&
                cards[0].getValue()==cards[4].getValue()-4 &&
                cards[0].getSuit()==cards[1].getSuit() &&
                cards[0].getSuit()==cards[2].getSuit() &&
                cards[0].getSuit()==cards[3].getSuit() &&
                cards[0].getSuit()==cards[4].getSuit()){

            return 22;

        }else if(four()){

            return 21;

        }else if(twoAndThree()){

            return 20;

        }else if(cards[0].getSuit()==cards[1].getSuit() &&
                cards[0].getSuit()==cards[2].getSuit() &&
                cards[0].getSuit()==cards[3].getSuit() &&
                cards[0].getSuit()==cards[4].getSuit()){

            return 19;

        }else if(cards[0].getValue()==cards[1].getValue()-1 &&
                cards[0].getValue()==cards[2].getValue()-2 &&
                cards[0].getValue()==cards[3].getValue()-3 &&
                cards[0].getValue()==cards[4].getValue()-4){

            return 18;

        }else if(three()){
                return 17;
        }else if(twoPairs()){
            return 16;
        }else if(pair()){
            return 15;
        }else{
            return cards[4].getValue();
        }

    }



    private boolean twoPairs(){

        int equals=0;

        int amountOfPairs=0;

        for (int i=0;i<cards.length;i++) {
            for(int j=0;j<cards.length;j++){
                if(cards[i].getValue()==cards[j].getValue()){
                    equals++;
                }
            }
            if(equals==2){
                amountOfPairs++;
            }
                equals=0;
        }

        return amountOfPairs == 4;
    }

    private boolean pair() {

        int equals=0;

        for (int i=0;i<cards.length;i++) {
            for(int j=0;j<cards.length;j++){
                if(cards[i].getValue()==cards[j].getValue()){
                    equals++;
                }
            }
            if(equals==2){
                return true;
            }else{
                equals=0;
            }
        }

        return false;

    }

    private boolean three() {

        int equals=0;

        for (int i=0;i<cards.length;i++) {
          for(int j=0;j<cards.length;j++){
              if(cards[i].getValue()==cards[j].getValue()){
                  equals++;
              }
          }
            if(equals==3){
                return true;
            }else{
                equals=0;
            }
        }

        return false;
    }

    private boolean twoAndThree(){

        int equals=0;

        boolean two=false;

        boolean three=false;

        for (int i=0;i<cards.length;i++) {
            for(int j=0;j<cards.length;j++){
                if(cards[i].getValue()==cards[j].getValue()){
                    equals++;
                }
            }
            if(equals==3){
                three=true;
            }else if(equals==2){
                two=true;
            }
                equals=0;
        }

        return two && three;

    }

    private boolean four(){
        int equals=0;

        for (int i=0;i<cards.length;i++) {
            for(int j=0;j<cards.length;j++){
                if(cards[i].getValue()==cards[j].getValue()){
                    equals++;
                }
            }
            if(equals==4){
                return true;
            }else{
                equals=0;
            }
        }

        return false;
    }


    private boolean containts(int value){

        for (Card x:cards) {
            if(x.getValue()==value){
                return true;
            }
        }

        return false;
    }


}
