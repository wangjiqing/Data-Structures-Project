package com.sakura.stack;

import com.sakura.stack.impl.LinkedListStackImpl;

public class LinkedListStackTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedListStackImpl<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
