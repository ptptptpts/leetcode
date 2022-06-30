import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] ret = new int[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<int[]>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j, 0});
                }
                ret[i][j] = -1;
            }
        }

        int[] pos;
        while ((pos = queue.poll()) != null) {
            if (ret[pos[0]][pos[1]] == -1) {
                ret[pos[0]][pos[1]] = pos[2];

                if (pos[0] > 0) {
                    queue.add(new int[]{pos[0] - 1, pos[1], pos[2] + 1});
                }
                if (pos[0] < mat.length - 1) {
                    queue.add(new int[]{pos[0] + 1, pos[1], pos[2] + 1});
                }
                if (pos[1] > 0) {
                    queue.add(new int[]{pos[0], pos[1] - 1, pos[2] + 1});
                }
                if (pos[1] < mat[0].length - 1) {
                    queue.add(new int[]{pos[0], pos[1] + 1, pos[2] + 1});
                }
            }
        }

        return ret;
    }
}
