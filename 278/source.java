/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int leftWindow = 0;
        int rightWindow = n;

        while ((leftWindow + 1) < rightWindow) {
            int middle = leftWindow + (rightWindow - leftWindow) / 2;

            if (isBadVersion(middle)) {
                rightWindow = middle;
            } else {
                leftWindow = middle;
            }
        }

        return rightWindow;
    }
}
