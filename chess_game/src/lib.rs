#![allow(unused)]

pub mod chessboard;
pub mod chessmen;
pub mod coordinates;

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
