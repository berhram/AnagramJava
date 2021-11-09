package com.velvet.task1;

import java.util.Arrays;

public class AnagramCreator {
    static public String create(CharSequence input, CharSequence ignored) {
        String[] inputArray = input.toString().split("");
        String[] ignoredArray = ignored.toString().split("");
        StringBuilder output = new StringBuilder();
        int cursor = 0;
        int wordEnd = 0;
        while (cursor < inputArray.length) {
            if ((Arrays.asList(ignoredArray).contains(inputArray[cursor]))||(inputArray[cursor].equals(" "))) {
                wordEnd = cursor;
                output.insert(wordEnd,inputArray[cursor]);
                cursor++;
                wordEnd = cursor;
            }
            else {
                output.insert(wordEnd,inputArray[cursor]);
                cursor++;
            }
        }
        return output.toString();
    }
}
