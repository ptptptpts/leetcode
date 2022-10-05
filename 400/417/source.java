import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static final int PACIFIC_OCEAN = 1;
    public static final int ATLANTIC_OCEAN = 2;
    public static final int ALL_OCEAN = PACIFIC_OCEAN | ATLANTIC_OCEAN;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] oceanTouchMap = new int[m][n];
        for (int curM = 0; curM < m; curM++) {
            Arrays.fill(oceanTouchMap[curM], -1);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int curM = 0; curM < m; curM++) {
            for (int curN = 0; curN < n; curN++) {
                int visitedOcean = flowRainWater(heights, oceanTouchMap, curM, curN);
                if (visitedOcean == ALL_OCEAN) {
                    List<Integer> position = new ArrayList<>();
                    position.add(curM);
                    position.add(curN);
                    result.add(position);
                }
            }
        }

        return result;
    }

    private int flowRainWater(int[][] heights, int[][] oceanTouchMap, int posM, int posN) {
        int currentHeight = heights[posM][posN];

        if (oceanTouchMap[posM][posN] == -1) {
            oceanTouchMap[posM][posN] = 0;

            if ((posM == 0) || (posN == 0)) {
                oceanTouchMap[posM][posN] |= PACIFIC_OCEAN;
            }
            if ((posM == heights.length - 1) || (posN == heights[0].length - 1)) {
                oceanTouchMap[posM][posN] |= ATLANTIC_OCEAN;
            }

            oceanTouchMap[posM][posN] |= flowToLowerOrSameHeight(heights, oceanTouchMap, posM, posN,
                    currentHeight);
        } else {
            oceanTouchMap[posM][posN] |= checkSameHeight(heights, oceanTouchMap, posM, posN,
                    currentHeight);
        }

        return oceanTouchMap[posM][posN];
    }

    private int flowToLowerOrSameHeight(int[][] heights, int[][] oceanTouchMap, int posM, int posN,
            int currentHeight) {
        int reachedOcean = 0;

        if (posM > 0) {
            if ((currentHeight >= heights[posM - 1][posN])) {
                reachedOcean |= flowRainWater(heights, oceanTouchMap, posM - 1, posN);
            }
        }
        if (posM < heights.length - 1) {
            if ((currentHeight >= heights[posM + 1][posN])) {
                reachedOcean |= flowRainWater(heights, oceanTouchMap, posM + 1, posN);
            }
        }
        if (posN > 0) {
            if ((currentHeight >= heights[posM][posN - 1])) {
                reachedOcean |= flowRainWater(heights, oceanTouchMap, posM, posN - 1);
            }
        }
        if (posN < heights[0].length - 1) {
            if ((currentHeight >= heights[posM][posN + 1])) {
                reachedOcean |= flowRainWater(heights, oceanTouchMap, posM, posN + 1);
            }
        }

        return reachedOcean;
    }

    private int checkSameHeight(int[][] heights, int[][] oceanTouchMap, int posM, int posN,
            int currentHeight) {
        int reachedOcean = 0;

        if (posM > 0) {
            if ((currentHeight == heights[posM - 1][posN])
                    && (oceanTouchMap[posM - 1][posN] > 0 )) {
                reachedOcean |= oceanTouchMap[posM - 1][posN];
            }
        }
        if (posM < heights.length - 1) {
            if ((currentHeight == heights[posM + 1][posN])
                    && (oceanTouchMap[posM + 1][posN] > 0 )) {
                reachedOcean |= oceanTouchMap[posM + 1][posN];
            }
        }
        if (posN > 0) {
            if ((currentHeight == heights[posM][posN - 1])
                    && (oceanTouchMap[posM][posN - 1] > 0 )) {
                reachedOcean |= oceanTouchMap[posM][posN - 1];
            }
        }
        if (posN < heights[0].length - 1) {
            if ((currentHeight == heights[posM][posN + 1])
                    && (oceanTouchMap[posM][posN + 1] > 0 )) {
                reachedOcean |= oceanTouchMap[posM][posN + 1];
            }
        }

        return reachedOcean;
    }
}
