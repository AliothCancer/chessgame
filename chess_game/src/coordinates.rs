use std::ops::{Range, RangeInclusive};

const ALLOWED_CHESS_COLUMNS: &[u8; 8] = b"abcdefgh";
const ALLOWED_RANKS: RangeInclusive<u8> = 1..=8;
#[derive(Debug, Clone, Copy)]
pub struct ChessCoor {
    column: char,
    rank: u8,
}

const ALLOWED_COLUMNS: Range<u8> = 0..8;
const ALLOWED_ROWS: Range<u8> = ALLOWED_COLUMNS;
#[derive(Debug, Clone, Copy)]
pub struct GridCoor {
    column: u8,
    row: u8,
}

impl From<GridCoor> for ChessCoor {
    fn from(grid_coor: GridCoor) -> Self {
        let column = ALLOWED_CHESS_COLUMNS[grid_coor.column as usize] as char;
        ChessCoor {
            column,
            rank: 8 - grid_coor.row,
        }
    }
}

/*
*
let column = ALLOWED_CHESS_COLUMNS
    .iter()
    .zip(0_u8..)
    .find_map(|(n, ch)| (*n == grid_coor.column).then_some(ch))
    .unwrap()
    .to_owned() as char;
*/
