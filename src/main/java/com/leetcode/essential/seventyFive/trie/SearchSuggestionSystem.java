package com.leetcode.essential.seventyFive.trie;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.*;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.*;

@DifficultyLevel(MEDIUM)
@ProblemCategory({TRIE, ARRAY, STRING, BINARY_SEARCH, SORTING})
@ProblemInfo(problemLink = "https://leetcode.com/problems/search-suggestions-system/description/", problemNumber = "1268", solutionLink = "https://algo.monster/liteproblems/1268")
public class SearchSuggestionSystem {

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        PriorityQueue<String> suggestions = new PriorityQueue<>((a, b) -> b.compareTo(a)); // max-heap
    }

    private void insert(TrieNode root, String product) {
        TrieNode node = root;
        for (char c : product.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
            node.suggestions.offer(product);
            if (node.suggestions.size() > 3) {
                node.suggestions.poll(); // keep only smallest 3
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();

        Arrays.sort(products); // optional: helps lexicographic pruning

        // Step 1: Build the Trie
        for (String product : products) {
            insert(root, product);
        }

        // Step 2: Walk the Trie for each prefix
        List<List<String>> result = new ArrayList<>();
        TrieNode node = root;

        for (char c : searchWord.toCharArray()) {
            if (node != null) node = node.children.get(c);

            if (node == null) {
                result.add(new ArrayList<>());
            }
            else {
                List<String> curr = new ArrayList<>(node.suggestions);
                Collections.sort(curr); // convert max-heap to lex order
                result.add(curr);
            }
        }

        return result;
    }
}   