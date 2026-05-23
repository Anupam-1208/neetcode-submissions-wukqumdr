class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // keep the smaller interval
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1],b[1]));
        int prev = 0;
        int prevEnd = intervals[0][1];
        int res = 0;
        for(int i = 1;i<intervals.length;i++) {
            if (prevEnd > intervals[i][0]) {
                res++;
            } else {
                prevEnd = intervals[i][1];
            }
        }
        return res;
    }
}
