package com.sakura.stack;

import com.sakura.stack.impl.ArrayStackImpl;

public class StackTest {

    public boolean isValid(String s) {
        ArrayStackImpl<Character> stack = new ArrayStackImpl<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }

                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input1 = "()";
        System.out.println(new StackTest().isValid(input1)); // true

        String input2 = "()[]{}";
        System.out.println(new StackTest().isValid(input2)); // true

        String input3 = "(]";
        System.out.println(new StackTest().isValid(input3)); // false

        String input4 = "([)]";
        System.out.println(new StackTest().isValid(input4)); // false

        String input5 = "{[]}";
        System.out.println(new StackTest().isValid(input5)); // true
    }
}
