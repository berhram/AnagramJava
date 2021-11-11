package com.velvet.task1;

public class AnagramCreator {
    static public String create(String input, String ignored) {
        String[] words = input.split(" ");
        StringBuilder output = new StringBuilder();
        for (String word : words) {
            output.append(reverseWord(word,ignored));
            output.append(" ");
        }
        return output.toString().trim();
    }
    private static String reverseWord(String input, String ignored) {
        char[] output  = input.toCharArray();
        int i = 0;
        int j = input.length() - 1;
        while (i < j)
        {
            if (ignored.indexOf(input.charAt(i))!=-1) {
                i++;
            }
            else if(ignored.indexOf(input.charAt(j))!=-1) {
                j--;
            }
            else
            {
                char tmp = output[i];
                output[i] = output[j];
                output[j] = tmp;
                i++;
                j--;
            }
        }
        return new String(output);
    }
}
