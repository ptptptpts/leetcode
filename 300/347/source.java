import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] topKFrequentArray = null;

        if (nums != null) {
            HashMap<Integer, Integer> elementCounter = getCountOfElement(nums);

            k = Math.min(k, elementCounter.size());
            int[][] topKFrequentElements = findTopKElementsAndCounts(elementCounter, k);

            topKFrequentArray = new int[k];
            for (int count = 0; count < k; count++) {
                topKFrequentArray[count] = topKFrequentElements[count][0];
            }
        }

        return topKFrequentArray;
    }

    private HashMap<Integer, Integer> getCountOfElement(int[] nums) {
        HashMap<Integer, Integer> elementCounter = new HashMap<>();

        for (int num : nums) {
            int previousCount = elementCounter.computeIfAbsent(num, n -> 0);
            elementCounter.put(num, previousCount + 1);
        }

        return elementCounter;
    }

    private int[][] findTopKElementsAndCounts(HashMap<Integer, Integer> elementCounter, int k) {
        int topKArrayCounter = 0;
        int[][] topKFrequentElements = new int[k][2];

        for (Entry<Integer, Integer> entry : elementCounter.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();

            if (topKArrayCounter < k) {
                topKFrequentElements[topKArrayCounter][0] = element;
                topKFrequentElements[topKArrayCounter][1] = count;
                topKArrayCounter++;

                Arrays.sort(topKFrequentElements, (v1, v2) -> {
                    return v2[1] - v1[1];
                });
            } else {
                if (count > topKFrequentElements[k - 1][1]) {
                    topKFrequentElements[k - 1][0] = element;
                    topKFrequentElements[k - 1][1] = count;
                }

                Arrays.sort(topKFrequentElements, (v1, v2) -> {
                    return v2[1] - v1[1];
                });
            }
        }

        return topKFrequentElements;
    }
}
