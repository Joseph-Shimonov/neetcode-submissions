class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if not board:
            return False
        
        rows = defaultdict(set)
        cols = defaultdict(set)
        cells = defaultdict(set)

        for r in range(len(board)):
            for c in range(len(board[r])):
                val = board[r][c]

                if val == '.':
                    continue

                if val in rows[r] or val in cols[c] or val in cells[(r//3, c//3)]:
                    return False
                
                rows[r].add(val)
                cols[c].add(val)
                cells[(r//3, c//3)].add(val)
        return True