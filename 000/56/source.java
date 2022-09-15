import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> ret = new ArrayList<>();

        int[] newInterval = intervals[0];
        for (int cursor = 1; cursor < intervals.length; cursor++) {
            int[] currentInterval = intervals[cursor];
            if (newInterval[1] < currentInterval[0]) {
                ret.add(newInterval);
                newInterval = currentInterval;
            } else {
                newInterval[1] = Math.max(newInterval[1], currentInterval[1]);
            }
        }
        ret.add(newInterval);

        return ret.toArray(new int[0][0]);
    }
}
