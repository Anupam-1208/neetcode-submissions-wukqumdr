/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] s = new int[n];
        int[] e = new int[n];

        int i = 0;
        for(Interval in: intervals) {
            s[i] = in.start;
            e[i] = in.end;
            i++;
        }

        Arrays.sort(s);
        Arrays.sort(e);

        i = 0;
        int j = 0;
        int count = 0;
        int res = 0;
        while (i < n) {
            if (s[i] < e[j]) {
                i++;
                count++;
            } else {
                j++;
                count--;
            }
            res = Math.max(res, count);
        }


        return res;
    }
}
