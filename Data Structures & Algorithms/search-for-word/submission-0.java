class Solution {

    class State {
        int x, y, idx;
        boolean[][] visited;

        State(int x, int y, int idx, boolean[][] visited) {
            this.x = x;
            this.y = y;
            this.idx = idx;
            this.visited = visited;
        }
    }

    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    int m, n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        Deque<State> q = new ArrayDeque<>();

        // initialize BFS from all valid starting points
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[m][n];
                    visited[i][j] = true;
                    q.addLast(new State(i, j, 1, visited));
                }
            }
        }

        while (!q.isEmpty()) {
            State cur = q.removeFirst();

            if (cur.idx == word.length()) {
                return true;
            }

            for (int[] d : dirs) {
                int nx = cur.x + d[0];
                int ny = cur.y + d[1];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                if (!cur.visited[nx][ny] && board[nx][ny] == word.charAt(cur.idx)) {
                    // deep copy visited
                    boolean[][] newVisited = new boolean[m][n];
                    for (int i = 0; i < m; i++) {
                        newVisited[i] = cur.visited[i].clone();
                    }

                    newVisited[nx][ny] = true;
                    q.addLast(new State(nx, ny, cur.idx + 1, newVisited));
                }
            }
        }

        return false;
    }
}