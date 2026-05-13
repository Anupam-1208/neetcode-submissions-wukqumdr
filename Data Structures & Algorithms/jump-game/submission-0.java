class Solution {
    public boolean canJump(int[] nums) {
        return dfs(nums, 0);
    }

    public boolean dfs(int[] nums,int cur) {
        if (cur > nums.length -1) {
            return false;
        }
        if (cur == nums.length -1 ){
            return true;
        }

        int jumps = nums[cur];
        if (jumps == 0) return false;
        for(int i = 1;i<=jumps;i++) {
            if (dfs(nums, cur+i)) {
                return true;
            }
        }
        return false;
    }
}
