class Solution {
    // [0 1 2 3 4 5]
    // [1 1 2 3 5 8]
    public int[] mem;
    public int climbStairs(int n) {
        // mem = new int[n+1];
        // // Arrays.fill(mem, -1);
        // mem[0] = 1;
        // mem[1] = 1;
        // // return helper(n, mem);

        // for (int i = 2;i<=n;i++) {
        //     mem[i] = mem[i-1] + mem[i-2];
        // }
        // return mem[n];

        int step1 = 1;
        int step2 = 1;

        for (int i=2;i<=n;i++) {
            int temp = step1;
            step1 = step1 + step2;
            step2 = temp;
        }
        return step1;

    }


//         5 
//      4       3
//    3   2   2   1 
//   2 1 1 0 1 0  
    public int helper(int n, int[] mem) {
        if (mem[n] != -1) {
            return mem[n];
        } 
        
        mem[n] = helper(n-1, mem) + helper(n-2, mem);
        return mem[n];
    }
}
