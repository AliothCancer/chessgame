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
			String input = sc.nextLine().toLowerCase();
			String[] cmdArgs = input.split(" ");
			
			
			
			if (cmdArgs[0].contains("q")) {
				System.out.println("Exiting....");
				break;
			}else if (cmdArgs.length < 2) {
				System.out.println("commands help:\nshow <col-rank> example: `show a1`,`show h8`");
				System.out.println("");
			}else if(cmdArgs[0].contains("sel")) {
				
				String nameId = cmdArgs[1];
				
				if(game.chessBoard.isValidNameId(nameId)) {
					selector.clearReachableCell(game);
					selector.selectByNameId(nameId, game);
					selector.showReachableCell(game);
					
				}else {
					System.out.println("NameId: " + nameId + " is not valid!");
				}
				
			}else if(cmdArgs[0].contains("show")) {
				try {
					ChessCoor chCoor = ChessCoor.fromString(cmdArgs[1]);
					System.out.println(input + ": " + game.chessBoard.showCell(chCoor));
				} catch (Exception e) {
					System.out.println(e.toString());;
				} 
			}else if(cmdArgs[0].contains("move")) {
				
				if (cmdArgs.length == 4) {
					boolean missingIn = false;
					if (!cmdArgs[2].strip().equals("in")) {
						missingIn = true;
						System.out.println(cmdArgs[0] + cmdArgs[1] + cmdArgs[2] + cmdArgs[3]);
						System.out.println("Missing keyword `in`");
					}
					if (!missingIn) {
						String nameId = cmdArgs[1].strip().toLowerCase();
						
						try {
							ChessCoor destCoor = ChessCoor.fromString(cmdArgs[3].strip().toLowerCase());
							game.chessBoard.moveChessMan(nameId, destCoor);
							selector.clearReachableCell(game);
							selector.chMan = null;
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					
				}else {
					System.out.println("Bad input: expected 4 arguments got " + cmdArgs.length);
				}
			}
			
		}
	}
	
	
}
