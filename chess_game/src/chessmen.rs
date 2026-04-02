#[derive(Debug, Clone)]
pub struct ChessMan {
    color: Color,
    name_id: String,
    number: u8,
    position: ChessCoor,
    chessman: ChessManPiece,
    movement: Movement,
}
