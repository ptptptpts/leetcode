import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            if (image[pos[0]][pos[1]] != -1) {
                int curColor = image[pos[0]][pos[1]];
                if ((pos[0] > 0) && (image[pos[0] - 1][pos[1]]) == curColor) {
                    queue.add(new int[]{pos[0] - 1, pos[1]});
                }
                if ((pos[0] < (m - 1)) && (image[pos[0] + 1][pos[1]]) == curColor) {
                    queue.add(new int[]{pos[0] + 1, pos[1]});
                }
                if ((pos[1] > 0) && (image[pos[0]][pos[1] - 1]) == curColor) {
                    queue.add(new int[]{pos[0], pos[1] - 1});
                }
                if ((pos[1] < (n - 1)) && (image[pos[0]][pos[1] + 1]) == curColor) {
                    queue.add(new int[]{pos[0], pos[1] + 1});
                }

                image[pos[0]][pos[1]] = -1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (image[i][j] == -1) {
                    image[i][j] = newColor;
                }
            }
        }

        return image;
    }
}
