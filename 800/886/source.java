import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<Integer>[] listOfDislikes = new ArrayList[n + 1];

        for (int cursor = 0; cursor <= n; cursor++) {
            listOfDislikes[cursor] = new ArrayList<>();
        }

        for (int[] dislike : dislikes) {
            listOfDislikes[dislike[0]].add(dislike[1]);
            listOfDislikes[dislike[1]].add(dislike[0]);
        }

        boolean[] isGroupA = new boolean[n + 1];
        boolean[] isGroupB = new boolean[n + 1];
        Arrays.fill(isGroupA, false);
        Arrays.fill(isGroupB, false);

        boolean canMakeGroup = true;
        for (int cursor = 1; cursor <= n; cursor++) {
            // Traverse the dislikes by DFS
            // If person A dislike person B, they should be located in the other groups
            // If person A is disliked by person C, the person C should be located in the other group with person A
            if (!isGroupA[cursor] && !isGroupB[cursor]) {
                if (!groupingPerson(listOfDislikes, isGroupA, isGroupB, cursor, true)) {
                    canMakeGroup = false;
                    break;
                }
            }
        }
        return canMakeGroup;
    }

    private boolean groupingPerson(ArrayList<Integer>[] listOfDislikes, boolean[] isGroupA,
            boolean[] isGroupB, int personId, boolean isGroupAPerson) {
        boolean canMakeGroup = true;

        if (isGroupA[personId] || isGroupB[personId]) {
            if ((isGroupAPerson && isGroupB[personId]) || (!isGroupAPerson && isGroupA[personId])) {
                canMakeGroup = false;
            }
        } else {
            if (isGroupAPerson) {
                isGroupA[personId] = true;
            } else {
                isGroupB[personId] = true;
            }

            for (Integer dislikePersonId : listOfDislikes[personId]) {
                if (!groupingPerson(listOfDislikes, isGroupA, isGroupB, dislikePersonId,
                        !isGroupAPerson)) {
                    canMakeGroup = false;
                    break;
                }
            }
        }

        return canMakeGroup;
    }
}
