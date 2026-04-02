#![allow(unused)]

mod chessboard;
mod chessmen;
mod coordinates;

use std::collections::HashMap;

pub struct ChessBoard {
    chessmen: [[Option<ChessMan>; 8]; 8],
    chessmen_by_name_id: HashMap<String, ChessMan>,
}

#[derive(Debug, Clone, Copy)]
pub enum Color {
    Black,
    White,
}

#[derive(Debug, Clone, Copy)]
pub enum ChessManPiece {
    Knight,
    //Pawn,
    // others todo!
}
#[derive(Debug, Clone)]
pub struct Movement {
    allowed_dirs: Vec<Dir>,
    generator: fn(GridCoor) -> Vec<GridCoor>,
}
pub trait Coordinate {}
#[derive(Debug, Clone, Copy)]
pub enum Dir {
    Left,
    Right,
    Down,
    Up,
    UpLeft,
    UpRight,
    DownLeft,
    DownRight,
}
