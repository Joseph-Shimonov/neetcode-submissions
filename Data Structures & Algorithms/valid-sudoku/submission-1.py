class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if not board:
            return False
        
        s = set()
        for r in range(len(board)):
            for c in range(len(board[r])):
                val = board[r][c]
                if val != '.':
                    row_key = f"{val} row {r}"
                    col_key = f"{val} col {c}"
                    cell_key = f"{val} cell {r//3} | {c//3}"
                    if row_key in s or col_key in s or cell_key in s:
                        return False
                    s.add(row_key)
                    s.add(col_key)
                    s.add(cell_key)
        return True