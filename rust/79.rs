impl Solution {
    pub fn exist(board: Vec<Vec<char>>, word: String) -> bool {
        let mut board = board;
        let word = word.as_bytes();
        for i in 0..board.len() {
            for j in 0..board[0].len() {
                if Self::dfs(&mut board, i as i32, j as i32, word, 0) {
                    return true;
                }
            }
        }
        false
    }
    fn dfs(board: &mut Vec<Vec<char>>, i: i32, j: i32, word: &[u8], k: usize) -> bool {
        if i < 0 || i as usize >= board.len() || j < 0 || j as usize >= board[0].len() || board[i as usize][j as usize] != word[k] as char {
            return false;
        }
        if k == word.len() - 1 {
            return true;
        }
        let tmp = board[i as usize][j as usize];
        board[i as usize][j as usize] = '/';
        let res = Self::dfs(board, i + 1, j, word, k + 1) || Self::dfs(board, i - 1, j, word, k + 1) || Self::dfs(board, i, j + 1, word, k + 1) || Self::dfs(board, i, j - 1, word, k + 1);
        board[i as usize][j as usize] = tmp;
        res
    }
}