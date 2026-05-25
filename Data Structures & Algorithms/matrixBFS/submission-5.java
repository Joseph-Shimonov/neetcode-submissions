class Solution {
    public int shortestPath(int[][] grid) {
        if (grid == null) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[2]);
        visited[0][0] = 1;

        int length = 0;     // this value will increment for each layer that we add
        while (!queue.isEmpty()) {
            int queueLength = queue.size();

            // queueLength is going to contain everything from the previous step
            for (int i = 0; i < queueLength; i++) {
                // get the pair from the front of the queue
                int[] pair = queue.poll();
                int r = pair[0];
                int c = pair[1];

                System.out.println(r + ", " + c);

                // check if r and c are at the bottom right
                if (r == rows-1 && c == cols-1) {
                    return length;
                }

                int[][] neighbors = {{r, c+1}, {r, c-1}, {r+1, c}, {r-1, c}};

                // iterate thru the neighbors
                for (int j = 0; j < 4; j++) {
                    // get the new position
                    int rtemp = neighbors[j][0];
                    int ctemp = neighbors[j][1];

                    // check if the new positions are in the bounds of the grid
                    if (rtemp < 0 || ctemp < 0 || rtemp == rows || ctemp == cols || grid[rtemp][ctemp] == 1 || visited[rtemp][ctemp] == 1) {
                        continue;
                    }
                    queue.add(neighbors[j]);
                    visited[rtemp][ctemp] =1;
                }

            }
            length++;
        } 
        return -1;
    }
}
