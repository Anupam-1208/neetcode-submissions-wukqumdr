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
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((o1, o2) -> Integer.compare(o1.start,o2.start));

        for(int i = 1;i<intervals.size();i++) {
            Interval curInterval = intervals.get(i);
            Interval prevInterval = intervals.get(i-1);
            if (curInterval.start < prevInterval.end) {
                return false;
            }
        }
        return true;
    }
}
