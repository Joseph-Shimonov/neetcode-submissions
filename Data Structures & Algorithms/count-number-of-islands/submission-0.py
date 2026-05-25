class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return -1

        dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        rows, cols = len(grid), len(grid[0])

        def bfs(row, col):
            queue = deque([(row, col)])
            grid[row][col] = '0'

            while queue:
                curr_row, curr_col = queue.popleft()
                for row_add, col_add in dirs:
                    nr, nc = curr_row + row_add, curr_col + col_add
                    if 0 <= nr < rows and 0 <= nc < cols and grid[nr][nc] == '1':
                        queue.append((nr, nc))
                        grid[nr][nc] = '0'

        count = 0
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == '1':
                    count += 1
                    bfs(r, c)
        return count