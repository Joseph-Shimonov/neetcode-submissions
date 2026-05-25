class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if not board:
            return False
        
        row = defaultdict(set)
        col = defaultdict(set)
        cell = defaultdict(set)

        for r in range(len(board)):
            for c in range(len(board[r])):
                if board[r][c] == '.':
                    continue
                
                num = board[r][c]
                if num in row[r] or num in col[c] or num in cell[(r//3, c//3)]:
                    return False
                
                row[r].add(num)
                col[c].add(num)
                cell[(r//3, c//3)].add(num)
        return True
