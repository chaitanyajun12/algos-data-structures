package com.ib.strings;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by krishna.m1 on 17/01/17.
 */
public class PrettyJson {
    private String getSpace(Stack<String> stack) {
        if (stack.isEmpty())
            return "";
        return stack.peek();
    }

    public ArrayList<String> prettyJSON(String a) {
        if (a == null) {
            return null;
        }

        Stack<String> spaceStack = new Stack<>();
        int N = a.length();
        ArrayList<String> lines = new ArrayList<>();
        boolean lineStart = false;

        for (int i = 0; i < N; i++) {
            if (a.charAt(i) == ' ')
                continue;

            if (a.charAt(i) == '[' || a.charAt(i) == '{') {
                lines.add(getSpace(spaceStack) + Character.toString(a.charAt(i)));

                if (spaceStack.isEmpty()) {
                    spaceStack.push("\t");
                } else {
                    spaceStack.push(spaceStack.peek() + "\t");
                }

                lineStart = true;

            } else if (a.charAt(i) == ']' || a.charAt(i) == '}') {
                if (!spaceStack.isEmpty()) {
                    spaceStack.pop();
                }

                lines.add(getSpace(spaceStack) + Character.toString(a.charAt(i)));
                if (i + 1 < N && a.charAt(i + 1) == ',') {
                    lines.set(lines.size() - 1, lines.get(lines.size() - 1) + ",");
                    i += 1;
                }

                lineStart = true;

            } else {
                if (lineStart) {
                    lines.add(spaceStack.peek());
                    lineStart = false;
                }

                lines.set(lines.size() - 1, lines.get(lines.size() - 1) + "" + a.charAt(i));
                if (a.charAt(i) == ',') {
                    lineStart = true;
                }
            }
        }

        return lines;
    }

    public static void main(String args[]) {
        PrettyJson prettyJson = new PrettyJson();
        ArrayList<String> lines = prettyJson.prettyJSON("{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}");

        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
    }
}
