class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] pointArray = new int[10001];
        for (int i = 0; i < pointArray.length; i++) {
            pointArray[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            pointArray[nums[i]] += 1;
        }

        int[] maxPointArray = new int[]{0, 0, 0, 0};
        int cursor = 1;
        int positiveCounter = 0;

        for (int i = 1; i < pointArray.length; i++) {
            if (pointArray[i] > 0) {
                positiveCounter += 1;
                cursor = (cursor + 1) & 0b11;
                int pp = maxPointArray[(cursor + 2) & 0b11];
                int ppp = maxPointArray[(cursor + 1) & 0b11];
                maxPointArray[cursor] = Math.max(pp, ppp) + (i * pointArray[i]);

            } else if (positiveCounter > 0) {
                positiveCounter = 0;
                maxPointArray[cursor] = Math.max(maxPointArray[cursor],
                    maxPointArray[(cursor + 3) & 0b11]);
                for (int j = 0; j < maxPointArray.length; j++) {
                    maxPointArray[j] = maxPointArray[cursor];
                }
            }
        }

        return Math.max(maxPointArray[cursor],
            maxPointArray[(cursor + 3) & 0b11]);
    }
}
