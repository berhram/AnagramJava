package com.velvet.anagrams;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText anagramInput = findViewById(R.id.anagramInput);
        final TextView anagramOutput = findViewById(R.id.anagramOutput);
        final EditText anagramIgnore = findViewById(R.id.anagramIgnore);
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                anagramOutput.setText(AnagramCreator.create(anagramInput.getText().toString(),anagramIgnore.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        anagramInput.addTextChangedListener(textWatcher);
        anagramIgnore.addTextChangedListener(textWatcher);
    }
}