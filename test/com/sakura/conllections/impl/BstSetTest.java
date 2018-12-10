package com.sakura.conllections.impl;

import com.sakura.conllections.Set;

import java.util.ArrayList;

public class BstSetTest {

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("E:\\IdeaProjects-github\\Data-Structures-Project\\test\\com" +
                "\\sakura\\conllections\\impl\\pride-and-prejudice.txt", words1);
        System.out.println("Total words: " + words1.size());

        Set<String> set1 = new BstSet<>();
        for (String word : words1) {
            set1.add(word);
        }
        System.out.println("Total different words: " + set1.getSize());

        System.out.println();

        System.out.println("A Tale Of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        FileOperation.readFile("E:\\IdeaProjects-github\\Data-Structures-Project\\test\\com\\sakura\\" +
                "conllections\\impl\\a-tale-of-two-cities.txt", words2);
        System.out.println("Total words: " + words1.size());

        Set<String> set2 = new BstSet<>();
        for (String word : words2) {
            set2.add(word);
        }
        System.out.println("Total different words: " + set2.getSize());
    }
}
