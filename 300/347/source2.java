import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] topKFrequentArray = null;

        if (nums != null) {
            HashMap<Integer, Integer> elementCounter = getCountOfElement(nums);

            k = Math.min(k, elementCounter.size());
            PriorityQueue<int[]> topKFrequentHeap = findTopKElementsAndCounts(elementCounter, k);

            topKFrequentArray = new int[k];
            for (int count = 0; count < k; count++) {
                topKFrequentArray[count] = topKFrequentHeap.poll()[0];
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

    private PriorityQueue<int[]> findTopKElementsAndCounts(HashMap<Integer, Integer> elementCounter, int k) {
        PriorityQueue<int[]> topKFrequentHeap = new PriorityQueue<>((v1, v2) -> v1[1] - v2[1]);

        for (Entry<Integer, Integer> entry : elementCounter.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();

            if (topKFrequentHeap.size() < k) {
                topKFrequentHeap.add(new int[]{element, count});
            } else {
                if (count > topKFrequentHeap.peek()[1]) {
                    topKFrequentHeap.poll();
                    topKFrequentHeap.add(new int[]{element, count});
                }
            }
        }

        return topKFrequentHeap;
    }
}
