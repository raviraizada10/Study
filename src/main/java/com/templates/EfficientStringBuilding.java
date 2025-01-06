package com.templates;

public class EfficientStringBuilding {
    public String fn(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char c: arr) {
            sb.append(c);
        }

        return sb.toString();
    }
}
