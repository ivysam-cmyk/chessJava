package board;

import java.util.HashMap;

// this class records the moves of every piece in a dictionary
public class moveHistory {
    //create a dictionary where key is the pieceString and the value is no. of moves
    public static HashMap<String,Integer> moveCount = new HashMap<>(32);
}
