package ChessMen;

import java.util.ArrayList;

public class Knight extends ChessMan {

	Knight(Color color, ChessCoor position) {
		super("Knight", color, position);
	}

	@Override
	public ArrayList<GridCoor> generatePossibleMoves() {
		var moves = new ArrayList<GridCoor>();

		var curCoor = super.getPosition().toGridCoor();

		for (Dir dir : Dir.values()) {
			if (dir.isDiagonal()) continue;
			
			GridCoor moveRoot = curCoor.offset(dir, 2);
			GridCoor movePerp1 = moveRoot.offset(dir.rotateClockWise(), 1);
			GridCoor movePerp2 = moveRoot.offset(dir.rotateCounterClockWise(), 1);

			if (movePerp1.isValid()) {
				moves.add(movePerp1);
			}
			if (movePerp2.isValid()) {
				moves.add(movePerp2);
			}
		}
		return moves;
	}

}
