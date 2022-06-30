import java.util.ArrayList;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ret = new ArrayList<>();

        int cursor = 0;
        boolean isNewIntervalAdded = false;
        for (; cursor < intervals.length; cursor++) {
            if (newInterval[0] < intervals[cursor][0]) {
                break;
            } else if (newInterval[0] > intervals[cursor][1]) {
                ret.add(intervals[cursor]);
            } else {
                newInterval[0] = intervals[cursor][0];
                break;
            }
        }
        for (; cursor < intervals.length; cursor++) {
            if (newInterval[1] < intervals[cursor][0]) {
                ret.add(newInterval);
                isNewIntervalAdded = true;
                break;
            } else if (newInterval[1] > intervals[cursor][1]) {
            } else {
                newInterval[1] = intervals[cursor][1];
                cursor++;
                ret.add(newInterval);
                isNewIntervalAdded = true;
                break;
            }
        }
        for (; cursor < intervals.length; cursor++) {
            ret.add(intervals[cursor]);
        }
        if (!isNewIntervalAdded) {
            ret.add(newInterval);
        }

        return ret.toArray(new int[][]{});
    }
}