package com.velvet.task1;

public class AnagramCreator {
    static public String create(String input, String ignored) {
        String[] words = input.toString().split(" ");
        StringBuilder output = new StringBuilder();
        for (String word : words) {
            output.append(reverseWord(word,ignored));
            output.append(" ");
        }
        return output.toString();
    }
    private static String reverseWord(String input, String ignored) {
        StringBuilder output = new StringBuilder(input);
        int i = 0;
        int j = input.length() - 1;
        while (i < j)
        {
            if (ignored.indexOf(Character.toString(input.charAt(i)))!=-1)
                i++;
            else if(ignored.indexOf(Character.toString(input.charAt(j)))!=-1)
                j--;
            else
            {
                String tmp = Character.toString(output.charAt(i));
                output.replace(i,i+1,Character.toString(output.charAt(j)));
                output.replace(j,j+1,tmp);
                i++;
                j--;
            }
        }
        return output.toString();
    }
}
