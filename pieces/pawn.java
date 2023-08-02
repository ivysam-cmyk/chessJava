package pieces;
import static board.positions.boardPositions;
import static board.positions.piecesAttacked;
import static board.moveHistory.moveCount;

import java.util.ArrayList;
import board.positions;

public class pawn {
    public int multiplier = -1;
    //first populate the board, there should be 8 pieces in the index X6
    public static void pop(){
        //get the 2d arraylist and change it
        ArrayList<ArrayList<String>> pawnRow = boardPositions.get(6);
        ArrayList<String> eachPos = new ArrayList<>();
        for(int i=1;i<9;i++){
            eachPos = pawnRow.get(i-1);
            eachPos.set(0,"p"+i);
            pawnRow.set(i-1,eachPos);
        }
        //populate the other player's pawns
        pawnRow = boardPositions.get(1);
        eachPos = new ArrayList<>();
        for(int i=1;i<9;i++){
            eachPos = pawnRow.get(i-1);
            eachPos.set(0,"P"+i);
            pawnRow.set(i-1,eachPos);
        }
        boardPositions.set(1,pawnRow);
    }

    public boolean move(String initPos, String finalPos,int multiplier){
        //if init pos is empty then quit
        if(positions.boardPosChecker(initPos)){
            System.out.println("------------");
            System.out.println("The initial position has no piece, try again.");
            System.out.println("------------");
            return false;
        }
        //keep the default value of multiplier at -1
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

        //the ver moves MUST BE -VE AND changed to +ve for the if condition
        //pawn piece should only go up (diagonally)
        System.out.println("The number of vertical moves: "+numofVerMoves+" and the number of horizontal moves: "+ numofHorMoves);
        if(numofVerMoves <= 0){
            return false;
        }
        System.out.println("The number of vertical moves: "+numofVerMoves+" and the number of horizontal moves: "+ numofHorMoves);
        //if havent moved yet, can only move 1/2 vert
        ArrayList<ArrayList<String>> reqRow = boardPositions.get(initVerPos);
        // reqPos is each singular pos on the board containing an array
        ArrayList<String> reqPos = reqRow.get(initHorPos);
        //get the old pos string first
        String pieceString = reqPos.get(0);
        int count = moveCount.containsKey(pieceString) ? moveCount.get(pieceString) : 0;
        System.out.println("Total moves by player 1: "+ count);
        if((count == 0) && (numofVerMoves <=2) && numofHorMoves==0) {
            if(positions.boardPosChecker(finalPos)){
                // get the initial number of moves of the current piece and increment
                moveCount.put(pieceString, count+1);
                reqPos.set(0, " ");
                reqRow = boardPositions.get(finalVerPos);
                reqPos = reqRow.get(finalHorPos);
                reqPos.set(0, pieceString);
            }
            //8-index = posOnBoard
            // get the name of the p from initPos
            return true;
        }
        // if moved b4, and movign w or without attacking other piece
        else if(count>0 && numofVerMoves==1){
            moveCount.put(pieceString, count+1);
            if(positions.boardPosChecker(finalPos)){
                //get the old pos string first
                reqRow = boardPositions.get(initVerPos);
                // reqPos is each singular pos on the board containing an array
                reqPos = reqRow.get(initHorPos);
                pieceString = reqPos.get(0);
                // make the old position back to blank
                reqPos.set(0, " ");
                reqRow = boardPositions.get(finalVerPos);
                reqPos = reqRow.get(finalHorPos);
                reqPos.set(0, pieceString);
            //else if pawn is attacking a piece, move diagonally
            } else if ((positions.boardPosChecker(finalPos) == false) && (numofHorMoves ==1 || numofHorMoves==-1) && numofVerMoves ==1){
                //the pawn attacks another piece only if it moves diag
                //get the piece at the final position
                reqRow = boardPositions.get(initVerPos);
                reqPos = reqRow.get(initHorPos);
                //get the name of the piece attacking
                pieceString = reqPos.get(0);
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
            return true;
        }
        return false;
    } 
    //when calling in p.s.v.m can call using only 2 parameters
    public boolean move (String initPos, String finalPos){
        return move(initPos, finalPos, -1);
    }
    // public static void main(String[] args) {
    // }
}
