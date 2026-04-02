use crate::{
    coordinates::{ChessCoor, GridCoor},
    *,
};

#[derive(Debug, Clone)]
pub struct ChessMan {
    color: Color,
    name_id: String,
    number: u8,
    position: ChessCoor,
    chessman: ChessManPiece,
    movement: Movement,
}
#[derive(Debug, Clone)]
pub struct Movement {
    allowed_dirs: Vec<Dir>,
    generator: fn(GridCoor) -> Vec<GridCoor>,
}
