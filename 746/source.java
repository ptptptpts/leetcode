class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minimumCostArray = new int[] {0, 0, 0};
        int cursor = 1;

        for (int i = 2; i < cost.length; i++) {
            cursor = (cursor + 1) % 3;
            int previousCost = minimumCostArray[(cursor + 2) % 3] + cost[i - 1];
            int ppreviousCost = minimumCostArray[(cursor + 1) % 3] + cost[i - 2];
            minimumCostArray[cursor] = Math.min(previousCost, ppreviousCost);
        }

        int lastCursor = (cursor + 2) % 3;
        return Math.min(minimumCostArray[cursor] + cost[cost.length - 1],
                minimumCostArray[lastCursor] + cost[cost.length - 2]);
    }
}
