import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int erase = 0;
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);

        int previousEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < previousEnd) {
                erase++;
            } else {
                previousEnd = intervals[i][1];
            }
        }

        return erase;
    }
}
