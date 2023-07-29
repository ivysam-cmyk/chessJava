package pieces;
import static board.positions.boardPositions;
import static board.positions.piecesAttacked;

import java.util.ArrayList;
import java.util.Scanner;

import board.positions;

public class pawn {
    public String[] horizontal = {"A", "B", "C", "D", "E", "F", "G", "H"};
    private int numberOfMovesInTotal = 0;
    //first populate the board, there should be 8 pieces in the index X6
    public static void pawnPop(){
        //get the 2d arraylist and change it
        ArrayList<ArrayList<String>> pawnRow = boardPositions.get(6);
        ArrayList<String> eachPos = new ArrayList<>();
        for(int i=0;i<8;i++){
            eachPos = pawnRow.get(i);
            eachPos.set(0,"p"+i);
            pawnRow.set(i,eachPos);
        }
        boardPositions.set(6,pawnRow);
        //populate the other player's pawns
        pawnRow = boardPositions.get(1);
        eachPos = new ArrayList<>();
        for(int i=0;i<8;i++){
            eachPos = pawnRow.get(i);
            eachPos.set(0,"p"+i);
            pawnRow.set(i,eachPos);
        }
        boardPositions.set(1,pawnRow);
        for (ArrayList<ArrayList<String>> row : boardPositions) {
            System.out.println(row);
        }
    }

    public boolean move(String initPos, String finalPos,Integer multiplier){
        //keep the default value of multiplier at -1
        multiplier = multiplier == null ? -1 : multiplier;
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

        //the ver moves MUST BE -VE AND changed to +ve for the if condition
        System.out.println("Total moves by player 1: "+ numberOfMovesInTotal);
        //pawn piece should only go up (diagonally)
        if(numofVerMoves <= 0){
            return false;
        }

        System.out.println("The number of vertical moves: "+numofVerMoves+" and the number of horizontal moves: "+ numofHorMoves);
        //if havent moved yet, can only move 1/2 vert
        if((numberOfMovesInTotal == 0) && (numofVerMoves <=2) && numofHorMoves==0) {
            //change the position on the board
            //check if the final pos on board is empty, 8-index = posOnBoard
            if(positions.boardPosChecker(finalPos)){
                //get the old pos string first
                ArrayList<ArrayList<String>> reqRow = boardPositions.get(initVerPos);
                // reqPos is each singular pos on the board containing an array
                ArrayList<String> reqPos = reqRow.get(initHorPos);
                String pieceString = reqPos.get(0);
                // make the old position back to blank
                reqPos.set(0, " ");
                reqRow = boardPositions.get(finalVerPos);
                reqPos = reqRow.get(finalHorPos);
                reqPos.set(0, pieceString);
                System.out.println(pieceString);
                System.out.println(" The new board ... ");
                for (ArrayList<ArrayList<String>> row : boardPositions) {
                    System.out.println(row);
                }
            }
            //8-index = posOnBoard
            // get the name of the p from initPos
            numberOfMovesInTotal+=1;
            return true;
        }
        // if moved b4, and movign w or without attacking other piece
        else if(numberOfMovesInTotal>0 && numofVerMoves==1){
            if(positions.boardPosChecker(finalPos)){
                //get the old pos string first
                ArrayList<ArrayList<String>> reqRow = boardPositions.get(initVerPos);
                // reqPos is each singular pos on the board containing an array
                ArrayList<String> reqPos = reqRow.get(initHorPos);
                String pieceString = reqPos.get(0);
                // make the old position back to blank
                reqPos.set(0, " ");
                reqRow = boardPositions.get(finalVerPos);
                reqPos = reqRow.get(finalHorPos);
                reqPos.set(0, pieceString);
                System.out.println("After player 1 moves... ");
            //else if pawn is attacking a piece, move diagonally
            } else if ((positions.boardPosChecker(finalPos) == false) && (numofHorMoves ==1 || numofHorMoves==-1) && numofVerMoves ==1){
                //the pawn attacks another piece only if it moves diag
                //get the piece at the final position
                ArrayList<ArrayList<String>> reqRow = boardPositions.get(initVerPos);
                ArrayList<String> reqPos = reqRow.get(initHorPos);
                //get the name of the piece attacking
                String pieceString = reqPos.get(0);
                //set the init pos to " "
                reqPos.set(0, " ");
                reqRow = boardPositions.get(finalVerPos);
                reqPos = reqRow.get(finalHorPos);
                //add the attacked piece to an arraylist
                piecesAttacked.add(reqPos.get(0));
                
                System.out.println("Pieces attacked: "+piecesAttacked);
                reqPos.set(0, pieceString);
                //change the pos on the board being attacked
                reqRow.set(finalHorPos, reqPos);
                boardPositions.set(finalVerPos, reqRow);
            }
            numberOfMovesInTotal+=1;
            for (ArrayList<ArrayList<String>> row : boardPositions) {
                System.out.println(row);
            }
            return true;
        }
        return false;
    } 
    // public static void main(String[] args) {
    // }
}
