use std::io::Write;

use chess_game::chessboard::ChessBoard;

fn main() {
    let mut chessboard = ChessBoard::new();
    loop {
        let mut cmd = String::new();
        match *prompt(&mut cmd).as_slice() {
            ["q"] => break,
            ["move", name_id, "in", coor] => {
                println!(
                    "move command received with:\n\tname_id: {}\n\tcoor: {}",
                    name_id, coor
                )
            }
            _ => {
                continue;
            }
        }
    }
}

fn prompt(cmd: &mut String) -> std::vec::Vec<&str> {
    print!(">> ");
    std::io::stdout().flush().expect("error while flushing");
    std::io::stdin()
        .read_line(cmd)
        .expect("Error while reading input");
    let args = cmd.split_whitespace().collect::<Vec<_>>();
    println!("{:?}", args);
    args
}
