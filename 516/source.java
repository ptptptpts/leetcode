class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();

        int[][] arr = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                arr[i][j] = 0;
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            arr[i][i] = 1;
            char c = s.charAt(i);
            for (int j = i + 1; j < len; j++) {
                if (c == s.charAt(j)) {
                    arr[i][j] = arr[i + 1][j - 1] + 2;
                } else {
                    arr[i][j] = Math.max(arr[i + 1][j], arr[i][j - 1]);
                }
            }
        }

        return arr[0][len - 1];
    }
}
