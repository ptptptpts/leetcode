import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
    public int nthUglyNumber(int n) {
        HashSet<Long> visitedNumber = new HashSet<>();
        PriorityQueue<Long> lowestQueue = new PriorityQueue<>();

        Long lastUgly = 0L;
        lowestQueue.add(1L);
        visitedNumber.add(1L);
        for (int i = 0; i < n; i++) {
            lastUgly = lowestQueue.poll();
            long twoFactor = lastUgly * 2;
            long threeFactor = lastUgly * 3;
            long fiveFactor = lastUgly * 5;

            if (!visitedNumber.contains(twoFactor)) {
                lowestQueue.add(twoFactor);
                visitedNumber.add(twoFactor);
            }
            if (!visitedNumber.contains(threeFactor)) {
                lowestQueue.add(threeFactor);
                visitedNumber.add(threeFactor);
            }
            if (!visitedNumber.contains(fiveFactor)) {
                lowestQueue.add(fiveFactor);
                visitedNumber.add(fiveFactor);
            }
        }

        return lastUgly.intValue();
    }
}
