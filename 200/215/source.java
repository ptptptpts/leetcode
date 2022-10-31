import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int kthLargest = Integer.MIN_VALUE;

        if ((nums != null) && (k <= nums.length)) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();

            for (int num : nums) {
                if (heap.size() < k) {
                    heap.add(num);
                } else if (num > heap.peek()) {
                    heap.poll();
                    heap.add(num);
                }
            }

            kthLargest = heap.peek();
        }

        return kthLargest;
    }
}
