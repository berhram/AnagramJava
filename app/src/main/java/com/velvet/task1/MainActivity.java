package com.velvet.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText anagramInput = findViewById(R.id.anagramInput);
        TextView anagramOutput = findViewById(R.id.anagramOutput);
        EditText anagramIgnore = findViewById(R.id.anagramIgnore);
        ArrayList<String> input = new ArrayList<>();
        ArrayList<Character> ignored = new ArrayList<>();
        anagramInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                input.clear();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    if ((s.charAt(i) != ' ')) {
                        if (i == s.length()-1) {
                            temp.append(s.charAt(i));
                            input.add(temp.toString());
                            temp.delete(0, temp.length());
                        }
                        else {
                            temp.append(s.charAt(i));
                        }
                    }
                    else {
                        input.add(temp.toString());
                        temp.delete(0,temp.length());
                    }
                }
                StringBuilder outputStringTemp = new StringBuilder();
                ArrayList<String> outputArrayTemp = AnagramCreator.create(input,ignored);
                for (int i = 0; i < outputArrayTemp.size(); i++) {
                    if (i !=outputArrayTemp.size()-1) {
                        outputStringTemp.append(outputArrayTemp.get(i));
                        outputStringTemp.append(" ");
                    }
                    else {
                        outputStringTemp.append(outputArrayTemp.get(i));
                    }
                }
                anagramOutput.setText(outputStringTemp);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        anagramIgnore.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ignored.clear();
                for (int i = 0; i < s.length(); i++) {
                    ignored.add(s.charAt(i));
                }
                StringBuilder outputStringTemp = new StringBuilder();
                ArrayList<String> outputArrayTemp = AnagramCreator.create(input,ignored);
                for (int i = 0; i < outputArrayTemp.size(); i++) {
                    if (i !=outputArrayTemp.size()-1) {
                        outputStringTemp.append(outputArrayTemp.get(i));
                        outputStringTemp.append(" ");
                    }
                    else {
                        outputStringTemp.append(outputArrayTemp.get(i));
                    }
                }
                anagramOutput.setText(outputStringTemp);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        anagramIgnore.setText("0123456789`~$^+=<>“?/|\\");
    }
}