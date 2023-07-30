package pieces;
import static board.positions.boardPositions;
import static board.positions.piecesAttacked;

import java.util.ArrayList;
import board.positions;

public class rook {
    public int multiplier = -1;
    private int numberOfMovesInTotal = 0;
    public static void pop(){
        ArrayList<ArrayList<String>> edgeRow = boardPositions.get(7);
        ArrayList<String> eachPos = new ArrayList<>();
        eachPos = edgeRow.get(0);
        eachPos.set(0,"r"+1);
        eachPos = edgeRow.get(7);
        eachPos.set(0,"r"+2);

        edgeRow = boardPositions.get(0);
        eachPos = new ArrayList<>();
        eachPos = edgeRow.get(0);
        eachPos.set(0,"r"+1);
        eachPos = edgeRow.get(7);
        eachPos.set(0,"r"+2);

    }
    public boolean move(String initPos, String finalPos,int multiplier){
        //if init pos is empty then quit
        if(positions.boardPosChecker(initPos)){
            System.out.println("------------");
            System.out.println("The initial position has no piece, try again.");
            System.out.println("------------");
            return false;
        }
        this.multiplier = multiplier;
        this.multiplier = multiplier;
        String[] initDirectionalMoveArray = initPos.split("");
        String[] finalDirectionalMoveArray = finalPos.split("");
        //record the number of moves pawn makes
        int initVerPos = 8-Integer.parseInt(initDirectionalMoveArray[1]);
        int finalVerPos = 8-Integer.parseInt(finalDirectionalMoveArray[1]);
        //convert the letter from POS to an ASCII number
        int initHorPos = (initDirectionalMoveArray[0]).charAt(0) - 65;
        int finalHorPos = (finalDirectionalMoveArray[0]).charAt(0) - 65;

        int numofHorMoves= finalHorPos - initHorPos;
        int numofVerMoves = finalVerPos - initVerPos;
        //after this numofVerMoves must be >0. 
        numofVerMoves = multiplier * numofVerMoves;
        System.out.println("Total moves by player 1: "+ numberOfMovesInTotal);
        System.out.println("The number of vertical moves: "+numofVerMoves+" and the number of horizontal moves: "+ numofHorMoves);

        if (positions.boardPosChecker(finalPos) && numofHorMoves ==0){
            //check all positions in a straight line between them
            ArrayList<String> betweenInF = new ArrayList<>();
            
        }

        return false;

    }
/*     public static void main(String[] args) {
    } */
}
