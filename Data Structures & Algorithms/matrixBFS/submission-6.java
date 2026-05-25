class Solution {
    public int shortestPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0,0});
        visited.add("0,0");

        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                if (r == rows-1 && c == cols-1) {
                    return length;
                }

                int[][] neighbors = {{0,1},{0,-1},{1,0},{-1,0}};
                for (int[] neighbor : neighbors) {
                    int rtemp = neighbor[0] + r;
                    int ctemp = neighbor[1] + c;

                    if (rtemp < 0 || ctemp < 0 || rtemp == rows ||
                        ctemp == cols || visited.contains(rtemp + "," + ctemp) ||
                        grid[rtemp][ctemp] == 1
                    ) {
                        continue;
                    }
                    queue.add(new int[]{rtemp, ctemp});
                    visited.add(rtemp+","+ctemp);
                }
            }
            length++;
        }
        return -1;
    }
}
