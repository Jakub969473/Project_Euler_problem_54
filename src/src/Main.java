import entitties.Card;

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

        while(in.hasNextLine()){
            String [] line=in.nextLine().split(" ");

            for(int i=0;i<line.length;i++){
                Card x=new Card(line[i].charAt(0),line[i].charAt(1));
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
}
