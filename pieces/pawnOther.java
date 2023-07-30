package pieces;

public class pawnOther extends pawn{
    public boolean move(String initPos, String finalPos){
        return move(initPos, finalPos, 1);
    }
}
