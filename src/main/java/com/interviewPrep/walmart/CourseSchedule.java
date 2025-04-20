package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.ArrayList;
import java.util.List;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/course-schedule/description/", problemNumber = "207", solutionLink = "https://algo.monster/liteproblems/207")
public class CourseSchedule {
    /**
     * 📝 Course Schedule – Topological Sort via DFS (Cycle Detection)
     * Model courses as a directed graph, with edges representing prerequisites.
     * Use DFS with a state array (unvisited, visiting, visited) to detect cycles.
     * If you encounter a node that’s already being visited (state = visiting), a cycle exists — return false.
     * If no cycles are found after DFS from all nodes, it’s possible to finish all courses.
     *
     * @param numCourses    total number of courses
     * @param prerequisites array of prerequisite pairs [a, b] meaning b -> a
     * @return true if all courses can be finished (no cycle), false otherwise
     * <p>
     * Edge Cases:
     * - No prerequisites: all courses are independent, return true
     * - A cycle exists: return false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int[] courseState = new int[numCourses]; // 0 = unvisited, 1 = visiting, 2 = visited

        // Initialize graph with empty adjacency lists
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Build adjacency list from prerequisites: course B -> course A
        for (int[] prerequisite : prerequisites) {
            adjacencyList
                    .get(prerequisite[1])
                    .add(prerequisite[0]);
        }

        // Check for cycle starting from each unvisited course
        for (int course = 0; course < numCourses; course++) {
            if (hasCycle(course, adjacencyList, courseState)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper function to detect a cycle using DFS.
     *
     * @param course        current course index
     * @param adjacencyList graph represented as adjacency list
     * @param courseState   array to track state of each course (0, 1, 2)
     * @return true if a cycle is detected starting from this node, false otherwise
     */
    private boolean hasCycle(int course, List<List<Integer>> adjacencyList, int[] courseState) {
        if (courseState[course] == 1) return true;  // currently visiting, so a cycle
        if (courseState[course] == 2) return false; // already visited, no cycle from here

        courseState[course] = 1; // mark as visiting

        for (Integer neighbor : adjacencyList.get(course)) {
            if (hasCycle(neighbor, adjacencyList, courseState)) {
                return true;
            }
        }

        courseState[course] = 2; // mark as visited
        return false;
    }
}