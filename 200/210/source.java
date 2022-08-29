import java.util.LinkedList;
import java.util.List;

class Solution {
    int[] takenCourses;
    int takenCoursesCursor;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] wantedCourses = new LinkedList[numCourses];
        int[] numberOfPrerequisites = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            numberOfPrerequisites[prerequisite[0]]++;
            if (wantedCourses[prerequisite[1]] == null) {
                wantedCourses[prerequisite[1]] = new LinkedList<>();
            }
            wantedCourses[prerequisite[1]].add(prerequisite[0]);
        }

        takenCoursesCursor = 0;
        takenCourses = new int[numCourses];
        while (takeCourses(wantedCourses, numberOfPrerequisites) > 0) {
        }

        for (int number : numberOfPrerequisites) {
            if (number > 0) {
                return new int[]{};
            }
        }

        return takenCourses;
    }

    private int takeCourses(LinkedList<Integer>[] wantedCourses, int[] numberOfPrerequisites) {
        int numberOfTakenCourses = 0;

        for (int courseId = 0; courseId < numberOfPrerequisites.length; courseId++) {
            if (numberOfPrerequisites[courseId] == 0) {
                numberOfTakenCourses++;
                numberOfPrerequisites[courseId] = -1;
                takenCourses[takenCoursesCursor] = courseId;
                takenCoursesCursor++;

                LinkedList<Integer> wantedCourse = wantedCourses[courseId];
                if (wantedCourse != null) {
                    for (Integer wantedCourseId : wantedCourse) {
                        numberOfPrerequisites[wantedCourseId]--;
                    }
                }
            }
        }

        return numberOfTakenCourses;
    }
}
