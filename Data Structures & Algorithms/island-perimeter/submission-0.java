class Solution {
    private int[][] grid;
    private boolean[][] visited;
    private int rows, cols;

    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.visited = new boolean[rows][cols];
        int res = 0;
        for (int i = 0;i < rows; i++) {
            for (int j = 0;j<cols; j++) {
                if (grid[i][j] == 1) {
                    // check all for direction
                    res += (i+1 >= rows || grid[i+1][j] == 0) ? 1 : 0;
                    res += (j+1 >= cols || grid[i][j+1] == 0) ? 1 : 0;
                    res += (i-1 < 0 || grid[i-1][j] == 0) ? 1 : 0;
                    res += (j-1 < 0 || grid[i][j-1] == 0) ? 1 : 0;
                }
            }
        }
        return res;
    }
    public int dfs(int i, int j) {
        // base condition
        if (i < 0 || j < 0 || j>= cols || i >= rows || grid[i][j] == 0) {
            return 1;
        }

        if (visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;
        return dfs(i+1,j) + dfs(i,j+1) + dfs(i-1,j) + dfs(i,j-1);
    }
}