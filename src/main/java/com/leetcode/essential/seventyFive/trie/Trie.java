package com.leetcode.essential.seventyFive.trie;

public class Trie {
    // Each Trie node can have at most 26 children for each letter of the alphabet.
    private Trie[] children;
    // isEndOfWord is true if the node represents the end of a word.
    private boolean isEndOfWord;

    // Constructor initializes the Trie node with an empty array for child nodes.
    public Trie() {
        children = new Trie[26];
        isEndOfWord = false;
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        Trie currentNode = this;
        for (char letter : word.toCharArray()) {
            int index = letter - 'a'; // Calculate the index corresponding to the letter.
            // If the letter doesn't have a corresponding Trie node, create one.
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new Trie();
            }
            // Move to the next Trie node.
            currentNode = currentNode.children[index];
        }
        // Mark the end of a word.
        currentNode.isEndOfWord = true;
    }

    // Searches if the word exists in the trie.
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        // If the node is not null and isEndOfWord is true, the word exists in the trie.
        return node != null && node.isEndOfWord;
    }

    // Checks if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        // If the node is not null, there is a word that starts with the prefix.
        return node != null;
    }

    // Helper method to search for a prefix or a whole word in the trie and return the node where the search ends.
    private Trie searchPrefix(String s) {
        Trie currentNode = this;
        for (char letter : s.toCharArray()) {
            int index = letter - 'a';
            if (currentNode.children[index] == null) {
                // If the next node doesn't exist, return null indicating the prefix doesn't exist.
                return null;
            }
            // Move to the next Trie node.
            currentNode = currentNode.children[index];
        }
        return currentNode; // The node where the search ended, could represent the prefix or the whole word.
    }
}
