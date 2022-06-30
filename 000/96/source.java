class Solution {
    public int numTrees(int n) {
        int[] numTrees = new int[n + 1];

        numTrees[0] = 1;
        numTrees[1] = 1;
        for (int i = 2; i < numTrees.length; i++) {
            numTrees[i] = 0;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int left = j - 1;
                int right = i - j;
                numTrees[i] += numTrees[left] * numTrees[right];
            }
        }

        return numTrees[n];
    }
}
