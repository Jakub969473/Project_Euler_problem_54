package entitties;

public class sameRankedDecks {

    Card [] player1;

    Card [] player2;

    int playerDeckValue;



    public sameRankedDecks(Card [] player1,Card [] player2, int playerDeckValue,
                           int player2DeckValue){
        this.player1=player1;

        this.playerDeckValue=playerDeckValue;

        this.player2=player2;

    }

    public boolean player1Won(){

        if(playerDeckValue==23 || playerDeckValue == 22 || playerDeckValue == 19 ||
                playerDeckValue == 18){
            return highestValue();
        }else if(playerDeckValue == 21){
            return four();
        }else if(playerDeckValue==20){
            return fullHouse();
        }else if(playerDeckValue==17){
            return three();
        }else if(playerDeckValue==16){
            return twoPairs();
        }else {
            return pair();
        }
    }

    private boolean pair() {

        int equalsP1=0;
        int equalsP2=0;

        int p1Value=0;
        int p2Value=0;

        for (int i=0;i<player1.length;i++) {
            for(int j=0;j<player1.length;j++){
                if(player1[i].getValue()==player1[j].getValue()){
                    equalsP1++;
                }
                if(player2[i].getValue()==player2[j].getValue()){
                    equalsP2++;
                }
            }
            if(equalsP1==2){
            p1Value=player1[i].getValue();
            }
            equalsP1=0;

            if(equalsP2==2){
                p2Value=player2[i].getValue();
            }
            equalsP2=0;
        }

        return p1Value>p2Value;
    }

    private boolean twoPairs() {

        int equalsP1=0;
        int equalsP2=0;

        int p1Value=0;
        int p2Value=0;

        for (int i=0;i<player1.length;i++) {
            for(int j=0;j<player1.length;j++){
                if(player1[i].getValue()==player1[j].getValue()){
                    equalsP1++;
                }
                if(player2[i].getValue()==player2[j].getValue()){
                    equalsP2++;
                }
            }
            if(equalsP1==2 && p1Value<player1[i].getValue()){
                p1Value=player1[i].getValue();
            }

            equalsP1=0;

            if(equalsP2==2 && p2Value<player2[i].getValue()){
                p2Value=player2[i].getValue();
            }

            equalsP2=0;
        }

        return p1Value>p2Value;
    }

    private boolean three() {
        int equalsP1=0;
        int equalsP2=0;

        int p1Value=0;
        int p2Value=0;

        for (int i=0;i<player1.length;i++) {
            for(int j=0;j<player1.length;j++){
                if(player1[i].getValue()==player1[j].getValue()){
                    equalsP1++;
                }
                if(player2[i].getValue()==player2[j].getValue()){
                    equalsP2++;
                }
            }
            if(equalsP1==3){
                p1Value=player1[i].getValue();
            }
            equalsP1=0;

            if(equalsP2==3){
                p2Value=player2[i].getValue();
            }
            equalsP2=0;
        }

        return p1Value>p2Value;
    }

    private boolean fullHouse() {

        int equalsP1=0;
        int equalsP2=0;

        int p1Value=0;
        int p2Value=0;

        for (int i=0;i<player1.length;i++) {
            for(int j=0;j<player1.length;j++){
                if(player1[i].getValue()==player1[j].getValue()){
                    equalsP1++;
                }
                if(player1[i].getValue()==player1[j].getValue()){
                    equalsP2++;
                }
            }
            if(equalsP1==3){
                p1Value=player1[i].getValue();
            }
            equalsP1=0;

            if(equalsP2==3){
                p2Value=player2[i].getValue();
            }
            equalsP2=0;
        }

        if(p1Value>p2Value){
            return true;
        }else if(p1Value==p2Value){
            return pair();
        }else{
            return false;
        }

    }

    private boolean four() {

        int equalsP1=0;
        int equalsP2=0;

        int p1Value=0;
        int p2Value=0;

        for (int i=0;i<player1.length;i++) {
            for(int j=0;j<player1.length;j++){
                if(player1[i].getValue()==player1[j].getValue()){
                    equalsP1++;
                }
                if(player1[i].getValue()==player1[j].getValue()){
                    equalsP2++;
                }
            }
            if(equalsP1>2){
                p1Value=player1[i].getValue();
            }
            equalsP1=0;

            if(equalsP2>2){
                p2Value=player2[i].getValue();
            }
            equalsP2=0;
        }

        return p1Value>p2Value;
    }

    public boolean highestValue(){
        for(int i=4;i>=0;i--){
            if(player1[i].getValue()>player2[i].getValue()){
                return true;
            }else if(player1[i].getValue()<player2[i].getValue()){
                return false;
            }
        }
        return false;
    }


}
