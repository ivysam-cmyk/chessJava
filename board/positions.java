package board;

import pieces.pawn;
import pieces.pawnOther;
import pieces.rook;

import java.util.ArrayList;
public class positions {
    // list of the pieces removed from the board by being attacked
    public static ArrayList<String> piecesAttacked = new ArrayList<>();
    //Horizontal A-H
    public String[] horizontal = {"A", "B", "C", "D", "E", "F", "G", "H"};
    //Vertical 1-8
    public String[] vertical = {"8", "7", "6", "5", "4", "3", "2", "1"};
    //2d list? 2d Arraylist is better
    // public String[][] boardPositions = new String[8][8];
    public static ArrayList<ArrayList<ArrayList<String>>> boardPositions = new ArrayList<>();
    //first 2d array is the board 8x8 board.positions
    //second layer is the arraylist containing first element is the piece and second item is the position which is constant.
    public void positions(){
        //create the 2d array
        for(int i =0; i<8; i++){
            ArrayList<ArrayList<String>> eachRow = new ArrayList<>();

            for(int j =0; j<8; j++){
                //create posArrayList
                ArrayList<String> eachPosArrayList = new ArrayList<>();
                eachPosArrayList.add(" ");
                eachPosArrayList.add(horizontal[j] + vertical[i]);
                eachRow.add(eachPosArrayList);
            }
            boardPositions.add(eachRow);
        }
        System.out.println("-------");
        pawn.pop();
        rook.pop();
        for (ArrayList<ArrayList<String>> row : boardPositions) {
            System.out.println(row);
        }
    }
    //checks if the particular pos is empty or occupied
    public static boolean boardPosChecker(String pos){
        String[] posArray = pos.split("");
        // when ASCII is 65, hor index is 0
        int horPos = (posArray[0]).charAt(0)-65;
        // when the pos has ver of 1 actual index is 7
        int verPos =  8-Integer.parseInt(posArray[1]);
        ArrayList<ArrayList<String>> reqRow = boardPositions.get(verPos);
        ArrayList<String> reqPos = reqRow.get(horPos);
        if(reqPos.get(0) == " "){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        positions board = new positions();
        board.positions();
        pawn pp = new pawn();
        pawn p1 = new pawn();
        // pawnOther p2 = new pawnOther();
        pp.move("A2","A4");
        p1.move("B2","B4");
        rook rr = new rook();
        rr.move("A1", "A2");
        rr.move("A2", "B2");
        rr.move("B2", "C2");
    }
}
