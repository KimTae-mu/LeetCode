package com.alva.LeetCode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class SimplifyPath {

    static String PREVIOUS = "..";
    static String SLASH = "/";
    static String THIS = ".";


    public String simplifyPath(String path) {
        if (path == null || path.length() <= 0 || !path.startsWith("/")) {
            return path;
        }

        Stack<String> stack = new Stack<String>();

        String[] split = path.split("/");
        stack.push(split[0]);

        for (int i = 1; i < split.length; i++) {
            if (split[i].equals("")) {
                if (stack.peek().equals(SLASH)) {
                    continue;
                } else {
                    stack.push(SLASH);
                    continue;
                }
            }
            if (stack.empty()) {
                stack.push(split[i]);
            } else {
                if (split[i].equals(PREVIOUS)) {
                    stack.pop();
                    continue;
                }else if(split[i].equals(SLASH)){

                }
            }
        }
        return path;
    }
}
