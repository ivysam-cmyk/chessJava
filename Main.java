import java.util.ArrayList;
import java.util.Scanner;
import board.positions;
import pieces.pawn;
import pieces.pawnOther;

import static board.positions.boardPositions;

public class Main {
    static int i=0;
    static String[] posArray = new String[2];
    public static String[] asker(String playerNum){
        String initPos;
        String finalPos;
        System.out.println("Player "+ playerNum+ " make your move");
        System.out.print("Initial position: ");
        Scanner s = new Scanner(System.in);
        initPos = s.nextLine();
        System.out.println("-----------");
        System.out.print("Final position: ");
        finalPos = s.nextLine();
        System.out.println("-----------");
        posArray[0]= initPos;
        posArray[1] = finalPos;
        return posArray;
    }
    public void classMatcher(){
        positions board = new positions();
        board.positions();
        do{
            String[] p1posArray = asker("1");
            if (p1posArray[0].substring(1).equals("2")){
                System.out.println("if cond satisfied");
                pawn p1 = new pawn();
                p1.move(p1posArray[0], p1posArray[1]);
                i+=1;
                for (ArrayList<ArrayList<String>> row : boardPositions) {
                    System.out.println(row);
                }
            }else{
                break;
            }
            //player 2
            String[] p2posArray = asker("2");
            if (p2posArray[0].substring(1).equals("7")){
                System.out.println("p2 if cond");
                pawn p2 = new pawnOther();
                p2.move(p2posArray[0], p2posArray[1]);
                i+=1;
                for (ArrayList<ArrayList<String>> row : boardPositions) {
                    System.out.println(row);
                }

            }else{
                break;
            }
        }while(i<2);
    }

    public static void main(String[] args) {
        Main game1 = new Main();
        game1.classMatcher();
    }
}