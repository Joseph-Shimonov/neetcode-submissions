class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if not board:
            return False
        
        row = defaultdict(set)
        col = defaultdict(set)
        cell = defaultdict(set)

        for r in range(len(board)):
            for c in range(len(board[r])):
                val = board[r][c]

                if val == '.':
                    continue
                
                if val in row[r] or val in col[c] or val in cell[(r//3, c//3)]:
                    return False

                row[r].add(val)
                col[c].add(val)
                cell[(r//3, c//3)].add(val)
        return True