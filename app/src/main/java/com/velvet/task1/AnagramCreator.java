package com.velvet.task1;

import java.util.ArrayList;

public class AnagramCreator {
    static public ArrayList<String> create(ArrayList<String> input, ArrayList<Character> ignored) {
        ArrayList<String> output = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < input.get(i).length(); j++) {
                if (ignored.contains(input.get(i).charAt(j))!=true) {
                    temp.insert(0, input.get(i).charAt(j));
                }
                else {
                    temp.insert(j, input.get(i).charAt(j));
                }
            }
            output.add(temp.toString());
        }

        return output;
    }
}
