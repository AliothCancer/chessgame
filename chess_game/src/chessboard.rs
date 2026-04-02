use std::{array, collections::HashMap};

use crate::chessmen::ChessMan;

pub struct ChessBoard {
    chessmen: [[Option<ChessMan>; 8]; 8],
    chessmen_by_name_id: HashMap<String, ChessMan>,
}

impl ChessBoard {
    pub fn new() -> Self {
        let chessmen: [[Option<ChessMan>; 8]; 8] = array::from_fn(|_| array::from_fn(|_| None));
        let chessmen_by_name_id = HashMap::new();
        Self {
            chessmen,
            chessmen_by_name_id,
        }
    }
}

impl Default for ChessBoard {
    fn default() -> Self {
        Self::new()
    }
}
