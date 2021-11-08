package com.velvet.task1;

import android.util.Log;

import java.util.ArrayList;

public class AnagramCreator {
    static public String create(CharSequence input, CharSequence ignored) {
        StringBuilder inputSB = new StringBuilder(input);
        StringBuilder ignoredSB = new StringBuilder(ignored);
        ignoredSB.append(" ");
        StringBuilder output = new StringBuilder();
        if (inputSB.length()>=1) {
            int tempReverted = 0;
            int tempConst = 0;
            String previous1 = "N";
            for (int i = 0; i < inputSB.length(); i++) {
                if (ignoredSB.indexOf(Character.toString(inputSB.charAt(i))) != -1) {
                    if ((previous1 == "R") || (previous1 == "N")) {
                        tempConst++;
                        previous1 = "C";
                    }
                }
                else {
                    if ((previous1 == "C") || (previous1 == "N")) {
                        tempReverted++;
                        previous1 = "R";
                    }
                }
            }
            int tempCounter = 0;
            String previous2 = "N";
            StringBuilder[] wordArray = new StringBuilder[tempConst + tempReverted];
            for (int i = 0; i < wordArray.length; i++) {
                wordArray[i] = new StringBuilder("");
            }
            for (int i = 0; i < inputSB.length(); i++) {
                if (ignoredSB.indexOf(Character.toString(inputSB.charAt(i))) != -1) {
                    if ((previous2 == "C") || (previous2 == "N")) {
                        wordArray[tempCounter].append(inputSB.charAt(i));
                        previous2 = "C";
                    }
                    else {
                        tempCounter++;
                        wordArray[tempCounter].append(inputSB.charAt(i));
                        previous2 = "C";
                    }
                }
                else {
                    if ((previous2 == "R") || (previous2 == "N")) {
                        wordArray[tempCounter].append(inputSB.charAt(i));
                        previous2 = "R";
                    }
                    else {
                        tempCounter++;
                        wordArray[tempCounter].append(inputSB.charAt(i));
                        previous2 = "R";
                    }
                }
            }
            for (int i = 0; i < wordArray.length; i++) {
                if (ignoredSB.indexOf(Character.toString(wordArray[i].charAt(0))) != -1) {
                    output.append(wordArray[i].toString());
                }
                else {
                    output.append(wordArray[i].reverse().toString());
                }
            }
        }
        else {
            output.append(inputSB);
        }
        return output.toString();
    }
}
