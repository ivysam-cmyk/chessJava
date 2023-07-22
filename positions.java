import java.util.ArrayList;
import java.util.Arrays;
public class positions {
	//Horizontal A-H
	public String[] horizontal = {"A", "B", "C", "D", "E", "F", "G", "H"};
	//Vertical 1-8
	public String[] vertical = {"8", "7", "6", "5", "4", "3", "2", "1"};
	//2d list? 2d Arraylist is better
	// public String[][] boardPositions = new String[8][8];
	ArrayList<ArrayList<ArrayList<String>>> boardPositions = new ArrayList<>();
	//first 2d array is the board 8x8 positions
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
		for (ArrayList<ArrayList<String>> row : boardPositions) {
		    System.out.println(row);
		}
	}

	public static void main(String[] args) {
		positions board = new positions();	
		board.positions();
	}	
}
