package ChessMen;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class ChessMan implements Renderable {
	protected static HashMap<String, Integer> chessMen = new HashMap<String, Integer>();
	/**
	 * Case sensitive, lowered for key matching
	 */
	private final String nameId;
	protected final Color color;
	protected final int number;
	private ChessCoor position;
	
	/**
	 * For example Kn for knight Bi for bishop, etc...
	 */
	protected final String chessName;

	public abstract ArrayList<GridCoor> generatePossibleMoves();

	public ChessMan(String chessName, Color color,
			ChessCoor position) {
		chessMen.merge(chessName, 1, Integer::sum);
		this.number = chessMen.get(chessName);
		this.nameId = buildNameId(chessName, this.number, color);
		this.chessName = chessName;
		this.color = color;
		this.position = position;

	}
	static String buildNameId(String chessName, int number,
			Color color) {
		return chessName.substring(0,2) + "-" + number + color;
	}
	@Override
	public String render() {
		String render = "";
		render += "\nnameId: " + this.getNameId();
		render += "\nchessman: " + this.chessName;
		render += "\nposition: " + this.getPosition().render();
		render += "\npossible moves: "
				+ generatePossibleMoves().stream()
						.map(gridCoor -> ChessCoor
								.fromGridCoor(gridCoor).render())
						.toList();
		return render;
	}

	public static ChessMan deserialize(String chManStr,
			Color color, ChessCoor position) {
		return switch (chManStr.strip()) {
			case "knight" -> new Knight(color, position);
			// default -> new ChessMan("chMa", color, position);
			default -> throw new IllegalArgumentException(
					"Unexpected value: " + chManStr.strip());
		};
	}
	public String getNameId() {
		return nameId;
	}
	public ChessCoor getPosition() {
		return position;
	}
	public void setPosition(ChessCoor position) {
		this.position = position;
	}
}
