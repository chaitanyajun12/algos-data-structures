package com.ib.stackqueue;

import java.util.Stack;

/**
 * Created by krishna.m1 on 21/12/16.
 */
public class SimplifyPath {
    private final String CD_DIR = "..";
    private final String CURR_DIR = ".";

    public String simplifyPath(String a) {
        if (a == null || a.length() == 1) {
            return a;
        }

        String pathComponents[] = a.split("/");
        int N = pathComponents.length;

        Stack<String> pathStack = new Stack<>();
        for (int i = 1; i < N; i++) {
            if (pathComponents[i].equals(CD_DIR)) {
                if (!pathStack.isEmpty()) pathStack.pop();
            } else if (!pathComponents[i].equals(CURR_DIR) && pathComponents[i].length() != 0) {
                    pathStack.add(pathComponents[i]);
            }
        }

        if (pathStack.isEmpty()) return "/";

        String result = "";
        while (!pathStack.isEmpty()) result = "/" + pathStack.pop() + result;
        return result;
    }

    public static void main(String argsp[]) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/home//foo"));
    }
}
