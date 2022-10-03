class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lastUnable = 0;
        int firstAble = findMaxBananaInPiles(piles);

        while (lastUnable < (firstAble - 1)) {
            int middleK = (lastUnable + firstAble) / 2;
            if (canKokoEatBananas(piles, h, middleK)) {
                firstAble = middleK;
            } else {
                lastUnable = middleK;
            }
        }

        return firstAble;
    }

    private int findMaxBananaInPiles(int[] piles) {
        int maxBananas = 0;
        for (int banana : piles) {
            maxBananas = Math.max(maxBananas, banana);
        }
        return maxBananas;
    }

    private boolean canKokoEatBananas(int[] piles, int h, int k) {
        long time = 0;
        for (int banana : piles) {
            time += ((banana - 1) / k) + 1;
        }
        return time <= h;
    }
}
