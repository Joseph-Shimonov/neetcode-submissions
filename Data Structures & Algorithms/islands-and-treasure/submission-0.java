class Solution {
    public void islandsAndTreasure(int[][] grid) {
        // edge case
        if (grid == null) {
            return;
        }

        // get the rows and the cols
        int rows = grid.length;
        int cols = grid[0].length;

        // create the queue
        Queue<int[]> queue = new LinkedList<>();

        // iterate over the grid and collect all of the starting points (treasure chest coordinates)
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    queue.add(new int[] {r, c});
                }
            }
        }

        // check if the queue is empty (no treasure chests)
        if (queue.isEmpty()) {
            return;
        } 

        // directions
        int[][] dirs = {{0,1}, {0, -1}, {1,0}, {-1,0}};

        // iterate over the queue
        while (!queue.isEmpty()) {
            // get the current element
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            // iterate over the directions
            for (int[] dir: dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow < 0 || newRow == rows || newCol < 0 || newCol == cols || grid[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }

                queue.add(new int[] {newRow, newCol});                
                grid[newRow][newCol] = grid[row][col] + 1;      // this will ensure that we are not changing the value of the treasure chest cell
            }

        }


    }
}
