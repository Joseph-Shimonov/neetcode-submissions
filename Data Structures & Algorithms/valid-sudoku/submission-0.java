class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }

        // we can solve this using a set
        Set<String> set = new HashSet<>();

        // iterate over the board
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                char val = board[r][c];
                if (val != '.') {
                    if (!set.add(val + "row" + r) || !set.add(val + "col" + c) || !set.add(val + "cell" + r/3 + " | " + c/3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
