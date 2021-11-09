package com.velvet.task1;

import java.util.Arrays;

public class AnagramCreator {
    static public String create(CharSequence input, CharSequence ignored) {
        String[] words = input.toString().split(" ");
        StringBuilder ignoredSB = new StringBuilder(ignored);
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            output.append(reverseWord(words[i],ignoredSB));
            output.append(" ");
        }
        return output.toString();
    }
    private static String reverseWord(String input, StringBuilder ignoredSB) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (ignoredSB.indexOf(Character.toString(input.charAt(i)))==-1) {
                output.insert(0,input.charAt(i));
            }
        }
        for (int i = 0; i < input.length(); i++) {
            if (ignoredSB.indexOf(Character.toString(input.charAt(i)))!=-1) {
                output.insert(i,input.charAt(i));
            }
        }
        return output.toString();
    }
}
