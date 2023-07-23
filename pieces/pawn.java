package pieces;
import static board.positions.boardPositions;
import java.util.ArrayList;

import board.positions;

public class pawn {

	public String[] horizontal = {"A", "B", "C", "D", "E", "F", "G", "H"};
    private static int numberOfMovesInTotal = 0;
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
        for (ArrayList<ArrayList<String>> row : boardPositions) {
            System.out.println(row);
        }
    }
    public static boolean move(String initPos, String finalPos){
        //make sure mvmt follows rules
        //seperate the move into [][]
        //MAKE SURE THE INITIAL POS GOES BACK TO " "
        String[] initDirectionalMoveArray = initPos.split("");
        String[] finalDirectionalMoveArray = finalPos.split("");
        //record the number of moves pawn makes
        int initVerPos = Integer.parseInt(initDirectionalMoveArray[1]) + 6;
        int finalVerPos = Integer.parseInt(finalDirectionalMoveArray[1]) + 6;
        //convert the letter from POS to an ASCII number
        int initHorPos = (initDirectionalMoveArray[0]).charAt(0) - 65;
        int finalHorPos = (finalDirectionalMoveArray[0]).charAt(0) - 65;
        int numofHorMoves= finalHorPos - initHorPos;
        if (numofHorMoves<0){
            numofHorMoves = -numofHorMoves;
        }
        int numofVerMoves = initVerPos - finalVerPos;
        if (numofVerMoves<0){
            numofVerMoves = -numofVerMoves;
        }
        //if havent moved yet, can only move 1/2 vert
        if((numberOfMovesInTotal == 0) && (numofVerMoves <=2) && numofHorMoves==0) {
            //change the position on the board
            //check if the final pos on board is empty, 8-index = posOnBoard
            if(positions.boardPosChecker(finalPos)){
                //get the old pos string first
                ArrayList<ArrayList<String>> reqRow = boardPositions.get(initVerPos);
                ArrayList<String> reqPos = reqRow.get(initHorPos);
                String pieceString = reqPos.get(0);
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
            
            return true;
        }
        // else if  move diagonally 1 or vert 1, if alr moved b4
        else if((numofVerMoves>0) && ((numofVerMoves==1 && numofHorMoves ==0) || (numofVerMoves==1 && numofHorMoves ==1))){
            
            return true;
        }
        return false;
    } 
    public static void main(String[] args) {
       pawn pp = new pawn();
       move("A1","A2");
    }
}
