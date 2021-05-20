import java.util.ArrayList;

class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }

        int maxCrossPoint = 0;

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int crossPoints = findCrossPoint(i, j, points);
    
                if (maxCrossPoint < crossPoints) {
                    maxCrossPoint = crossPoints;
                }
            }
        }

        return maxCrossPoint;
    }

    private int findCrossPoint(int pos1, int pos2, int[][] points) {
        int x1 = points[pos1][0];
        int y1 = points[pos1][1];
        int x2 = points[pos2][0];
        int y2 = points[pos2][1];

        int crossPoints = 0;

        if (x1 != x2) {
            int ydiff = y1 - y2;
            int xdiff = x1 - x2;

            for (int i = 0; i < points.length; i++) {
                if (((points[i][1] - y1) * xdiff) == (ydiff * (points[i][0] - x1))) {
                    crossPoints++;
                }
            }
        } else {
            for (int i = 0; i < points.length; i++) {
                if (points[i][0] == x1) {
                    crossPoints++;
                }
            }
        }        

        return crossPoints;
    }
}