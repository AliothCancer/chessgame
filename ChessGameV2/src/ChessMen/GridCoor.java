package ChessMen;

public record GridCoor(int row, int col) {
	public ChessCoor toChessCoor() {
		return ChessCoor.fromGridCoor(this);
	}
	
	public GridCoor offset(Dir dir, int steps) {
		return switch (dir) {
			case LEFT ->
				new GridCoor(this.row(), this.col() - steps);
			case RIGHT ->
				new GridCoor(this.row(), this.col() + steps);
			case DOWN ->
				new GridCoor(this.row() + steps, this.col());
			case UP ->
				new GridCoor(this.row() - steps, this.col());
			case DOWN_LEFT ->
				new GridCoor(this.row() + steps, this.col() - steps);
			case DOWN_RIGHT ->
				new GridCoor(this.row() + steps, this.col() + steps);
			case UP_LEFT ->
				new GridCoor(this.row() - steps, this.col() - steps);
			case UP_RIGHT -> 
				new GridCoor(this.row() - steps, this.col() + steps);
		};
	}
	public boolean isValid() {
		return this.col >= 0 && this.col < 8 
				&& this.row >= 0 && this.row < 8;
	}
	
	/*
	 * private Function<Integer, GridCoor> moveBuilder(Dir dir1, Dir dir2) {
		Function<Integer, GridCoor> diagFunc = n -> this.offset(dir1, n).offset(dir2, n);
		return diagFunc;
	}
	public GridCoor moveDiagUpLeft(int steps) {
		var func = moveBuilder(Dir.UP, Dir.LEFT);
		return func.apply(steps);
	}
	public GridCoor moveDiagDownLeft(int steps) {
		var func = moveBuilder(Dir.DOWN, Dir.LEFT);
		return func.apply(steps);
	}
	public GridCoor moveDiagUpRight(int steps) {
		var func = moveBuilder(Dir.UP, Dir.RIGHT);
		return func.apply(steps);
	}
	public GridCoor moveDiagDownRight(int steps) {
		var func = moveBuilder(Dir.DOWN, Dir.RIGHT);
		return func.apply(steps);
	}
	 */
}
