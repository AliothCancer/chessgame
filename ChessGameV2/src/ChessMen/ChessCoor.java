package ChessMen;

public record ChessCoor(char column,
		int rank) implements Renderable {
	static final String ALLOWED_COLUMNS = "abcdefgh";
	static final String ALLOWED_RANKS = "12345678";

	public static ChessCoor fromString(String str)
			throws Exception {
		assert str != null;

		String cleanStr = str.strip();
		int strLen = cleanStr.length();

		if (strLen != 2) {
			throw new Exception("Length error for `" + cleanStr
					+ "`: expected 2 char, got " + strLen);
		}

		char column = cleanStr.charAt(0);
		char secondChar = cleanStr.charAt(1);

		if (ALLOWED_COLUMNS.indexOf(column) == -1) {
			throw new Exception("Invalid char for column `"
					+ column + "`, must be one char of: "
					+ ALLOWED_COLUMNS);
		}

		int rank = Character.getNumericValue(secondChar);
		if (ALLOWED_RANKS.indexOf(secondChar) == -1) {
			throw new Exception("Invalid number for rank `"
					+ rank + "`, must be one char of: "
					+ ALLOWED_RANKS);
		}

		return new ChessCoor(column, rank);
	}

	public GridCoor toGridCoor() {
		return new GridCoor(8 - this.rank, getColumnIndex());
	}

	private int getColumnIndex() {
		return ALLOWED_COLUMNS.indexOf(this.column);
	}

	@Override
	public String render() {
		return "" + this.column + this.rank;
	}
	public static ChessCoor fromGridCoor(GridCoor gridCoor) {
		return new ChessCoor(
				ALLOWED_COLUMNS.charAt(gridCoor.col()),
				Character.getNumericValue(ALLOWED_RANKS.charAt(8 - 1 - gridCoor.row()))
				);
	}
}