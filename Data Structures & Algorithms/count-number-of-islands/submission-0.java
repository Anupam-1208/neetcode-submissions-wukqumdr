class Solution {
    private int rows;
    private int cols;
    private boolean[][] visited;
    private int[][] dirs = new int[][] {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        int islands = 0;
        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;

    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || visited[i][j] == true || grid[i][j] == '0') {
            return;
        }
        
        visited[i][j] = true;
        
        for (int k = 0; k< 4; k++) {
            dfs(grid, i+dirs[k][0], j+dirs[k][1]);
        }

    }
}
