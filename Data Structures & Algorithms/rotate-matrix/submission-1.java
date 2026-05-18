class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 0 , 0 -> 0, 2
        // 0 , 1 -> 1, 2 
        // 0 , 2 -> 2, 2

        // 1, 0 -> 0, 1. ( i = j and j = n-i) 

        reverse(matrix);

        for (int i = 0;i<n;i++ ) {
            for ( int j = i; j<n;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public void reverse(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i< n/2;i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n-1-i];
            matrix[n-i-1] = temp;
        }
    }
}
