package com.lld.walmart;

import java.util.*;

public class FileSystem {
    class Node {
        boolean isFile = false;
        Map<String, Node> children = new HashMap<>();
        StringBuilder content = new StringBuilder();
    }

    private Node root;

    public FileSystem() {
        root = new Node(); // root directory
    }

    private Node traverse(String path) {
        Node cur = root;
        if (path.equals("/")) return cur;
        for (String part : path.split("/")) {
            if (part.isEmpty()) continue;
            cur.children.putIfAbsent(part, new Node());
            cur = cur.children.get(part);
        }
        return cur;
    }

    public void mkdir(String path) {
        traverse(path); // Just ensures the path is created
    }

    public void addContentToFile(String filePath, String content) {
        Node node = traverse(filePath);
        node.isFile = true;
        node.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        return traverse(filePath).content.toString();
    }

    public List<String> ls(String path) {
        Node node = traverse(path);
        if (node.isFile) {
            String[] parts = path.split("/");
            return Arrays.asList(parts[parts.length - 1]);
        }
        List<String> res = new ArrayList<>(node.children.keySet());
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        fs.mkdir("/a/b");
        fs.addContentToFile("/a/b/file.txt", "hello");
        fs.readContentFromFile("/a/b/file.txt"); // "hello"
        fs.ls("/a/b"); // ["file.txt"]
        fs.ls("/"); // ["a"]
    }
}
