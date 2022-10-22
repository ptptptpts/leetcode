class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minimumWeightCapa = weights[0];
        int maximumWeightCapa = 0;
        for (int cursor = 0; cursor < weights.length; cursor++) {
            maximumWeightCapa += weights[cursor];
            minimumWeightCapa = Math.max(minimumWeightCapa, weights[cursor]);
        }
        minimumWeightCapa -= 1;

        int leastWeightCapa = maximumWeightCapa;
        while (minimumWeightCapa < (leastWeightCapa - 1)) {
            int mediumWeightCapa = (minimumWeightCapa + leastWeightCapa) / 2;

            if (calculateDaysToShip(weights, mediumWeightCapa) <= days) {
                leastWeightCapa = mediumWeightCapa;
            } else {
                minimumWeightCapa = mediumWeightCapa;
            }
        }
        return leastWeightCapa;
    }

    private int calculateDaysToShip(int[] weights, int weightCapa) {
        int daysToShip = 1;

        int currentWeight = 0;
        for (int day = 0; day < weights.length; day++) {
            if (weights[day] > weightCapa) {
                daysToShip = Integer.MAX_VALUE;
                break;
            } else if ((currentWeight + weights[day]) > weightCapa) {
                daysToShip += 1;
                currentWeight = 0;
            }
            currentWeight += weights[day];
        }

        return daysToShip;
    }
}
