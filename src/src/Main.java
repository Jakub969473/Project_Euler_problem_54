import entitties.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String []args) throws FileNotFoundException {

        run();

    }


    private static void run() throws FileNotFoundException {

        File file=new File("C:\\Users\\torpe\\Desktop\\Project_Euler_problem_54\\src\\src\\poker.txt");

        Scanner in =new Scanner(file);

        int result=0;

        while(in.hasNextLine()){
            String [] line=in.nextLine().split(" ");

            Card[]player1=new Card[5];

            Card[]player2=new Card[5];


            for(int i=0;i< player1.length;i++){
                Card x=new Card(line[i].charAt(0),line[i].charAt(1));
                player1[i]=x;

            }

            for(int i=0;i< player1.length;i++){
                Card x=new Card(line[i+5].charAt(0),line[i+5].charAt(1));
                player2[i]=x;

            }

            System.out.println(" ");

            player1=bubbleSort(player1);

            player2=bubbleSort(player2);

            Suit suit =new Suit();

            int player1Deck=suit.whichSuit(player1);


            int player2Deck=suit.whichSuit(player2);

            if(player1Deck>player2Deck){
                result++;
            }else if(player1Deck==player2Deck){
                sameRankedDecks x=new sameRankedDecks(player1,player2,player1Deck);

                if(x.player1Won()){
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    private static Card[] bubbleSort(Card cards[])
    {
        int n = cards.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (cards[j].getValue() > cards[j + 1].getValue()) {
                    // swap arr[j+1] and arr[j]
                    Card temp = cards[j];
                    cards[j] = cards[j + 1];
                    cards[j + 1] = temp;
                }

        return cards;
    }

}
