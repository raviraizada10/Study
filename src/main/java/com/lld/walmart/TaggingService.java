package com.lld.walmart;

import java.util.*;

class Tag {
    String id;
    String name;
    String createdBy;

    public Tag(String id, String name, String createdBy) {
        this.id = id;
        this.name = name;
        this.createdBy = createdBy;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}

class Page {
    String id;
    String url;

    public Page(String id, String url) {
        this.id = id;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}


public class TaggingService {
    Map<String, Set<Tag>> pageToTags;
    Map<String, Set<Page>> tagToPages;
    Map<String, Tag> tagStore;
    Map<String, Page> pageStore;
    Trie userTrie; // for live prefix
    Trie sharedTrie; // eventual trie updated via async queue

    public TaggingService() {
        pageToTags = new HashMap<>();
        tagToPages = new HashMap<>();
        tagStore = new HashMap<>();
        pageStore = new HashMap<>();
        userTrie = new Trie();
        sharedTrie = new Trie();
    }

    public boolean tagExists(String tagName) {
        return tagStore.containsKey(tagName);
    }

    public void createTag(String tagName, String userId) {
        String tagId = "tag_" + tagName.hashCode();
        Tag newTag = new Tag(tagId, tagName, userId);
        tagStore.put(tagName, newTag);
    }

    public void linkTagToPage(String pageId, String tagName) {
        Tag tag = tagStore.get(tagName);
        Page page = pageStore.get(pageId);
        if (tag == null || page == null) return;

        pageToTags
                .computeIfAbsent(pageId, k -> new HashSet<>())
                .add(tag);
        tagToPages
                .computeIfAbsent(tagName, k -> new HashSet<>())
                .add(page);
    }

    public void addTagToPage(String pageId, String tagName, String userId) {
        if (!tagExists(tagName)) createTag(tagName, userId);
        linkTagToPage(pageId, tagName);
        userTrie.insert(tagName); // live for user
        publishToKafka(tagName);  // async update for shared trie
    }

    List<String> getTagsByPrefix(String prefix, String userId) {
        return userTrie.getTags(prefix); // for current user
    }

    Set<Tag> getTagsForPage(String pageId) {
        return pageToTags.getOrDefault(pageId, Collections.emptySet());
    }

    Set<Page> getPagesForTag(String tagName) {
        return tagToPages.getOrDefault(tagName, Collections.emptySet());
    }

    public void publishToKafka(String tagName) {
        // Dummy async update simulation
        sharedTrie.insert(tagName);
    }
}
