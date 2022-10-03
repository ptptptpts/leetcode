class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        if (arr[0] > arr[1]) {
            return 0;
        } else if (arr[arr.length - 2] < arr[arr.length - 1]) {
            return arr.length - 1;
        }

        int start = 0;
        int end = arr.length;

        while (start < end - 3) {
            int middle = (start + end) / 2;

            if ((arr[middle - 1] < arr[middle]) && (arr[middle] < arr[middle + 1])) {
                // m-1 < m < m+1: peak is in a right side
                start = middle;
            } else if ((arr[middle - 1] > arr[middle]) && (arr[middle] > arr[middle + 1])) {
                // m-1 > m > m+1: peak is in a left side
                end = middle + 1;
            } else {
                // m-1 < m > m+1: peak is a middle
                start = middle - 1;
                end = middle + 2;
            }
        }

        return (start + end) / 2;
    }
}
