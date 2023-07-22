package pieces;
public class pawn {
	int numberOfMovesInTotal = 0;
	public boolean move(String initPos, String finalPos){
		//make sure mvmt follows rules
		//seperate the move into [][]
		String[] initDirectionalMoveArray = initPos.split("");
		String[] finalDirectionalMoveArray = finalPos.split("");
		if((numberOfMovesInTotal == 0) && ((Integer.parseInt(finalDirectionalMoveArray[1]) - Integer.parseInt(initDirectionalMoveArray[1])) <=2)){
			//change the position on the board
			boardPositions			
		}
	}
}
