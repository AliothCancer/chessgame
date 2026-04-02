import java.util.ArrayList;
import java.util.Optional;

import ChessMen.ChessCoor;
import ChessMen.ChessMan;
import ChessMen.GridCoor;
import ChessMen.ReachableCell;
import ChessMen.Renderable;

public class Selector implements Renderable {
	ChessMan chMan;
	private ArrayList<ReachableCell> reachCells = new ArrayList<>();

	Selector(ChessMan chMan) {
		this.chMan = chMan;
	}
	
	public void clearReachableCell(ChessGame game) {
		for (ReachableCell reachCell: this.reachCells) {
			var chCoor = reachCell.getPosition();
			if (game.chessBoard.getChMan(chCoor) instanceof ReachableCell r) {
				game.chessBoard.removeChessMan(chCoor);
			}
		}
		reachCells.clear();
	}
	public void showReachableCell(ChessGame game) {
		for (GridCoor gridCoor : this.chMan
				.generatePossibleMoves()) {
			var chCoor = gridCoor.toChessCoor();

			if (game.chessBoard.positionIsEmpty(chCoor)) {
				var reachCell = new ReachableCell(chCoor);
				this.reachCells.add(reachCell);
				game.chessBoard.insertChessMan(
						reachCell, chCoor);
			}

		}
	}
	public void selectByNameId(String nameId, ChessGame game) {
		this.chMan = game.chessBoard.getChMan(nameId);

	}

	Optional<ChessMan> getChMan() {
		return Optional.ofNullable(this.chMan);
	}

	@Override
	public String render() {
		String render = "None";

		if (this.chMan != null) {
			render = chMan.render();
			
		}

		return render;
	}

}
