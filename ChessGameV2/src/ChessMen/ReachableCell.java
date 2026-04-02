package ChessMen;

import java.util.ArrayList;

public class ReachableCell extends ChessMan {
	public static String showStr = "  x  ";
	public ReachableCell(
			ChessCoor position) {
		super("Re", Color.BLACK, position);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public ArrayList<GridCoor> generatePossibleMoves() {
		// TODO Auto-generated method stub
		throw new RuntimeException(
				"called generatePossibleMove method on Reachable which is not meant to be a normal ChessManCell");
	}

}
