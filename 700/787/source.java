class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[]bestPrices = new int[n];
        for (int i = 0; i < n; i++) {
            bestPrices[i] = -1;
        }

        for (int[] flight : flights) {
            if (flight[0] == src) {
                bestPrices[flight[1]] = flight[2];
            }
        }

        for (int stops = 0; stops < k; stops++) {
            int[] newBestPrices = new int[n];
            System.arraycopy(bestPrices, 0, newBestPrices, 0, n);

            for (int[] flight : flights) {
                int flightSrc = flight[0];
                int flightDst = flight[1];
                int flightCost = flight[2];

                int prevCostToSrc = bestPrices[flightSrc];
                if (prevCostToSrc != -1) {
                    int newCostToDst = prevCostToSrc + flightCost;
                    int currentCostToDst = newBestPrices[flightDst];
                    if (currentCostToDst == -1) {
                        newBestPrices[flightDst] = newCostToDst;
                    } else {
                        newBestPrices[flightDst] = Math.min(currentCostToDst, newCostToDst);
                    }
                }
            }

            bestPrices = newBestPrices;
        }

        return bestPrices[dst];
    }
}
