import java.math.BigInteger;
import java.util.HashMap;

class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }

        int maxCrossPoint = 0;

        for (int i = 0; i < points.length - 1; i++) {
            int crossPoints = findCrossPoint(i, points);

            if (maxCrossPoint < crossPoints) {
                maxCrossPoint = crossPoints;
            }
        }

        return maxCrossPoint;
    }

    private int findCrossPoint(int pos1, int[][] points) {
        HashMap<Pair, Integer> slopeMap = new HashMap<>();
        int x1 = points[pos1][0];
        int y1 = points[pos1][1];

        for (int otherPos = pos1 + 1; otherPos < points.length; otherPos++) {
            Pair slope = getSlopePair(pos1, points, x1, y1, otherPos);

            int count;
            if (slopeMap.containsKey(slope)) {
                count = slopeMap.get(slope) + 1;
            } else {
                count = 2;
            }

            slopeMap.put(slope, count);
        }

        return getMaxCrossPoint(slopeMap); 
    }

    private int getMaxCrossPoint(HashMap<Pair, Integer> slopeMap) {
        int maxCrossPoint = 0;
        for (int count : slopeMap.values()) {
            if (count > maxCrossPoint) {
                maxCrossPoint = count;
            }
        }
        return maxCrossPoint;
    }

    private Pair getSlopePair(int pos1, int[][] points, int x1, int y1, int otherPos) {
        int xdiff = points[otherPos][0] - x1;
        int ydiff = points[otherPos][1] - y1;

        if (xdiff == 0) {
            return new Pair(100, 0);
        } else if (ydiff == 0) {
            return new Pair(0, 100);
        } else {
            int gcd = BigInteger.valueOf(xdiff).gcd(BigInteger.valueOf(ydiff)).intValue();
            xdiff = xdiff / gcd;
            ydiff = ydiff / gcd;

            if (xdiff < 0) {
                xdiff = xdiff * -1;
                ydiff = ydiff * -1;
            }

            return new Pair(ydiff, xdiff);
        }
    }

    private class Pair {
        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getEnclosingInstance().hashCode();
            result = prime * result + key;
            result = prime * result + value;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Pair other = (Pair) obj;
            if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
                return false;
            if (key != other.key)
                return false;
            if (value != other.value)
                return false;
            return true;
        }

        private Solution getEnclosingInstance() {
            return Solution.this;
        }        
    }
}