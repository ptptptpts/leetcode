class Solution {
    public boolean validMountainArray(int[] arr) {
        boolean isMountainArray = true;

        if (!isExceptionalArray(arr)) {
            // Finding increasing
            int cursor = 2;
            while (cursor < arr.length) {
                if (arr[cursor - 1] == arr[cursor]) {
                    isMountainArray = false;
                    break;
                } else if (arr[cursor - 1] > arr[cursor]) {
                    break;
                }
                cursor += 1;
            }

            // Finding decreasing
            if (isMountainArray) {
                while (cursor < arr.length) {
                    if (arr[cursor - 1] <= arr[cursor]) {
                        isMountainArray = false;
                        break;
                    }
                    cursor += 1;
                }
            }
        } else {
            isMountainArray = false;
        }

        return isMountainArray;
    }

    private boolean isExceptionalArray(int[] arr) {
        return (arr == null)
                || (arr.length < 3)
                || (arr[0] >= arr[1])
                || (arr[arr.length - 2] <= arr[arr.length - 1]);
    }
}
