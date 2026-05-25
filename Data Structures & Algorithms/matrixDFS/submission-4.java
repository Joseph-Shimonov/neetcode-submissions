class Solution {
    public int countPaths(int[][] grid) {
        return dfs(grid, 0, 0, new HashSet<>());
    }

    public int dfs(int[][] grid, int row, int col, Set<String> visited) {
        // base cases
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == 1 || visited.contains(row + "," + col)) {
            return 0;
        }
        if (row == grid.length-1 && col == grid[row].length-1) {
            return 1;
        }

        // if we got here, we are still iterating thru the grid
        // add the spot that we are currently in to visited
        visited.add(row+","+col);
        int count = 0;

        count += dfs(grid, row+1, col, visited);
        count += dfs(grid, row-1, col, visited);
        count += dfs(grid, row, col+1, visited);
        count += dfs(grid, row, col-1, visited);

        visited.remove(row+","+col);
        return count;
    }
}
