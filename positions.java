import java.util.Arrays;
public class positions {
	//Horizontal A-H
	public String[] horizontal = {"A", "B", "C", "D", "E", "F", "G", "H"};
	//Vertical 1-8
	public String[] vertical = {"8", "7", "6", "5", "4", "3", "2", "1"};
	//2d list?
	String[][] boardPositions = new String[8][8];
	public void positions(){
		//create the 2d array
		for(int i =0; i<8; i++){
			for(int j =0; j<8; j++){
				//append the 2 strings
				this.boardPositions[i][j] = horizontal[j]+vertical[i];	
			}
		}
		for (String[] row : boardPositions) {
		    System.out.println(Arrays.toString(row));
		}
	}

	public static void main(String[] args) {
		positions board = new positions();	
		board.positions();
	}	
}
