class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] bestPrices = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bestPrices[i][j] = -1;
            }
        }

        for (int[] flight : flights) {
            bestPrices[flight[0]][flight[1]] = flight[2];
        }

        for (int stops = 0; stops < k; stops++) {
            int[][] newBestPrices = new int[n][n];
            for (int i = 0; i < n; i++) {
                System.arraycopy(bestPrices[i], 0, newBestPrices[i], 0, n);
            }

            for (int[] flight : flights) {
                int flightSrc = flight[0];
                int flightDst = flight[1];
                int flightCost = flight[2];

                for (int rootSrc = 0; rootSrc < n; rootSrc++) {
                    int prevCostToSrc = bestPrices[rootSrc][flightSrc];
                    if (prevCostToSrc != -1) {
                        int newCostToDst = prevCostToSrc + flightCost;
                        int currentCostToDst = newBestPrices[rootSrc][flightDst];
                        if (currentCostToDst == -1) {
                            newBestPrices[rootSrc][flightDst] = newCostToDst;
                        } else {
                            newBestPrices[rootSrc][flightDst] = Math.min(currentCostToDst,
                                    newCostToDst);
                        }
                    }
                }
            }

            bestPrices = newBestPrices;
        }

        return bestPrices[src][dst];
    }
}
