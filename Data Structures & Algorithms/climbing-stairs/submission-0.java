class Solution {
    // [0 1 2 3 4 5]
    // [1 1 2 3 5 8]
    public int[] mem;
    public int climbStairs(int n) {
        mem = new int[n+1];
        Arrays.fill(mem, -1);
        mem[0] = 1;
        mem[1] = 1;
        return helper(n, mem);

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
