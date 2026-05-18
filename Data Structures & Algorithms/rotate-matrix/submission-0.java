class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] res = new int[n][n];
        // 0 , 0 -> 0, 2
        // 0 , 1 -> 1, 2 
        // 0 , 2 -> 2, 2

        // 1, 0 -> 0, 1. ( i = j and j = n-i) 

        for (int i = 0;i<n;i++ ) {
            for ( int j = 0; j<n;j++) {
                int newi = j;
                int newj = n-i-1;
                res[newi][newj] = matrix[i][j];
            }
        }

        for (int i = 0;i<n;i++ ) {
            for ( int j = 0; j<n;j++) {
                matrix[i][j] = res[i][j];
            }
        }
    }
}
