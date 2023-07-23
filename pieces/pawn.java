package pieces;
import static board.positions.boardPositions;
import java.util.ArrayList;

public class pawn {

	int numberOfMovesInTotal = 0;
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
	/* public boolean move(String initPos, String finalPos){
		//make sure mvmt follows rules
		//seperate the move into [][]
		String[] initDirectionalMoveArray = initPos.split("");
		String[] finalDirectionalMoveArray = finalPos.split("");
		if((numberOfMovesInTotal == 0) && ((Integer.parseInt(finalDirectionalMoveArray[1]) - Integer.parseInt(initDirectionalMoveArray[1])) <=2)){
			//change the position on the board
		
		}
	} */
}
