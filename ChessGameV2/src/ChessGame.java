import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import ChessMen.ChessCoor;
import ChessMen.ChessMan;
import ChessMen.Color;

public class ChessGame {
	ChessBoard chessBoard = new ChessBoard();

	record ChessManDeserializer(ChessMan chMan, ChessCoor coor) {
		static final Set<String> allowedNames = Set.of("knight",
				"bishop", "pawn", "rook", "queen", "king");

		public static ChessManDeserializer deserialize(
				String name, String color, String coor)
				throws Exception {
			if (!allowedNames.contains(name))
				throw new IllegalArgumentException(
						"Invalid chessman name: `" + name + "`");

			ChessCoor position = ChessCoor.fromString(coor);
			return new ChessManDeserializer(
					ChessMan.deserialize(
							name,
							Color.deserialize(color),
							position
					),
					position);
		}
	}

	private ArrayList<String> loadChessMenStr() {
		ArrayList<String> content = new ArrayList<>();

		var file = new File("chessmen_placements.txt");

		try {
			Scanner sc = new Scanner(file);
			do {
				var line = sc.nextLine().strip();
				if (!line.isEmpty() && !line.startsWith("#"))
					content.add(line);

			} while (sc.hasNextLine());
			sc.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return content;
	}

	void populateChessBoard() throws Exception {
		for (String line : this.loadChessMenStr()) {
			String[] args = line.split(" ");
			
			var chManDes = ChessManDeserializer
					.deserialize(args[0], args[1], args[2]);
			
			this.chessBoard.insertChessMan(
					chManDes.chMan,
					chManDes.coor
				);
		}

	}

	void drawChessBoard() {
		System.out.println(chessBoard.render());
	}

}
