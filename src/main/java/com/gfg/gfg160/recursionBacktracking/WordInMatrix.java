package com.gfg.gfg160.recursionBacktracking;

public class WordInMatrix {
    /**
     * This method checks if a given word exists in a 2D character matrix.
     * The word can be constructed by moving horizontally or vertically through adjacent cells.
     * A cell cannot be used more than once in a single word search.
     *
     * @param mat  The 2D character matrix representing the board.
     * @param word The target word to search for in the matrix.
     * @return {@code true} if the word exists in the matrix, {@code false} otherwise.
     * <p>
     * Edge Cases:
     * - Empty matrix or empty word should return false.
     * - Word longer than total cells should return false.
     * - Multiple paths may exist; any one valid path is sufficient.
     */
    public static boolean isWordExist(char[][] mat, String word) {
        if (mat == null || mat.length == 0 || mat[0].length == 0 || word == null || word.isEmpty()) {
            return false;
        }

        int rowCount = mat.length;
        int colCount = mat[0].length;

        // Iterate through each cell to find the starting letter of the word
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                if (mat[row][col] == word.charAt(0) && searchWord(mat, word, row, col, 0)) {
                    return true; // Word is found
                }
            }
        }
        return false; // Word is not found
    }

    /**
     * Recursive Depth-First Search (DFS) to check if the word exists in the matrix.
     *
     * @param mat   The 2D character matrix.
     * @param word  The target word to search.
     * @param row   Current row index.
     * @param col   Current column index.
     * @param index Current index in the word.
     * @return {@code true} if the word is found, {@code false} otherwise.
     */
    private static boolean searchWord(char[][] mat, String word, int row, int col, int index) {
        // Base case: If all characters are matched, return true
        if (index == word.length()) {
            return true;
        }

        // Boundary conditions and character mismatch check
        if (row < 0 || row >= mat.length || col < 0 || col >= mat[0].length || mat[row][col] != word.charAt(index)) {
            return false;
        }

        // Save the character before modifying it to mark as visited
        char temp = mat[row][col];
        mat[row][col] = '#'; // Mark cell as visited

        // Explore all 4 possible directions (up, down, left, right)
        boolean isFound = searchWord(mat, word, row + 1, col, index + 1) || // Down
                searchWord(mat, word, row - 1, col, index + 1) || // Up
                searchWord(mat, word, row, col + 1, index + 1) || // Right
                searchWord(mat, word, row, col - 1, index + 1);   // Left

        mat[row][col] = temp; // Restore the original character after backtracking

        return isFound;
    }
}
