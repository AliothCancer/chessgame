package ChessMen;

public enum Color {
	BLACK("b"), WHITE("w");
	
	final String c;
	
	Color(String c){
		this.c = c;
	}
	
	public static Color deserialize(String colorStr) {
		return switch (colorStr.strip()) {
			case "white" -> Color.WHITE;
			case "black" -> Color.BLACK;
			default -> throw new IllegalArgumentException(
		"Unexpected value: " + colorStr);
		};
	}
	
	@Override
	public String toString() {
		return this.c.toUpperCase();
	}
}
