class Solution {
    public int maxProfit(int[] prices) {
        int m = 0;
        int max = 0;
        for (int i = 0;i<prices.length; i++) {
            if (prices[i]<=prices[m]) {
                m = i;
            } else {
                max = Math.max(max, prices[i]-prices[m]);
            }
        }
        return max;
    }
}
