/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n == 1) {
            return 1;
        }

        int lastFalse = 0;
        int lastTrue = n;

        while ((lastFalse + 1) != lastTrue) {
            int mid = (int)(((long)lastTrue + (long)lastFalse) / 2);
            if (isBadVersion(mid)) {
                lastTrue = mid;
            } else {
                lastFalse = mid;
            }
        }

        return lastTrue;
    }
}