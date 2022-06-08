import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            int distance1 = o1[0] * o1[0] + o1[1] * o1[1];
            int distance2 = o2[0] * o2[0] + o2[1] * o2[1];
            return distance1 - distance2;
        });

        queue.addAll(Arrays.asList(points));

        ArrayList<int[]> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ret.add(queue.poll());
        }

        return ret.toArray(new int[][]{});
    }
}
