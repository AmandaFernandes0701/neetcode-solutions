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

        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        for(int i = 0; i < intervals.size() - 1; i++)
        {
            // se start next for menor que end curr
            if(intervals.get(i+1).start < intervals.get(i).end) return false;
        }

        return true;
    }
}
