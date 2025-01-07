package com.leetcode.essential.seventyFive.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//https://leetcode.com/problems/binary-tree-right-side-view/
//https://algo.monster/liteproblems/199
public class RightSideView {
    /**
     * Returns the right-side view of a binary tree.
     *
     * @param root The root of the binary tree.
     * @return A list of integers representing the right-side view of the binary tree.
     */
    public List<Integer> rightSideView(TreeNode root) {
        // Initialize the result list to store the right-side view.
        List<Integer> answer = new ArrayList<>();

        // If the tree is empty, return an empty list.
        if (root == null) return answer;

        // Use a deque (double-ended queue) for level-order traversal.
        Deque<TreeNode> executionQueue = new ArrayDeque<>();
        // Start with the root node.
        executionQueue.offer(root);

        // Continue traversing the tree until the queue is empty.
        while (!executionQueue.isEmpty()) {
            // Add the value of the last node in the current level to the result list.
            answer.add(executionQueue.peekLast().val);

            // Process all nodes at the current level.
            for (int i = executionQueue.size(); i > 0; --i) {
                // Remove the node from the front of the queue.
                TreeNode currentNode = executionQueue.poll();

                // Add the left child to the queue if it exists.
                if (currentNode.left != null) {
                    executionQueue.offer(currentNode.left);
                }
                // Add the right child to the queue if it exists.
                if (currentNode.right != null) {
                    executionQueue.offer(currentNode.right);
                }
            }
        }
        // Return the result list which contains the right-side view.
        return answer;
    }
}
