import java.util.HashMap;

import ChessMen.ChessCoor;
import ChessMen.ChessMan;
import ChessMen.GridCoor;
import ChessMen.ReachableCell;
import ChessMen.Renderable;

public class ChessBoard implements Renderable {
	private ChessMan[][] chessBoard = new ChessMan[8][8];
	private HashMap<String, ChessMan> chMenByName = new HashMap<>();
	
	public boolean isValidNameId(String nameId) {
		return chMenByName.containsKey(nameId);
	}
	ChessMan getChMan(String nameId) {
		return this.chMenByName.get(nameId);
	}
	
	ChessMan getChMan(ChessCoor chCoor) {
		GridCoor gridCoor = chCoor.toGridCoor();
		return this.chessBoard[gridCoor.row()][gridCoor.col()];
	}
	boolean positionIsEmpty(ChessCoor coor) {
		return getChMan(coor) == null;
	}
	ChessMan getChMan(GridCoor gridCoor) {
		return this.chessBoard[gridCoor.row()][gridCoor.col()];
	}

	void insertChessMan(ChessMan chMan, ChessCoor chCoor) {
		GridCoor gridCoor = chCoor.toGridCoor();
		// adding to the array for coor access
		this.chessBoard[gridCoor.row()][gridCoor.col()] = chMan;
		// adding to the hashmap for nameId access
		chMenByName.put(chMan.getNameId().toLowerCase(), chMan);
	}

	void moveChessMan(String nameId, ChessCoor chCoorNew) {
		if (chMenByName.containsKey(nameId)) {
			ChessMan chMan = this.chMenByName.get(nameId);
			
			if (!positionIsEmpty(chCoorNew))
				removeChessMan(chCoorNew);

			removeChessMan(chMan.getPosition());

			chMan.setPosition(chCoorNew);
			insertChessMan(chMan, chCoorNew);

		}else {
			System.out.println("Name: " + nameId + " not found!");
		}
	}

	void removeChessMan(ChessCoor chCoor) {
		GridCoor gridCoor = chCoor.toGridCoor();
		var key = this.chessBoard[gridCoor.row()][gridCoor.col()]
				.getNameId();

		this.chessBoard[gridCoor.row()][gridCoor.col()] = null;
		chMenByName.remove(key);
	}

	String showCell(ChessCoor chCoor) {
		String cellStr = "Empty";

		ChessMan chMan = getChMan(chCoor);
		if (chMan != null) {
			cellStr = chMan.getNameId();
		}
		return cellStr + " of " + chMan.getClass();

	}

	@Override
	public String render() {
		String render = "     a      b      c      d      e      f      g      h\n";
		render +=       "   ______________________________________________________";
		int rowEn = 8;
		for (ChessMan[] chMen : chessBoard) {
			render += "\n";
			render += rowEn + " ";
			rowEn -= 1;
			for (ChessMan chMan : chMen) {
				if (chMan == null) {
					render += "[     ]";
				}else if (chMan instanceof ReachableCell reachCell) {
					render += ("[" + ReachableCell.showStr  + "]");;
				}else {
					render += ("[" + chMan.getNameId() + "]");
				}
			}
		}
		//        "   ______________________________________________________"
		render += "\n   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯";
		return render;
	}
}
