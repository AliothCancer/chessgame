import java.util.Scanner;

import ChessMen.ChessCoor;

public class Main {
	 
	public static void main(String[] args) {
		ChessGame game = new ChessGame();
		try {
			game.populateChessBoard();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		Scanner sc = new Scanner(System.in);
		Selector selector = new Selector(null);
		
		
		while (true) {
			game.drawChessBoard();
			
			String prompt = "\nSelected chessman: "+ selector.render() + "\n\n>> ";
			System.out.print(prompt);
		    Command cmd = Command.parse(sc.nextLine());

		    switch (cmd.type()) {
		        case QUIT    -> { System.out.println("Exiting...."); return; }
		        case HELP    -> printHelp();
		        case SHOW    -> handleShow(cmd.args()[1], game);
		        case SELECT  -> handleSelect(cmd.args()[1], game, selector);
		        case MOVE    -> handleMove(cmd.args()[1], cmd.args()[3], game, selector);
		        case UNKNOWN -> System.out.println("Comando sconosciuto: " + cmd.args()[0]);
		    }
			
		}
	}
	private static void handleMove(String nameId,
			String coor, ChessGame game, Selector selector) {
		
		try {
			ChessCoor destCoor = ChessCoor.fromString(coor.strip().toLowerCase());
			game.chessBoard.moveChessMan(nameId, destCoor);
			selector.clearReachableCell(game);
			selector.chMan = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private static void handleSelect(String nameId,
			ChessGame game, Selector selector) {
		
		if(game.chessBoard.isValidNameId(nameId)) {
			selector.clearReachableCell(game);
			selector.selectByNameId(nameId, game);
			selector.showReachableCell(game);
			
		}else {
			System.out.println("NameId: " + nameId + " is not valid!");
		}
	}
	private static void handleShow(String coor,
			ChessGame game) {
		try {
			ChessCoor chCoor = ChessCoor.fromString(coor);
			System.out.println("input: " + game.chessBoard.showCell(chCoor));
		} catch (Exception e) {
			System.out.println(e.toString());
		} 
	}
	static void printHelp() {
		
	}
	
}
